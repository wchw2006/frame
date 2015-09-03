<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  <script type="text/javascript" src="static/js/jquery-1.9.1.js"></script>
  <script src="static/js/bootstrap.min.js"></script>
    <script src="static/vendor/fineupload/highlight.min.js"></script>

    <script src="static/vendor/fineupload/all.fine-uploader.min.js"></script>
    
  
 <link href="http://fineuploader.com/css/custom.css" rel="stylesheet">
 <link href="http://fineuploader.com/source/fine-uploader-new.min.css" rel="stylesheet">
    
    
     
  <body style="font-size: 12px;">


                    <!--start manual trigger demo code-->
                    <script type="text/template" id="qq-template-manual-trigger">
                        <div class="qq-uploader-selector qq-uploader" qq-drop-area-text="Drop files here">
                            <div class="qq-total-progress-bar-container-selector qq-total-progress-bar-container">
                                <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-total-progress-bar-selector qq-progress-bar qq-total-progress-bar"></div>
                            </div>
                            <div class="qq-upload-drop-area-selector qq-upload-drop-area" qq-hide-dropzone>
                                <span class="qq-upload-drop-area-text-selector"></span>
                            </div>
                            <div class="buttons">
                                <div class="qq-upload-button-selector qq-upload-button">
                                    <div> 选择文件...</div>
                                </div>
                                <button type="button" id="trigger-upload" class="btn btn-primary">
                                    <i class="icon-upload icon-white"></i> 确定上传
                                </button>
                            </div>
                            <span class="qq-drop-processing-selector qq-drop-processing">
                                <span>文件处理中...</span>
                                <span class="qq-drop-processing-spinner-selector qq-drop-processing-spinner"></span>
                            </span>
                            <ul class="qq-upload-list-selector qq-upload-list" aria-live="polite" aria-relevant="additions removals">
                                <li>
                                    <div class="qq-progress-bar-container-selector">
                                        <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-progress-bar-selector qq-progress-bar"></div>
                                    </div>
                                    <span class="qq-upload-spinner-selector qq-upload-spinner"></span>
                                    <span class="qq-upload-file-selector qq-upload-file"></span>
                                    <span class="qq-edit-filename-icon-selector qq-edit-filename-icon" aria-label="Edit filename"></span>
                                    <input class="qq-edit-filename-selector qq-edit-filename" tabindex="0" type="text">
                                    <span class="qq-upload-size-selector qq-upload-size"></span>
                                    <button type="button" class="qq-btn qq-upload-cancel-selector qq-upload-cancel">取消</button>
                                    <button type="button" class="qq-btn qq-upload-retry-selector qq-upload-retry">重新上传</button>
                                    <button type="button" class="qq-btn qq-upload-delete-selector qq-upload-delete">删除</button>
                                    <span role="status" class="qq-upload-status-text-selector qq-upload-status-text"></span>
                                </li>
                            </ul>

                            <dialog class="qq-alert-dialog-selector">
                                <div class="qq-dialog-message-selector"></div>
                                <div class="qq-dialog-buttons">
                                    <button type="button" class="qq-cancel-button-selector">关闭</button>
                                </div>
                            </dialog>

                            <dialog class="qq-confirm-dialog-selector">
                                <div class="qq-dialog-message-selector"></div>
                                <div class="qq-dialog-buttons">
                                    <button type="button" class="qq-cancel-button-selector">否</button>
                                    <button type="button" class="qq-ok-button-selector">是</button>
                                </div>
                            </dialog>

                            <dialog class="qq-prompt-dialog-selector">
                                <div class="qq-dialog-message-selector"></div>
                                <input type="text">
                                <div class="qq-dialog-buttons">
                                    <button type="button" class="qq-cancel-button-selector">取消</button>
                                    <button type="button" class="qq-ok-button-selector">确定</button>
                                </div>
                            </dialog>
                        </div>
                    </script>

                    <style>
                        #trigger-upload {
                            color: white;
                            background-color: #00ABC7;
                            font-size: 14px;
                            padding: 7px 20px;
                            background-image: none;
                        }

                        #fine-uploader-manual-trigger .qq-upload-button {
                            margin-right: 15px;
                        }

                        #fine-uploader-manual-trigger .buttons {
                            width: 36%;
                        }

                        #fine-uploader-manual-trigger .qq-uploader .qq-total-progress-bar-container {
                            width: 60%;
                        }
                    </style>
                    <div id="fine-uploader-manual-trigger"><div class="qq-uploader-selector qq-uploader" qq-drop-area-text="Drop files here">
                            <div class="qq-total-progress-bar-container-selector qq-total-progress-bar-container qq-hide">
                                <div role="progressbar" aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" class="qq-total-progress-bar-selector qq-progress-bar qq-total-progress-bar"></div>
                            </div>
                            <div class="qq-upload-drop-area-selector qq-upload-drop-area" qq-hide-dropzone="" style="display: none;">
                                
                            </div>
                            <div class="buttons">
                                <div class="qq-upload-button-selector qq-upload-button" style="position: relative; overflow: hidden; direction: ltr;">
                                    <div>选择文件...</div>
                                <input qq-button-id="15d83b88-6e81-47b0-8f4d-c813b2b9d9cd" title="file input" multiple="" type="file" name="qqfile" style="position: absolute; right: 0px; top: 0px; font-family: Arial; font-size: 118px; margin: 0px; padding: 0px; cursor: pointer; opacity: 0; height: 100%;"></div>
                                <button type="button" id="trigger-upload" class="btn btn-primary">
                                    <i class="icon-upload icon-white"></i> 确定上传
                                </button>
                            </div>
                            <span class="qq-drop-processing-selector qq-drop-processing qq-hide">
                                <span>文件处理中...</span>
                                <span class="qq-drop-processing-spinner-selector qq-drop-processing-spinner"></span>
                            </span>
                            <ul class="qq-upload-list-selector qq-upload-list" aria-live="polite" aria-relevant="additions removals"></ul>

                            <dialog class="qq-alert-dialog-selector">
                                <div class="qq-dialog-message-selector"></div>
                                <div class="qq-dialog-buttons">
                                    <button type="button" class="qq-cancel-button-selector">关闭</button>
                                </div>
                            </dialog>

                            <dialog class="qq-confirm-dialog-selector">
                                <div class="qq-dialog-message-selector"></div>
                                <div class="qq-dialog-buttons">
                                    <button type="button" class="qq-cancel-button-selector">否</button>
                                    <button type="button" class="qq-ok-button-selector">是</button>
                                </div>
                            </dialog>

                            <dialog class="qq-prompt-dialog-selector">
                                <div class="qq-dialog-message-selector"></div>
                                <input type="text">
                                <div class="qq-dialog-buttons">
                                    <button type="button" class="qq-cancel-button-selector">取消</button>
                                    <button type="button" class="qq-ok-button-selector">确定</button>
                                </div>
                            </dialog>
                        </div></div>
                    <script src="static/js/manual-trigger.js"></script>

  </body>
</html>
