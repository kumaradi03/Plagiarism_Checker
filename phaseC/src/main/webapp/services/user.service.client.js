(function(){
    angular
        .module("PlagiarismChecker")
        .factory('UserService', UserService);

    function UserService($http) {

        var api = {
            "login": login,
            "findUserByUsername": findUserByUsername,
            "register": register,
            "findUserById": findUserById
        };
        return api;

        function login(user) {
            return $http.post("/rest/user/login", user)
                .then(function(res){
                    return res.data;
                });
        }

        function findUserByUsername(username) {
            return $http.get("/rest/user/findUserByUsername?username="+username)
                .then(function(res){
                    return res.data;
                });
        }

        function findUserById(userId) {
            return $http.get("/rest/user/findUserByUserId/?userId="+userId)
                .then(function(res){
                    return res.data;
                });
        }

        function register(user) {
            return $http.post("/rest/user/registerUser", user)
                .then(function(res){
                    return res.data;
                });
        }
    }
})();