(function(){
    angular
        .module("PlagiarismChecker")
        .controller("LoginController", LoginController);

    function LoginController(UserService, $location) {
        var vm = this;
        vm.login = login;

        function login(user) {
            UserService
                .findUserByUsername(user.username)
                .then(function (loginUser) {
                    if(loginUser != "") {
                        if(loginUser.password == user.password)
                            $location.url('/profile/'+ loginUser.id);
                        else
                            vm.error = "Username and Password doesnt match"
                    }
                    else
                        vm.error = 'User not found.';
                });
        }

    }
})();