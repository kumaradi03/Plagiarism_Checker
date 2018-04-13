(function(){
    angular
        .module("PlagiarismChecker")
        .controller("RegisterController", RegisterController);

    function RegisterController(UserService, $location, $scope) {
        var vm = this;
        vm.createUser = createUser;
        vm.logout = logout;

        function createUser (user) {
            if($scope.registerNew.$valid){
                if(user.password === user.verifypassword)
                {
                    UserService
                        .register(user)
                        .then(function (usr) {
                            if(usr !== "")
                                $location.url('/profile/'+ usr.id);
                            else
                                vm.error = "User with username already exists";
                        });
                }
                else
                    vm.error = "Passwords mismatch.";
            }
            else{
                $scope.registerNew.submitted = true;
                vm.error ="Form Incomplete";
            }
        }

        function logout() {
            UserService
                .logout()
                .then(function (res) {
                    $location.url("/login");
                },function (err) {
                    $location.url("/login");
                });
        }
    }
})();