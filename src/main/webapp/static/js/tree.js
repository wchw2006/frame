(function($,window) {
    
     function Tree() {
     }
    
    function genTreeStr(node) {
        //{id:"",text:"",url:"",parent:"",children:[node1,node2]}
        var htmlStr = "";
        $(node).each(function(index,ele) {
             var isChildren = ele.children.length>0?false:true;  //TODO 要处理children元素不存在的情况
             if(isChildren) {
                //<a href="#" onclick="Tree.queryByNod(this)">管理二<span style="display:none">13</span></a>
                htmlStr = htmlStr + '<li><a href="#" onclick="Tree.queryByNod(this)">'+ele.txt+
                '<span style="display:none">'+ele.id+'</span></a></li>';
                } else {
                   htmlStr += '<li><a href=""> '+ele.txt +'</a>'
                              +'<ul class="sub-menu" style="display: block;">'
                   $(ele.children).each(function(index,ele) {
                        htmlStr += genTreeStr(ele);
                   });   
                  htmlStr += '</ul></li>';
              }   
        });
        return htmlStr;
    }
    
    function openModal(stepId) {
        $('#treeUi').empty(); //首先要清空元素
        var data = queryNodeData();  // TODO  AJAX取出后台数据
        var treeStr = genTreeStr(data); 
        $('#treeUi').append(treeStr);
        $('#responsive').modal('show')
        return false;  //禁止页面跳转
    }
    
    function queryNodeData(){
        var testData = 
        [{"id":1,"txt":"流程管理","children":[]},
         {"id":2,"txt":"系统管理"
           ,"children":[
              {"id":3,"txt":"用户管理","children":[
                {"id":12,"txt":"管理一","children":[]},
                {"id":13,"txt":"管理二","children":[]}
              ]}
             ]
         }
         
        ] ;
        return testData;
    }
     function btnClose(btn) {
         $(btn).remove();
     }
     
    function approveChoose(btn) {
      var name = $(btn).text().trim();
      var isExist = false;
      $('#approver_selected span').each(function(index,ele) {
          if(name == $(ele).text().trim()) {
              isExist = true;
              return false;
          }
      });
     if(isExist) {
         alert("该人员已经被选择了");
     } else {
        $('#approver_selected').append(createApprove(name));
     }
    }
    
    function createApprove(name) {
        var approveStr = '<button  onclick="Tree.removeApprove(this)" style="margin:3px 5px;" class="btn btn-default">'+ 
                                    '<i class="close"  aria-hidden="true"></i>'+
                                     '<span style="margin-right:10px;">'+name+'</span></button>';
        return approveStr;
    }
    
    function queryByNod(node) {
        $('#approver_choose').empty();
        var data = queryData(node);
        var htmlStr = '';
        $(data).each(function(index,ele) {
                     htmlStr += createChoose(ele);
                     });
         $('#approver_choose').append(htmlStr);
        return false;
    }
    
    function queryData(node) {
       var id = $.trim($(node).find("span").text());
        var data = queryAjax(id);
        return data;
    }
    
    function queryAjax(id) {
        var data = {
            "12":[{"id":3,"name":"唐吉安"},
                  {"id":4,"name":"马三跑"},
                  {"id":5,"name":"马唐"}
                  ],
            "13":[{"id":3,"name":"唐个六"},
                  {"id":4,"name":"马大业"},
                  {"id":5,"name":"提二"}
                  ]
            };
        return data[id];
    }
    
    function createChoose(ele) {
       var htmlStr = '<button  onclick="Tree.addApprove(this)" style="margin:3px 5px;" class="btn btn-info">'+ele.name+'('+ele.id+')</button>';
        return htmlStr;
    }

    function modalBtn() {
        var v = $('#approver_selected span');
         var valueStr = '';
        v.each(function(index,ele) {
            valueStr += $.trim($(ele).text());
            valueStr +=';';
        });
        value = valueStr.substring(0,valueStr.length-1);
        $('#approver').val(value);
        $('#responsive').modal('hide')  //隐藏模态框
    }
    
    
    
    Tree.removeApprove = btnClose;
    Tree.addApprove = approveChoose;
    Tree.queryByNod = queryByNod;
    Tree.modalBtn = modalBtn;
    Tree.openModal = openModal;
    window.Tree = Tree;
    
})($,window)