(function(){
    angular
        .module("PlagiarismChecker")
        .controller("ProfileController", ProfileController);

    function ProfileController(FileUploader) {
        var vm = this;
        vm.uploader = new FileUploader();
    }
})();