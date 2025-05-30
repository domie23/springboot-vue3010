<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-cn">

<head>
    <%@ include file="../../static/head.jsp" %>
    <!-- font-awesome -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">


    <link href="${pageContext.request.contextPath}/resources/css/bootstrap-select.css" rel="stylesheet">
    <!-- layui -->
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
    <script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
</head>
<style>

</style>
<body>

    <div class="modal fade" id="fuzhaungCommentbackModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="z-index: 3000">
            <div class="modal-content">
                <%-- 模态框标题--%>
                <div class="modal-header">
                    <h5 class="modal-title" id="fuzhaungCommentbackTitle">评价</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%-- 模态框内容 --%>
                <div class="modal-body">
                    <input type="hidden" id="id">
                    评价内容:<textarea id="fuzhaungCommentbackContent" style="width: 400px;height: 300px"></textarea>
                </div>
                <%-- 模态框按钮 --%>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" onclick="submitFuzhaungCommentback()" class="btn btn-info">评价</button>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="deliverModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog" style="z-index: 3000">
            <div class="modal-content">
                <%-- 模态框标题--%>
                <div class="modal-header">
                    <h5 class="modal-title">发货模态框</h5>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <%-- 模态框内容 --%>
                <div class="modal-body">
                    <input type="hidden" id="deliverId">
                    快递公司:
                    <input type="text" id="fuzhaungOrderCourierName" style="width: 300px;" class="form-control form-control-sm"
                           placeholder="快递公司" aria-controls="tableId">
                    订单快递单号:
                    <input type="text" id="fuzhaungOrderCourierNumber" style="width: 300px;" class="form-control form-control-sm"
                           placeholder="订单快递单号" aria-controls="tableId">
                </div>
                <%-- 模态框按钮 --%>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" onclick="deliver()" class="btn btn-info">发货</button>
                </div>
            </div>
        </div>
    </div>



    <!-- Pre Loader -->
    <div class="loading">
        <div class="spinner">
            <div class="double-bounce1"></div>
            <div class="double-bounce2"></div>
        </div>
    </div>
