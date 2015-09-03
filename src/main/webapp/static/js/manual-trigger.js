var manualUploader = new qq.FineUploader({
    element: document.getElementById('fine-uploader-manual-trigger'),
    template: 'qq-template-manual-trigger',
    request: {
        endpoint: '/frame/upload.do',
    },
    retry: {
        enableAuto: false // defaults to false 
     },
    autoUpload: false,
    debug: false,
    multiple:true,
    callbacks: {
    	onComplete:function(id,fileName,resJson) {
    		alert(id+" "+fileName+" "+resJson);
    	}
    }
});

qq(document.getElementById("trigger-upload")).attach("click", function() {
    manualUploader.uploadStoredFiles();
});
