(function () {
    angular
        .module("PlagiarismChecker")
        .config(configuration);

    function configuration($routeProvider) {
        $routeProvider
            .when("/login",{
                templateUrl: 'views/user/template/login.client.html',
                controller: 'LoginController',
                controllerAs: 'model',
            })
            .when("/fileUpload/:uid",{
                templateUrl: 'views/user/template/fileUpload.client.html',
                controller: 'FileUploadController',
                controllerAs: 'model',
            })
            .when("/register",{
                templateUrl: 'views/user/template/register.client.html',
                controller: 'RegisterController',
                controllerAs: 'model',
            })
            .when("/profile/:uid",{
                templateUrl: 'views/user/template/profile.client.html',
                controller: 'ProfileController',
                controllerAs: 'model',
            })
        }

})();