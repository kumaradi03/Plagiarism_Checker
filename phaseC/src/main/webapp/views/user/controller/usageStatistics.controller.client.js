(function(){
    angular
        .module("PlagiarismChecker")
        .controller("UsageStatisticsController", UsageStatisticsController);

    function UsageStatisticsController ($location, $routeParams, UserService, UsageStatisicsService) {
        var vm = this;
        vm.userId = $routeParams['uid'];
        vm.openNav = openNav;
        vm.closeNav = closeNav;
        vm.logout = logout;

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

        function logout() {
            UserService
                .logout()
                .then(function (res) {
                    $location.url("/login");
                },function (err) {
                    $location.url("/login");
                });
        }

        UsageStatisicsService
            .findAllUsageStatisticsByProfessor(vm.userId)
            .then(function (reports) {
                console.log(reports);
                if(reports.length === 0)
                    vm.error = "No reports.";
                else {
                    vm.reports = reports;
                }
                openNav("Professor");
            });

    }
})();