(function(){
    angular
        .module("PlagiarismChecker")
        .factory('UserService', userService);

    function userService($http) {

        var api = {
            "login": login,
        };
        return api;

        function login(user) {
            return $http.post("/rest/user/login", user)
                .then(function(res){
                    return res.data;
                });
        }
    }
})();