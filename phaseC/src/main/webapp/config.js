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
        }
})();