<!--/Pre Loader -->
    <div class="wrapper">
        <!-- Page Content -->
        <div id="content">
            <!-- Top Navigation -->
            <%@ include file="../../static/topNav.jsp" %>
            <!-- Menu -->
            <div class="container menu-nav">
                <nav class="navbar navbar-expand-lg lochana-bg text-white">
                    <button class="navbar-toggler" type="button" data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="ti-menu text-white"></span>
                    </button>
                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul id="navUl" class="navbar-nav mr-auto">
                        </ul>
                    </div>
                </nav>
            </div>
            <!-- /Menu -->
            <!-- Breadcrumb -->
            <!-- Page Title -->
            <div class="container mt-0">
                <div class="row breadcrumb-bar">
                    <div class="col-md-6">
                        <h3 class="block-title">服装订单管理</h3>
                    </div>
                    <div class="col-md-6">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}/index.jsp">
                                    <span class="ti-home"></span>
                                </a>
                            </li>
                            <li class="breadcrumb-item">服装订单管理</li>
                            <li class="breadcrumb-item active">服装订单列表</li>
                        </ol>
                    </div>
                </div>
            </div>
            <!-- /Page Title -->

            <!-- /Breadcrumb -->
            <!-- Main Content -->
            <div class="container">
                <div class="row">
                    <!-- Widget Item -->
                    <div class="col-md-12">
                        <div class="widget-area-2 lochana-box-shadow">
                            <h3 class="widget-title">服装订单列表</h3>
                            <div class="table-responsive mb-3">
                                <div class="col-sm-12">
                                                                         
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        订单号
                                        <div class="layui-input-inline">
                                            <input type="text" id="fuzhaungOrderUuidNumberSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="订单号" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                                                                                                                                                                 
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        订单类型
                                        <div class="layui-input-inline">
                                            <select name="fuzhaungOrderTypesSelectSearch"  style="width: 150px;" id="fuzhaungOrderTypesSelectSearch" class="form-control form-control-sm"
                                                    aria-controls="tableId">
                                            </select>
                                        </div>
                                    </div>
                                                                                                            
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
                                                     
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        服装名称
                                        <div class="layui-input-inline">
                                            <input type="text" id="fuzhaungNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="服装名称" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                         
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        服装类型
                                        <div class="layui-input-inline">
                                            <select name="fuzhaungTypesSelectSearch"  style="width: 150px;" id="fuzhaungTypesSelectSearch" class="form-control form-control-sm"
                                                    aria-controls="tableId">
                                            </select>
                                        </div>
                                    </div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
                                    <div class="layui-inline" style="margin-bottom: 10px;">
                                        用户姓名
                                        <div class="layui-input-inline">
                                            <input type="text" id="yonghuNameSearch" style="width: 140px;" class="form-control form-control-sm"
                                                   placeholder="用户姓名" aria-controls="tableId">
                                        </div>
                                    </div>
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
                                    <div class="layui-inline" style="margin-left: 30px;margin-bottom: 10px;">
                                        <button onclick="search()" type="button" class="btn btn-primary">查询</button>
                                        <button onclick="add()" type="button" class="btn btn-primary 新增">添加</button>
                                        <button onclick="graph()" type="button" class="btn btn-primary 报表">报表</button>
                                        <button onclick="exportExcel()" type="button" class="btn btn-success 导入导出"><i class="fa fa-file-excel-o" aria-hidden="true"></i>导出</button>
                                        <button onclick="deleteMore()" type="button" class="btn btn-danger 删除">批量删除</button>
                                    </div>
                                </div>
                                <table id="tableId" class="table table-bordered table-striped">
                                    <thead>
                                    <tr>
                                        <th class="no-sort" style="min-width: 35px;">
                                            <div class="custom-control custom-checkbox">
                                                <input class="custom-control-input" type="checkbox" id="select-all"
                                                       onclick="chooseAll()">
                                                <label class="custom-control-label" for="select-all"></label>
                                            </div>
                                        </th>

                                        <th >收货人</th>
                                        <th >电话</th>
                                        <th >地址</th>
                                        <th >服装名称</th>
                                        <th >服装照片</th>
                                        <th >服装类型</th>
                                        <th >用户姓名</th>
                                        <th>订单号</th>
                                        <th>购买数量</th>
                                        <th>实付价格</th>
                                        <th>快递公司</th>
                                        <th>订单快递单号</th>
                                        <th>订单类型</th>
                                        <th>支付类型</th>
                                        <th>订单创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                    </thead>
                                    <tbody id="thisTbody">
                                    </tbody>
                                </table>
                                <div class="col-md-6 col-sm-3">
                                    <div class="dataTables_length" id="tableId_length">

                                        <select name="tableId_length" aria-controls="tableId" id="selectPageSize"
                                                onchange="changePageSize()">
                                            <option value="10">10</option>
                                            <option value="25">25</option>
                                            <option value="50">50</option>
                                            <option value="100">100</option>
                                        </select>
                                        条 每页

                                    </div>
                                </div>
                                <nav aria-label="Page navigation example">
                                    <ul class="pagination justify-content-end">
                                        <li class="page-item" id="tableId_previous" onclick="pageNumChange('pre')">
                                            <a class="page-link" href="#" tabindex="-1">上一页</a>
                                        </li>

                                        <li class="page-item" id="tableId_next" onclick="pageNumChange('next')">
                                            <a class="page-link" href="#">下一页</a>
                                        </li>
                                    </ul>
                                </nav>
                            </div>
                        </div>
                    </div>
                    <!-- /Widget Item -->
                </div>
            </div>
            <!-- /Main Content -->

        </div>
        <!-- /Page Content -->
    </div>
    <!-- Back to Top -->
    <a id="back-to-top" href="#" class="back-to-top">
        <span class="ti-angle-up"></span>
    </a>
    <!-- /Back to Top -->
    <%@ include file="../../static/foot.jsp" %>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/My97DatePicker/WdatePicker.js"></script>
    <script type="text/javascript" charset="utf-8"
            src="${pageContext.request.contextPath}/resources/js/bootstrap-select.js"></script>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/excel/excel-gen.js"></script>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/excel/jszip.min.js"></script>
    <script language="javascript" type="text/javascript"
            src="${pageContext.request.contextPath}/resources/js/excel/FileSaver.js"></script>
    <script>

        <%@ include file="../../utils/menu.jsp"%>
        <%@ include file="../../static/setMenu.js"%>
        <%@ include file="../../utils/baseUrl.jsp"%>
        <%@ include file="../../static/getRoleButtons.js"%>
        <%@ include file="../../static/crossBtnControl.js"%>
        var tableName = "fuzhaungOrder";
        var pageType = "list";
        var searchForm = {key: ""};
        var pageIndex = 1;
        var pageSize = 10;
        var totalPage = 0;
        var dataList = [];
        var sortColumn = '';
        var sortOrder = '';
        var ids = [];
        var checkAll = false;

        <!-- 级联表的级联字典表 -->
        var fuzhaungTypesOptions = [];

        <!-- 本表的级联字段表 -->
        var fuzhaungOrderTypesOptions = [];

        function init() {
            // 满足条件渲染提醒接口
        }

        // 改变每页记录条数
        function changePageSize() {
            var selection = document.getElementById('selectPageSize');
            var index = selection.selectedIndex;
            pageSize = selection.options[index].value;
            getDataList();
        }



        // 查询
        function search() {
            searchForm = {key: ""};

        <!-- 级联表的级联字典表 -->
                                                                                                                                                                                                                             
                            //服装编号
            var fuzhaungUuidNumberSearchInput = $('#fuzhaungUuidNumberSearch');
            if( fuzhaungUuidNumberSearchInput != null){
                if (fuzhaungUuidNumberSearchInput.val() != null && fuzhaungUuidNumberSearchInput.val() != '') {
                    searchForm.fuzhaungUuidNumber = $('#fuzhaungUuidNumberSearch').val();
                }
            }
                     
                            //服装名称
            var fuzhaungNameSearchInput = $('#fuzhaungNameSearch');
            if( fuzhaungNameSearchInput != null){
                if (fuzhaungNameSearchInput.val() != null && fuzhaungNameSearchInput.val() != '') {
                    searchForm.fuzhaungName = $('#fuzhaungNameSearch').val();
                }
            }
                                         
            var fuzhaungTypesSelectSearchInput = document.getElementById("fuzhaungTypesSelectSearch");
            if(fuzhaungTypesSelectSearchInput != null){
                var fuzhaungTypesIndex = fuzhaungTypesSelectSearchInput.selectedIndex;
                if( fuzhaungTypesIndex  != 0){
                    searchForm.fuzhaungTypes = document.getElementById("fuzhaungTypesSelectSearch").options[fuzhaungTypesIndex].value;
                }
            }
                                                                                                                                                                                                                             
                            //用户姓名
            var yonghuNameSearchInput = $('#yonghuNameSearch');
            if( yonghuNameSearchInput != null){
                if (yonghuNameSearchInput.val() != null && yonghuNameSearchInput.val() != '') {
                    searchForm.yonghuName = $('#yonghuNameSearch').val();
                }
            }
                                                                                                                                                                                        <!-- 本表的查询条件 -->

         
            //订单号
            var fuzhaungOrderUuidNumberSearchInput = $('#fuzhaungOrderUuidNumberSearch');
            if( fuzhaungOrderUuidNumberSearchInput != null){
                if (fuzhaungOrderUuidNumberSearchInput.val() != null && fuzhaungOrderUuidNumberSearchInput.val() != '') {
                    searchForm.fuzhaungOrderUuidNumber = $('#fuzhaungOrderUuidNumberSearch').val();
                }
            }
                                 
                //订单类型
            var fuzhaungOrderTypesSelectSearchInput = document.getElementById("fuzhaungOrderTypesSelectSearch");
            if(fuzhaungOrderTypesSelectSearchInput != null){
                var fuzhaungOrderTypesIndex = fuzhaungOrderTypesSelectSearchInput.selectedIndex;
                if( fuzhaungOrderTypesIndex  != 0){
                    searchForm.fuzhaungOrderTypes= document.getElementById("fuzhaungOrderTypesSelectSearch").options[fuzhaungOrderTypesIndex].value;
                }
            }
                        getDataList();
        }

        // 获取数据列表
        function getDataList() {
            http("fuzhaungOrder/page", "GET", {
                page: pageIndex,
                limit: pageSize,
                sort: sortColumn,
                order: sortOrder,
                fuzhaungOrderDelete: 1,
                //本表的
                fuzhaungOrderUuidNumber: searchForm.fuzhaungOrderUuidNumber,
                fuzhaungOrderTypes: searchForm.fuzhaungOrderTypes,
            //级联表的

                fuzhaungUuidNumber: searchForm.fuzhaungUuidNumber,
                fuzhaungName: searchForm.fuzhaungName,
                fuzhaungTypes: searchForm.fuzhaungTypes,

                yonghuName: searchForm.yonghuName,


            }, (res) => {
                if(res.code == 0) {
                    clear();
                    $("#thisTbody").html("");
                    dataList = res.data.list;
                    totalPage = res.data.totalPage;
                    for (var i = 0; i < dataList.length; i++) { //遍历一下表格数据  
                        var trow = setDataRow(dataList[i], i); //定义一个方法,返回tr数据 
                        $('#thisTbody').append(trow);
                    }
                    pagination(); //渲染翻页组件
                    getRoleButtons();// 权限按钮控制
                }
            });
        }

        // 渲染表格数据
        function setDataRow(item, number) {
            //创建行 
            var row = document.createElement('tr');
            row.setAttribute('class', 'useOnce');
            //创建勾选框
            var checkbox = document.createElement('td');
            var checkboxDiv = document.createElement('div');
            checkboxDiv.setAttribute("class", "custom-control custom-checkbox");
            var checkboxInput = document.createElement('input');
            checkboxInput.setAttribute("class", "custom-control-input");
            checkboxInput.setAttribute("type", "checkbox");
            checkboxInput.setAttribute('name', 'chk');
            checkboxInput.setAttribute('value', item.id);
            checkboxInput.setAttribute("id", number);
            checkboxDiv.appendChild(checkboxInput);
            var checkboxLabel = document.createElement('label');
            checkboxLabel.setAttribute("class", "custom-control-label");
            checkboxLabel.setAttribute("for", number);
            checkboxDiv.appendChild(checkboxLabel);
            checkbox.appendChild(checkboxDiv);
            row.appendChild(checkbox)


                    //收货人
            var addressNameCell = document.createElement('td');
            addressNameCell.innerHTML = item.addressName;
            row.appendChild(addressNameCell);


                    //电话
            var addressPhoneCell = document.createElement('td');
            addressPhoneCell.innerHTML = item.addressPhone;
            row.appendChild(addressPhoneCell);


                    //地址
            var addressDizhiCell = document.createElement('td');
            addressDizhiCell.innerHTML = item.addressDizhi;
            row.appendChild(addressDizhiCell);


                    //服装名称
            var fuzhaungNameCell = document.createElement('td');
            fuzhaungNameCell.innerHTML = item.fuzhaungName;
            row.appendChild(fuzhaungNameCell);


                //服装照片
            var fuzhaungPhotoCell = document.createElement('td');
            var fuzhaungPhotoImg = document.createElement('img');
            var fuzhaungPhotoImgValue = item.fuzhaungPhoto;
            if(fuzhaungPhotoImgValue !=null && fuzhaungPhotoImgValue !='' && fuzhaungPhotoImgValue !='null'){
                    fuzhaungPhotoImg.setAttribute('src', fuzhaungPhotoImgValue);
                    fuzhaungPhotoImg.setAttribute('height', 100);
                    fuzhaungPhotoImg.setAttribute('width', 100);
                    fuzhaungPhotoCell.appendChild(fuzhaungPhotoImg);
            }else{
                    fuzhaungPhotoCell.innerHTML = "暂无图片";
            }
            row.appendChild(fuzhaungPhotoCell);

                        //服装类型
            var fuzhaungTypesCell = document.createElement('td');
            fuzhaungTypesCell.innerHTML = item.fuzhaungValue;
            row.appendChild(fuzhaungTypesCell);


                    //用户姓名
            var yonghuNameCell = document.createElement('td');
            yonghuNameCell.innerHTML = item.yonghuName;
            row.appendChild(yonghuNameCell);


            //订单号
            var fuzhaungOrderUuidNumberCell = document.createElement('td');
            fuzhaungOrderUuidNumberCell.innerHTML = item.fuzhaungOrderUuidNumber;
            row.appendChild(fuzhaungOrderUuidNumberCell);


            //购买数量
            var buyNumberCell = document.createElement('td');
            buyNumberCell.innerHTML = item.buyNumber;
            row.appendChild(buyNumberCell);


            //实付价格
            var fuzhaungOrderTruePriceCell = document.createElement('td');
            fuzhaungOrderTruePriceCell.innerHTML = item.fuzhaungOrderTruePrice;
            row.appendChild(fuzhaungOrderTruePriceCell);


            //快递公司
            var fuzhaungOrderCourierNameCell = document.createElement('td');
            fuzhaungOrderCourierNameCell.innerHTML = item.fuzhaungOrderCourierName;
            row.appendChild(fuzhaungOrderCourierNameCell);


            //订单快递单号
            var fuzhaungOrderCourierNumberCell = document.createElement('td');
            fuzhaungOrderCourierNumberCell.innerHTML = item.fuzhaungOrderCourierNumber;
            row.appendChild(fuzhaungOrderCourierNumberCell);


            //订单类型
            var fuzhaungOrderTypesCell = document.createElement('td');
            fuzhaungOrderTypesCell.innerHTML = item.fuzhaungOrderValue;
            row.appendChild(fuzhaungOrderTypesCell);


            //支付类型
            var fuzhaungOrderPaymentTypesCell = document.createElement('td');
            fuzhaungOrderPaymentTypesCell.innerHTML = item.fuzhaungOrderPaymentValue;
            row.appendChild(fuzhaungOrderPaymentTypesCell);


            //订单创建时间
            var insertTimeCell = document.createElement('td');
            insertTimeCell.innerHTML = item.insertTime;
            row.appendChild(insertTimeCell);



            //每行按钮
            var btnGroup = document.createElement('td');

            //详情按钮
            var detailBtn = document.createElement('button');
            var detailAttr = "detail(" + item.id + ')';
            detailBtn.setAttribute("type", "button");
            detailBtn.setAttribute("class", "btn btn-info btn-sm 查看");
            detailBtn.setAttribute("onclick", detailAttr);
            detailBtn.innerHTML = "查看";
            btnGroup.appendChild(detailBtn);

            if(item.fuzhaungOrderTypes == 1 && window.sessionStorage.getItem('role') == "用户"){
                //退款
                var detailListBtn = document.createElement('button');
                var detailListAttr = "refund(" + item.id+')';
                detailListBtn.setAttribute("type", "button");
                detailListBtn.setAttribute("class", "btn btn-info btn-sm");
                detailListBtn.setAttribute("onclick", detailListAttr);
                detailListBtn.innerHTML = "退款";
                btnGroup.appendChild(detailListBtn);
            }

            if(item.fuzhaungOrderTypes == 1 && window.sessionStorage.getItem('role') == "管理员"){
                //发货
                var detailListBtn = document.createElement('button');
                var detailListAttr = "openDeliver(" + item.id+')';
                detailListBtn.setAttribute("type", "button");
                detailListBtn.setAttribute("class", "btn btn-info btn-sm");
                detailListBtn.setAttribute("onclick", detailListAttr);
                detailListBtn.innerHTML = "发货";
                btnGroup.appendChild(detailListBtn);
            }












            if(item.fuzhaungOrderTypes == 3 && window.sessionStorage.getItem('role') == "用户"){
                //收货
                var detailListBtn = document.createElement('button');
                var detailListAttr = "receiving(" + item.id+')';
                detailListBtn.setAttribute("type", "button");
                detailListBtn.setAttribute("class", "btn btn-info btn-sm");
                detailListBtn.setAttribute("onclick", detailListAttr);
                detailListBtn.innerHTML = "收货";
                btnGroup.appendChild(detailListBtn);
            }


            if(item.fuzhaungOrderTypes == 4 && window.sessionStorage.getItem('role') == "用户"){
                //评价
                var detailListBtn = document.createElement('button');
                var detailListAttr = "commentback(" + item.id+')';
                detailListBtn.setAttribute("type", "button");
                detailListBtn.setAttribute("class", "btn btn-info btn-sm");
                detailListBtn.setAttribute("onclick", detailListAttr);
                detailListBtn.innerHTML = "评价";
                btnGroup.appendChild(detailListBtn);
            }











            //修改按钮
            var editBtn = document.createElement('button');
            var editAttr = 'edit(' + item.id + ')';
            editBtn.setAttribute("type", "button");
            editBtn.setAttribute("class", "btn btn-warning btn-sm 修改");
            editBtn.setAttribute("onclick", editAttr);
            editBtn.innerHTML = "修改";
            btnGroup.appendChild(editBtn);



            //删除按钮
            var deleteBtn = document.createElement('button');
            var deleteAttr = 'remove(' + item.id + ')';
            deleteBtn.setAttribute("type", "button");
            deleteBtn.setAttribute("class", "btn btn-danger btn-sm 删除");
            deleteBtn.setAttribute("onclick", deleteAttr);
            deleteBtn.innerHTML = "删除";
            btnGroup.appendChild(deleteBtn);

            row.appendChild(btnGroup);

            return row;
    }


        // 翻页
        function pageNumChange(val) {
            if (val == 'pre') {
                pageIndex--;
            } else if (val == 'next') {
                pageIndex++;
            } else {
                pageIndex = val;
            }
            getDataList();
        }

        // 下载
        function download(url) {
            window.open(url);
        }
        // 打开新窗口播放媒体
        function mediaPlay(url){
            window.open(url);
        }

        // 渲染翻页组件
        function pagination() {
            var beginIndex = pageIndex;
            var endIndex = pageIndex;
            var point = 4;
            //计算页码
            for (var i = 0; i < 3; i++) {
                if (endIndex == totalPage) {
                    break;
                }
                endIndex++;
                point--;
            }
            for (var i = 0; i < 3; i++) {
                if (beginIndex == 1) {
                    break;
                }
                beginIndex--;
                point--;
            }
            if (point > 0) {
                while (point > 0) {
                    if (endIndex == totalPage) {
                        break;
                    }
                    endIndex++;
                    point--;
                }
                while (point > 0) {
                    if (beginIndex == 1) {
                        break;
                    }
                    beginIndex--;
                    point--
                }
            }
            // 是否显示 前一页 按钮
            if (pageIndex > 1) {
                $('#tableId_previous').show();
            } else {
                $('#tableId_previous').hide();
            }
            // 渲染页码按钮
            for (var i = beginIndex; i <= endIndex; i++) {
                var pageNum = document.createElement('li');
                pageNum.setAttribute('onclick', "pageNumChange(" + i + ")");
                if (pageIndex == i) {
                    pageNum.setAttribute('class', 'paginate_button page-item active useOnce');
                } else {
                    pageNum.setAttribute('class', 'paginate_button page-item useOnce');
                }
                var pageHref = document.createElement('a');
                pageHref.setAttribute('class', 'page-link');
                pageHref.setAttribute('href', '#');
                pageHref.setAttribute('aria-controls', 'tableId');
                pageHref.setAttribute('data-dt-idx', i);
                pageHref.setAttribute('tabindex', 0);
                pageHref.innerHTML = i;
                pageNum.appendChild(pageHref);
                $('#tableId_next').before(pageNum);
            }
            // 是否显示 下一页 按钮
            if (pageIndex < totalPage) {
                $('#tableId_next').show();
                $('#tableId_next a').attr('data-dt-idx', endIndex + 1);
            } else {
                $('#tableId_next').hide();
            }
            var pageNumInfo = "当前第 " + pageIndex + " 页，共 " + totalPage + " 页";
            $('#tableId_info').html(pageNumInfo);
        }

        // 跳转到指定页
        function toThatPage() {
            //var index = document.getElementById('pageIndexInput').value;
            if (index < 0 || index > totalPage) {
                alert('请输入正确的页码');
            } else {
                pageNumChange(index);
            }
        }

        // 全选/全不选
        function chooseAll() {
            checkAll = !checkAll;
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                boxs[i].checked = checkAll;
            }
        }

        // 批量删除
        function deleteMore() {
            ids = []
            var boxs = document.getElementsByName("chk");
            for (var i = 0; i < boxs.length; i++) {
                if (boxs[i].checked) {
                    ids.push(boxs[i].value)
                }
            }
            if (ids.length == 0) {
                alert('请勾选要删除的记录');
            } else {
                remove(ids);
            }
        }

        // 删除
        function remove(id) {
            var mymessage = confirm("真的要删除吗？");
            if (mymessage == true) {
                var paramArray = [];
                if (id == ids) {
                    paramArray = id;
                } else {
                    paramArray.push(id);
                }
                httpJson("fuzhaungOrder/delete", "POST", paramArray, (res) => {
                    if(res.code == 0){
                        getDataList();
                        alert('删除成功');
                    }
                });
            } else {
                alert("已取消操作");
            }
        }

        // 用户登出
        <%@ include file="../../static/logout.jsp"%>

        //修改
        function edit(id) {
            window.sessionStorage.setItem('updateId', id)
            window.location.href = "add-or-update.jsp"
        }

        //清除会重复渲染的节点
        function clear() {
            var elements = document.getElementsByClassName('useOnce');
            for (var i = elements.length - 1; i >= 0; i--) {
                elements[i].parentNode.removeChild(elements[i]);
            }
        }

        //添加
        function add() {
            window.sessionStorage.setItem("addfuzhaungOrder", "addfuzhaungOrder");
            window.location.href = "add-or-update.jsp"
        }

        //报表
        function graph() {
            window.location.href = "graph.jsp"
        }
        function exportExcel() {
            excel = new ExcelGen({
                "src_id": "tableId",
                "show_header": true,
                "file_name": 'fuzhaungOrder.xlsx'
            });
            excel.generate();
        }

        // 查看详情
        function detail(id) {
            window.sessionStorage.setItem("updateId", id);
            window.location.href = "info.jsp";
        }


    //填充级联表搜索下拉框
                                                                                                                                                                                                                             
                     
                                         
        function fuzhaungTypesSelectSearch() {
            var fuzhaungTypesSelectSearch = document.getElementById('fuzhaungTypesSelectSearch');
            if(fuzhaungTypesSelectSearch != null) {
                fuzhaungTypesSelectSearch.add(new Option('-请选择-',''));
                if (fuzhaungTypesOptions != null && fuzhaungTypesOptions.length > 0){
                    for (var i = 0; i < fuzhaungTypesOptions.length; i++) {
                            fuzhaungTypesSelectSearch.add(new Option(fuzhaungTypesOptions[i].indexName, fuzhaungTypesOptions[i].codeIndex));
                    }
                }
            }
        }
                                                                                                                                                                                                                             
                                                                                                                                                                                    
    //填充本表搜索下拉框
         
                                 
        function fuzhaungOrderTypesSelectSearch() {
            var fuzhaungOrderTypesSelectSearch = document.getElementById('fuzhaungOrderTypesSelectSearch');
            if(fuzhaungOrderTypesSelectSearch != null) {
                fuzhaungOrderTypesSelectSearch.add(new Option('-请选择-',''));
                if (fuzhaungOrderTypesOptions != null && fuzhaungOrderTypesOptions.length > 0){
                    for (var i = 0; i < fuzhaungOrderTypesOptions.length; i++) {
                            fuzhaungOrderTypesSelectSearch.add(new Option(fuzhaungOrderTypesOptions[i].indexName,fuzhaungOrderTypesOptions[i].codeIndex));
                    }
                }
            }
        }
            
    //查询级联表搜索条件所有列表
            function fuzhaungTypesSelect() {
                //填充下拉框选项
                http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=fuzhaung_types", "GET", {}, (res) => {
                    if(res.code == 0){
                        fuzhaungTypesOptions = res.data.list;
                    }
                });
            }

    //查询当前表搜索条件所有列表
            function fuzhaungOrderTypesSelect() {
                //填充下拉框选项
                http("dictionary/page?page=1&limit=100&sort=&order=&dicCode=fuzhaung_order_types", "GET", {}, (res) => {
                    if(res.code == 0){
                        fuzhaungOrderTypesOptions = res.data.list;
                    }
                });
            }









        // 退款
        function refund(id) {
             var mymessage = confirm("确定要退款吗？");
            if(!mymessage){
                alert("已取消操作");
                return false;
            }
            http("fuzhaungOrder/refund?id="+id, "GET",{}, (res) => {
                if(res.code == 0){
                    alert('退款成功');
                    getDataList();
                }else{
                    alert(res.msg);
                }
            });
        }
        //打开发货模态框
        function openDeliver(id){
            //清空快递单号
            $("#fuzhaungOrderCourierNumber").val("");
            //快递公司
            $("#fuzhaungOrderCourierName").val("");
            //赋值
            $("#deliverId").val(id);
            //打开模态框
            $('#deliverModal').modal('show');//打开模态框
        }
        // 发货
        function deliver() {
            var fuzhaungOrderCourierName = $("#fuzhaungOrderCourierName").val();
            if(fuzhaungOrderCourierName == null || fuzhaungOrderCourierName == ""){
                alert('快递公司不能为空');
                return false;
            }
            var fuzhaungOrderCourierNumber = $("#fuzhaungOrderCourierNumber").val()
            if( fuzhaungOrderCourierNumber == null || fuzhaungOrderCourierNumber == ""){
                alert('订单快递单号不能为空');
                return false;
            }

            http("fuzhaungOrder/deliver?id="+$("#deliverId").val()+"&fuzhaungOrderCourierName="+fuzhaungOrderCourierName+"&fuzhaungOrderCourierNumber="+fuzhaungOrderCourierNumber, "GET",{}, (res) => {
                if(res.code == 0){
                    alert('成功发货');
                    $('#deliverModal').modal('hide');//关闭模态框
                    getDataList();
                }else{
                    alert(res.msg);
                }
            });
        }







        // 收货
        function receiving(id) {
            var mymessage = confirm("确定要收货吗？");
            if(!mymessage){
                alert("已取消操作");
                return false;
            }
            http("fuzhaungOrder/receiving?id="+id, "GET",{}, (res) => {
                if(res.code == 0){
                    alert('成功收货');
                    getDataList();
                }else{
                    alert(res.msg);
                }
            });
        }





        // 评价
        function commentback(id) {
            $("#id").val(id);//设置订单id

            $("#fuzhaungCommentbackContent").val("")//评价内容
            $('#fuzhaungCommentbackModal').modal('show');//打开模态框

        }
        function submitFuzhaungCommentback(){
            var fuzhaungCommentbackContent = $("#fuzhaungCommentbackContent").val();
            var id = $("#id").val();

            http("fuzhaungOrder/commentback?id="+id+"&commentbackText="+fuzhaungCommentbackContent, 'get', {}, function (res) {
                if(res.code==0){
                    layer.msg('评价成功', {
                        time: 2000,
                        icon: 6
                    }, function () {
                        $('#fuzhaungCommentbackModal').modal('hide');
                       getDataList();
                    });
                }else{
                    layer.msg(res.msg, {
                        time: 2000,
                        icon: 5
                    }, function () {
                        //$('#fuzhaungCommentbackModal').modal('hide');
                        //getDataList();
                    });
                }
            });
        }







        layui.use(['layer', 'carousel', 'jquery', 'form', 'upload', 'laydate', 'rate'], function () {
            var rate = layui.rate;//评分
            var jquery = layui.jquery;//jquery
            var $=jquery;

        });


        $(document).ready(function () {
            //激活翻页按钮
            $('#tableId_previous').attr('class', 'paginate_button page-item previous')
            $('#tableId_next').attr('class', 'paginate_button page-item next')
            //隐藏原生搜索框
            $('#tableId_filter').hide()
            //设置右上角用户名
            $('.dropdown-menu h5').html(window.sessionStorage.getItem('username'))
            //设置项目名
            $('.sidebar-header h3 a').html(projectName)
            setMenu();
            init();

            //查询级联表的搜索下拉框
            fuzhaungTypesSelect();

            //查询当前表的搜索下拉框
            fuzhaungOrderTypesSelect();
            getDataList();

        //级联表的下拉框赋值
                                                                                                                                                                                                                                                                         
                         
                                                 
            fuzhaungTypesSelectSearch();
                                                                                                                                                                                                                                                                         
                                                                                                                                                                                                                        
        //当前表的下拉框赋值
                         
                                                                                                 
            fuzhaungOrderTypesSelectSearch();
                                    
        <%@ include file="../../static/myInfo.js"%>
    });
</script>
</body>

</html>
