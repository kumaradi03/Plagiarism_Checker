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
            .when("/profile/:uid/homework/:hid/fileupload",{
                templateUrl: 'views/user/template/fileUpload.client.html',
                controller: 'FileUploadController',
                controllerAs: 'model',
            })
            .when("/profile/:uid/homework/:hid/submission",{
                templateUrl: 'views/user/template/submission.client.html',
                controller: 'SubmissionController',
                controllerAs: 'model',
            })
            .when("/profile/:uid/homework/:hid/submission/:userid/summary",{
                templateUrl: 'views/user/template/report-summary.client.html',
                controller: 'ReportSummaryController',
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
            .when("/profile/:uid/homework/",{
                templateUrl: 'views/user/template/homework.client.html',
                controller: 'HomeWorkController',
                controllerAs: 'model',
            })
            .when("/profile/:uid/homework/new",{
                templateUrl: 'views/user/template/homework-new.client.html',
                controller: 'HomeWorkController',
                controllerAs: 'model',
            })
        }
})();