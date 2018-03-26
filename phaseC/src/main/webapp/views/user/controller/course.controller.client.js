(function(){
    angular
        .module("PlagiarismChecker")
        .controller("CourseController", CourseController);

    function CourseController (UserService, CourseService, $location, $routeParams) {
        var vm = this;
        var userId = $routeParams['uid'];
        vm.openNav = openNav;
        vm.closeNav = closeNav;
        vm.logout = logout;

        function openNav() {
            document.getElementById("mySidenav").style.width = "250px";
            document.getElementById("main").style.marginLeft = "250px";
        }

        /* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
        function closeNav() {
            document.getElementById("mySidenav").style.width = "0";
            document.getElementById("main").style.marginLeft = "0";
        }

        function logout() {
            $location.url("/login");
        }

        UserService
            .findUserById(userId)
            .then(function (user) {
                vm.user = user;
                CourseService
                    .findAllCoursesForUser(userId)
                    .then(function (courses) {
                        if(courses.length === 0)
                            vm.error = "No courses created.";
                        else
                            vm.courses = courses;
                        openNav();
                    });
            });
    }
})();