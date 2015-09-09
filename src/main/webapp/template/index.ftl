[#escape x as (x)!?html]
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="zh-cmn-Hans" >
<!--<![endif]-->
<head>
<meta charset="utf-8"/>
<meta http-equiv="Content-type" content="text/html; charset=utf-8">
<meta name="author" content="atarm" />
<title>长沙银行OA办公系统 -- Powerd by Jspxcms</title>
<meta name="description" content="长沙银行OA办公系统 " />
<meta name="keywords" content="长沙银行OA办公系统 " />

    <script src="static/js/jquery.form.js" type="text/javascript"></script>

  <link href="static/vendor/metronic/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   
     <link href="static/vendor/metronic/assets/global/css/components.css" rel="stylesheet">
  <link href="static/vendor/metronic/assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="static/vendor/metronic/assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
    <link href="static/vendor/metronic/assets/admin/layout/css/layout.css" rel="stylesheet">
      <link href="static/css/oa.css" rel="stylesheet">
    
</head>
<body >
[#include "common/a_header.ftl"/]
<div class="main"  >
      <div class="container" >
       <div class="row margin-bottom-20" >
          <div class="col-md-12 ">
            <button type="button" class="btn default">提交</button>
            <button type="button" class="btn default">返回</button>
            <button type="button" class="btn default">打印</button>
            <button type="button" class="btn default">过程跟踪</button>
          </div>
       </div>
        <div class="row margin-bottom-40" >
          <div class="col-md-12 ">
					<!-- BEGIN Portlet PORTLET-->
					<div class="portlet ">
						<div class="portlet-title">
							<div class="caption">
								<i class="fa fa-gift"></i>零售业务审批
							</div>
							<ul class="nav nav-pills" >
								<li class="active">
									<a href="#portlet_tab1" data-toggle="tab" aria-expanded="false">
									  流程信息 </a>
								</li>
								<li >
									<a href="#portlet_tab2" data-toggle="tab" aria-expanded="false">
									附件 </a>
								</li>
								<li >
									<a href="#portlet_tab3" data-toggle="tab" aria-expanded="true">
									审批提交</a>
								</li>
							</ul>
						</div>
						<div class="portlet-body">
							<div class="tab-content">
								<div class="tab-pane active" id="portlet_tab1">
									[#include "flow_add.ftl"/]
								</div>
								<div class="tab-pane " id="portlet_tab2">
								    [#include "flow_view.ftl"/]
								</div>
								<div class="tab-pane" id="portlet_tab3">
									     <h4>当前审批环节:<span name="curr_step">业务处理人处理</span></h4>
									     <hr/>
									     <div class="row">
                                            <div class="col-md-12">
                                                 <div class="form-inline">
                                                   <div class="form-group">
                                                     <label>选择活动</label>
                                                     <select class="form-control">
                                                        <option>返回给申请人</option>
                                                        <option>信息技术部经理审批</option>
                                                        <option>业务处理人处理 </option>
                                                     </select>
									                 </div>
									                 <input type="text" class="form-control form-filter" id="approver" name="approver" disabled>
									                 <button type="button" onclick="Tree.openModal()" class="btn default">选择执行人</button>
									               </div>
									            </div>
									          </div>
									         <hr/>
									          <div class="row">
									            <div class="col-md-7">
									              <div class="form-group">
									                <label>审批意见</label>
									                <textarea class="form-control" placeholder="请在此填写审批意见" rows="4"></textarea>
									               </div>
									            </div>
									          </div>
								          </div>
							         </div>
						        </div>
					</div>
				</div>
				
        </div>
     </div>    
</div>      
 
 [#include "common/select_approver_modal.ftl"/]
 
<!--[if lt IE 9]>
<script src="static/vendor/metronic/assets/global/plugins/respond.min.js"></script>
<script src="static/vendor/metronic/assets/global/plugins/excanvas.min.js"></script> 
<![endif]-->

<script src="static/vendor/metronic/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
<script src="static/vendor/metronic/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>

<script src="static/vendor/metronic/assets/global/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>

<script src="static/vendor/metronic/assets/global/scripts/metronic.js" type="text/javascript"></script>
<script src="static/vendor/metronic/assets/admin/layout/scripts/layout.js" type="text/javascript"></script>
<script src="static/js/tree.js" type="text/javascript"></script>


<script>
jQuery(document).ready(function() {    
   Metronic.init(); // init metronic core components
Layout.init(); // init current layout
});
</script>
</body>
</html>
[/#escape]