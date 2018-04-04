(function(){
    angular
        .module("PlagiarismChecker")
        .factory('UsageStatisicsService', UsageStatisicsService);

    function UsageStatisicsService($http) {

        var api = {
            "findAllUsageStatisticsByProfessor": findAllUsageStatisticsByProfessor,
            "addStatistics": addStatistics
        };
        return api;

        function findAllUsageStatisticsByProfessor(userId) {
            return $http.get("/rest/usagestatistics/findAllUsageStatisticsSummary/?userId="+userId)
                .then(function(res){
                    return res.data;
                });
        }

        function addStatistics(professor, student, course, homework, compareCount, algoType) {
            var usageData = {
                professor: professor,
                student: student,
                course: course,
                homework: homework,
                compareCount: compareCount,
                algoType: algoType
            };
            return $http.post("/rest/usagestatistics/registerStats", usageData)
                .then(function(res){
                    return res.data;
                });
        }
    }
})();