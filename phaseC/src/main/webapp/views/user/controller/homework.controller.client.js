(function(){
    angular
        .module("PlagiarismChecker")
        .controller("HomeWorkController", HomeWorkController);

    function HomeWorkController (UserService, HomeworkService, $location, $routeParams) {
        var vm = this;
        var userId = $routeParams['uid'];
        vm.openNav = openNav;
        vm.closeNav = closeNav;
        vm.createHomework = createHomework;
        vm.logout = logout;

        function openNav(type) {
            if(type === "Professor"){
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }
            else if(type === "Student")
            {
                document.getElementById("mySidenav1").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }
        }

        /* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
        function closeNav(type) {
            if(type === "Professor"){
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft = "0";
            }
            else if(type === "Student")
            {
                document.getElementById("mySidenav1").style.width = "0";
                document.getElementById("main").style.marginLeft = "0";
            }
        }

        function createHomework(homework) {
            HomeworkService
                .createHomework(homework, vm.user.id)
                .then(function (homework) {
                    $location.url("/profile/"+vm.user.id+"/homework");
                });
        }

        function findAllHomeworkForUser(userId) {
            HomeworkService
                .findAllHomeworkForUser(vm.professor.id)
                .then(function (homeworks) {
                    if(homeworks.length == 0)
                        vm.error = "No Homework created.";
                    else
                        vm.homeworks = homeworks;
                });
        }

        function logout() {
            $location.url("/login");
        }

        UserService
            .findUserById(userId)
            .then(function (user) {
                if (user.userType === 'Student') {
                    UserService
                        .findProfessor()
                        .then(function (usr) {
                            vm.professor = usr;
                            vm.user = user;
                            findAllHomeworkForUser(vm.professor.id);
                            openNav(vm.user.userType);
                        });
                }
                else{
                    vm.user = user;
                    vm.professor = user;
                    findAllHomeworkForUser(vm.professor.id);
                    openNav(vm.user.userType);
                }
            });

    }
})();