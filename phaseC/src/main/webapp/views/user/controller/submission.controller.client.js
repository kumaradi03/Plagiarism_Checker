(function(){
    angular
        .module("PlagiarismChecker")
        .controller("SubmissionController", SubmissionController);

    function SubmissionController (UserService, $location, $routeParams) {
        var vm = this;
        var userId = $routeParams['uid'];
        var hwId = $routeParams['hid'];
        vm.openNav = openNav;
        vm.closeNav = closeNav;

        function openNav(type) {
            if(type === "Professor"){
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }
        }

        /* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
        function closeNav(type) {
            if(type === "Professor"){
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft = "0";
            }
        }

        UserService
            .findUserById(userId)
            .then(function (user) {
                vm.user = user;
                UserService
                    .getDistinctUsersForHw(hwId)
                    .then(function (users) {
                        if(users.length == 0)
                            vm.error = "No submission.";
                        else
                            vm.users = users;
                        });
                openNav(vm.user.userType);
            });
    }
})();