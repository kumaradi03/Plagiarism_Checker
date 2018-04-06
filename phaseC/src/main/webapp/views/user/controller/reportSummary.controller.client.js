(function(){
    angular
        .module("PlagiarismChecker")
        .controller("ReportSummaryController", ReportSummaryController);

    function ReportSummaryController (ReportService, $location, $routeParams) {
        var vm = this;
        vm.userId = $routeParams['uid'];
        vm.studentId = $routeParams['userid'];
        vm.hwId = $routeParams['hid'];
        vm.sId = $routeParams['sid'];
        vm.courseId = $routeParams['cid'];
        vm.orderByField = 'percentageCompareHashMap';
        vm.openNav = openNav;
        vm.closeNav = closeNav;
        vm.logout = logout;
        vm.getDetailedReport = getDetailedReport;


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

        function getDetailedReport(file1Id, file2Id) {
            $location.url('/profile/'+ vm.userId + '/course/' + vm.courseId + '/homework/' + vm.hwId + '/submission/'
                + vm.studentId + '/type/' + vm.sId + '/summary/file1/'+ file1Id + '/file2/' + file2Id);
        }

        ReportService
            .findAllReportSummary(vm.studentId, vm.hwId)
            .then(function (reports) {
                vm.reverseSort = false;
                console.log(reports);
                if(reports.length === 0)
                    vm.error = "No reports.";
                else
                    vm.reports = reports;
                openNav("Professor");
            });
    }
})();