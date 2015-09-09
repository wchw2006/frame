(function($,window) {
    
    var cache ={}
    var KEY  = "PRO_DATA";
     function Todo() {
     }
    
    function test(insId) {
        alert(insId);
    }
    
    function listProjects() {  //enrtyId:流程ID
        var data = getToDoDate();  //TODO  AJAX去后台取数
        $.data(cache,KEY,data);  //将数据缓存起来
        var proHtml = genProHtml(data);
        
        $('#projects_list').empty();   //渲染前清空所有数据
        $('#projects_list').append(proHtml);
    }
    
    function getToDoDate() {
        var data = [
                     {"flowId":"1231","flowName":"总行发文管理","total":2,
                      "flowInstances":[ {"insId":"110","insName":"数据中心需求"},
                                     {"insId":"111","insName":"数据中心需求"}]
                     },
                    {"flowId":"1232","flowName":"电子审批管理","total":1,
                      "flowInstances":[ {"insId":"112","insName":"中秋放假申请事项"}
                                     ]
                     },
                   {"flowId":"1233","flowName":"执行力考核相关流程","total":3,
                      "flowInstances":[ {"insId":"113","insName":"本人周报批准信息"},
                                       {"insId":"114","insName":"小波周报"},
                                       {"insId":"115","insName":"关于是否填写周报的事项报奥"}
                                     ]
                     }
                    ];
    return data;
    }
    
    
    function genProHtml(projects) {
        var htmlStr = "";
        $(projects).each(function(index,ele) {
            htmlStr += '<li > <a href="javascript:void(0);" onclick="Todo.viewFlowIns(this,'+ele.flowId+
                ')"><span class="badge badge-success">'
                       + ele.total+'</span>'+ele.flowName+'</a></li>'
        });
        return htmlStr;
    }
    
    function viewFlowIns(ele,flowId) {  //查看当前流程实例
       
        $('#projects_list>li,.active').removeClass('active');  //选择器 ','是and的意思
        $(ele).parent().addClass('active');
       var proData  = $.data(cache,KEY);
       var currFlowName,insData;
        $(proData).each(function(index,ele) {
            if(ele.flowId == flowId) {
                insData = ele.flowInstances;
                currFlowName = ele.flowName;
                return false;
            }
        });
        
       var htmlStr = genInsHtml(insData); 
        
        $('#curr_flow_name').text(currFlowName);
        $('#todo_tasklist').empty();   //渲染前清空所有数据
        $('#todo_tasklist').append(htmlStr);
        return false;
    }
    
    function genInsHtml(insData) {
        var htmlStr = "";
        $(insData).each(function(index,ele) {
             htmlStr += '<div class="task-item"><a onclick="Todo.test('+ele.insId+')" href="javascript:void(0);">'
                    +ele.insName+'</a></div>';
															
        });
        return htmlStr;
       } 
    
    
     function init() {
        listProjects();
    }

  Todo.viewFlowIns = viewFlowIns;
   Todo.test = test;
  Todo.init =  init;
   window.Todo = Todo;
    
})($,window)