(function(){
    angular
        .module("PlagiarismChecker")
        .controller("LoginController", LoginController);

    function LoginController(UserService, $location,$scope) {
        var vm = this;
        vm.login = login;

        function login(user) {
            UserService
                .login(user)
                .then(function (loginUser) {
                    if(loginUser) {
                    }
                    else
                        vm.error = 'User not found.';
                    },(function (err) {
                        vm.error = "Username and Password doesn't match."
                    }));
            }
    }
})();