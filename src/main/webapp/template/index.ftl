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
<title>${site.fullNameOrName} -- Powerd by Jspxcms</title>
<meta name="description" content="这是恒大雅苑社区网，方便住在恒大雅苑的业主就行沟通交流" />
<meta name="keywords" content="恒大雅苑 恒大雅苑社区网 社区网站 " />

    <script src="_files/assets/global/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="_files/jquery.form.js" type="text/javascript"></script>
    <script src="_files/hdyy.js" type="text/javascript"></script>

   <link href="_files/assets/global/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="_files/assets/global/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   


  <!-- Theme styles START -->
  <link href="_files/assets/global/css/components.css" rel="stylesheet">
  <link href="_files/assets/frontend/layout/css/style.css" rel="stylesheet">
  <link href="_files/assets/frontend/layout/css/style-responsive.css" rel="stylesheet">
  <link href="_files/assets/frontend/layout/css/custom.css" rel="stylesheet">
 <link href="_files/my.css" rel="stylesheet">


 <style type="text/css">
 
  </style> 

</head>
<body >
[#include "a_header.html"/]
<div class="main"  >
      <div class="container" style="width: 1080px; margin: 0 auto;">
      
        <ul class="breadcrumb">
	        [#list node.hierarchy as n]
	        <li><a href="${n.url}">${n.name}</a></li>
	        [/#list]
	        <li class="active">正文</li>
        </ul>
        
      
       
       <div class="row margin-bottom-40" >
          <div class="col-md-8 col-sm-8 content-right">
		           <!-- start:文章标题 -->
			       <div class="row margin-bottom-20" >
			          <div class="col-md-12 col-sm-12">
				            <h1 class="info-title">${info.fullTitleOrTitle}</h1>
				            <ul class="blog-info">
				                        <li><i class="fa fa-calendar"></i> ${info.publishDate?string('yyyy-MM-dd')}</li>
				                        [#if info.getSource()??]<li>来源：${info.getSource()!} </li>[/#if]
			         		            [#if info.getAuthor()??]<li>作者：${info.getAuthor()!}</li>[/#if]
				            </ul>
			           </div>
			       </div>
		       <!-- end: 文章标题 -->
		       
             <div class="row margin-bottom-40  info-text">
               <div>[#noescape]${text}[/#noescape]</div>
                [#if pagedList.totalPages>1]
		         [#include 'inc_page.html'/]
		        [/#if]
             </div>
             
		        <div class="row margin-bottom-40 text-center">
		            <a   onclick="O.digg('${ctx}/info_digg.jspx','${info.id}');" class="icon-btn">
		                <i class="fa fa-thumbs-up"></i>
		                <div>顶</div>
		                <span id="diggs" class="badge badge-info">
		                </span>
		              </a>
		             
		             <a   onclick="O.bury('${ctx}/info_bury.jspx','${info.id}');" class="icon-btn">
		                <i class="fa fa-thumbs-down"></i>
		                <div>踩</div>
		                <span id="burys" class="badge badge-info">
		                </span>
		              </a>
		         
		         </div>
         
         
             <div class="row margin-bottom-20">
              <ul class="list-group" style="font-size:14px;" >
                     [@InfoPrev id=info.id;i]
		         	 [#if i??]
		         	   <li class="no-border-item">上一条：<a href="${i.url}">${i.title!}</a></li>
		         	 [#else]
		         	   <li class="no-border-item">上一条：没有了</li>
		        	[/#if]
				 	[/@InfoPrev]
				 	[@InfoNext id=info.id;i]
		         	[#if i??]
					 	<li class="no-border-item">
			         		下一条：<a href="${i.url}">${i.title!}</a>
			         	</li>
		         	[#else]
		        	   <li class="no-border-item">下一条：没有了</li>
		         	[/#if]
				 	[/@InfoNext ]
               </ul>
             </div>
             
             <div class="row ">
                  <h3>网友评论</h2>
                  <div id="commentAlert"></div>
		        
					                   <!-- 发表评论 -->
                   [#assign conf = site.getConf('com.jspxcms.core.domain.SiteComment')/]
				   <div class="post-comment " >
				      <form  id="comment" action="${ctx}/comment_submit.jspx" method="post" role="form" >
					      <input type="hidden" id="ftype"  name="ftype" value="Info"/>
				  	      <input type="hidden" id="fid"  name="fid" value="${info.id}"/>
				  	      <input type="hidden" name="status_0" value="评论成功！"/>
                          <input type="hidden" name="status_1" value="评论成功，请等待管理员审核！"/>
                          <input type="hidden" name="nextUrl" value="${url}"/>
                           <input type="hidden" name="responseType" value="ajax"/>
	                      <div class="form-group">
	                        <textarea name="text" class="form-control" maxlengthh="${conf.maxLength}" rows="6" placeholder="文明上网理性发言"></textarea>
	                      </div>
	                        <div class="form-inline" >
	                          <script type="text/javascript" src="${ctx}/app.jspx?template=comment_captcha"></script>
	                          <div style="display:inline-block;" >
	                             <button id="commentBtn" class="btn btn-primary" type="button">确定提交</button>
	                          </div>
	                      </div>
                    </form>
				   </div>
				   
				   <!-- 展示评论 -->
                  <div class=" " id="comment_div"></div>
                   
                  <div>
                  <p>
		              <a href="${ctx}/comment.jspx?fid=${info.id}">
		                                              共<span id="info_comments"></span>评论。点击查看
		              </a>
                  </p>
                  </div>
             </div>
             
          </div>
          <div class="col-md-4 col-sm-4">
                    [#include "news_right.html"]
          </div>
       </div>    
          
[#include "a_footer.html"/]
    <script src="_files/assets/global/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="_files/assets/global/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="_files/assets/global/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="_files/assets/global/plugins/carousel-owl-carousel/owl-carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->

    <!-- BEGIN RevolutionSlider -->
  
    <script src="_files/assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.revolution.min.js" type="text/javascript"></script> 
    <script src="_files/assets/global/plugins/slider-revolution-slider/rs-plugin/js/jquery.themepunch.tools.min.js" type="text/javascript"></script> 
    <script src="_files/assets/frontend/pages/scripts/revo-slider-init.js" type="text/javascript"></script>
    <!-- END RevolutionSlider -->

    <script src="_files/assets/frontend/layout/scripts/layout.js" type="text/javascript"></script>
    <script src="_files/info.js" type="text/javascript"></script>
    
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
    		 
     		O.init({
     			captchaUrl:'${ctx}/captcha.servlet?d='+new Date()*1,
         		diggAndBuryUrl:'${ctx}/info_diggs/${info.id}.jspx?d='+new Date()*1,
         		listCommentUrl:'${ctx}/comment_list.jspx?fid=${info.id}&d='+new Date()*1,
         		getCommentCountUrl: '${ctx}/info_comments/${info.id}.jspx?d='+new Date()*1
     		});
     		
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
</html>
[/#escape]