(function(){
    angular
        .module("PlagiarismChecker")
        .controller("FileUploadController", FileUploadController);

    function FileUploadController(FileUploader, UserService, $location, $routeParams) {
        var vm = this;
        var userId = $routeParams['uid'];
        vm.pressFileUploadButton = pressFileUploadButton();
        vm.pressFolderUploadButton = pressFolderUploadButton();
        vm.openNav = openNav;
        vm.closeNav = closeNav;
        vm.uploader = new FileUploader({url:"/rest/file/upload"});

        function pressFileUploadButton() {
            $('#fileUploadButton').click(function(event) {
                $('#fileDialog').click();
            });
        }

        function pressFolderUploadButton() {
            $('#folderUploadbutton').click(function(event) {
                $('#folderDialog').click();
            });
        }

        function openNav(type) {
            if(type === "Student"){
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }
        }

        /* Set the width of the side navigation to 0 and the left margin of the page content to 0 */
        function closeNav(type) {
            if(type === "Student"){
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft = "0";
            }
        }

        UserService
            .findUserById(userId)
            .then(function (user) {
                vm.user = user;
                openNav(vm.user.userType);
            });

    }
})();