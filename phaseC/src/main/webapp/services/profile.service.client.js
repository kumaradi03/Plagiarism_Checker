(function(){
    angular
        .module("PlagiarismChecker")
        .factory('ProfileService', ProfileService);

    function ProfileService($http) {

        var api = {
            "upload": upload,
        };
        return api;
    }
})();