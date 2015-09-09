<div id="responsive" class="modal bs-modal-lg" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true"></button>
                    <h4 class="modal-title">审批人员选择</h4>
                </div>
                <div class="modal-body">
                    <div class="scroller" style="height:400px" data-always-visible="1" data-rail-visible1="1">
                        <div class="row" >
                            <div class="col-md-4" style="border-right:#ccc 1px solid;min-height:400px;">
                                <h4>角色机构树</h4>
                                <div class="page-sidebar-wrapper">
                                    <div class="page-sidebar navbar-collapse collapse">
                                        <ul id ="treeUi" class="page-sidebar-menu" data-keep-expanded="false" data-auto-scroll="true" data-slide-speed="200">
                                            <li>
                                                <a href="#">流程管理</a>
                                            </li>
                                            <li class="open">
                                                <a href=""> 系统管理	 </a>
                                                <ul class="sub-menu" style="display: block;">
                                                    <li class="open">
                                                        <a href="">用户管理</a>
                                                        <ul class="sub-menu" style="display: block;">
                                                            <li>
                                                                <a href="#" onclick="Tree.queryByNod(this)">管理一<span style="display:none">12</span></a>

                                                            </li>
                                                            <li>
                                                                <a href="#" onclick="Tree.queryByNod(this)">管理二<span style="display:none">13</span></a>
                                                            </li>

                                                        </ul>
                                                    </li>
                                                    <li>
                                                        <a href="index.do">工作流管理	 </a>
                                                    </li>
                                                </ul>
                                            </li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="col-md-8">
                                <h4>审批人员选择</h4>
                                <div id="approver_selected">
                                </div>
                                <hr/>
                                <div id="approver_choose" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" data-dismiss="modal" class="btn default">取消</button>
                    <button type="button" onclick="Tree.modalBtn()" class="btn green">确定</button>
                </div>
            </div>
        </div>
    </div>