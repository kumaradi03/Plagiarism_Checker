(function(){
    angular
        .module("PlagiarismChecker")
        .factory('CourseService', CourseService);

    function CourseService($http) {

        var api = {
            "findAllCoursesForUser": findAllCoursesForUser
        };
        return api;

        function findAllCoursesForUser (userId) {
            return $http.get("/rest/course/findAllCoursesForUser/?userId="+userId)
                .then(function(res){
                    return res.data;
                });
        }
    }
})();