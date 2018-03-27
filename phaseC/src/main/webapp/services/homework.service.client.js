(function(){
    angular
        .module("PlagiarismChecker")
        .factory('HomeworkService', HomeworkService);

    function HomeworkService($http) {

        var api = {
            "findAllHomeworkForCourse": findAllHomeworkForCourse,
            "createHomework":createHomework
        };
        return api;

        function findAllHomeworkForCourse(courseId) {
            return $http.get("/rest/homework/findAllHomeworkForCourse/?courseId="+courseId)
                .then(function(res){
                    return res.data;
                });
        }

        function createHomework(homework, userId, courseId) {
            return $http.post("/rest/homework/create/?userId="+userId+"&courseId="+courseId, homework)
                .then(function(res){
                    return res.data;
                });
        }
    }
})();