(function(){
    angular
        .module("PlagiarismChecker")
        .factory('ReportService', ReportService);

    function ReportService($http) {

        var api = {
            "findAllReportSummary": findAllReportSummary
        };
        return api;

        function findAllReportSummary(userId, hwId) {
            return $http.get("/rest/report/findAllReportSummary/?userId="+userId+"&hwId="+hwId)
                .then(function(res){
                    return res.data;
                });
        }
    }
})();