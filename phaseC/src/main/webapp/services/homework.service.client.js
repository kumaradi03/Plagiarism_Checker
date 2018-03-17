(function(){
    angular
        .module("PlagiarismChecker")
        .factory('HomeworkService', HomeworkService);

    function HomeworkService($http) {

        var api = {
            "findAllHomeworkForUser": findAllHomeworkForUser,
            "createHomework":createHomework
        };
        return api;

        function findAllHomeworkForUser(userId) {
            return $http.get("/rest/homework/findAllHomeworkForUser/?userId="+userId)
                .then(function(res){
                    return res.data;
                });
        }

        function createHomework(homework, userId) {
            return $http.post("/rest/homework/create/?userId="+userId, homework)
                .then(function(res){
                    return res.data;
                });
        }
    }
})();