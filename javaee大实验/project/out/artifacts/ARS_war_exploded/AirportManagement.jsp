<%--
  Created by IntelliJ IDEA.
  User: wyj
  Date: 2019-12-07
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <s:head/>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="" />
    <meta name="author" content="" />

    <title>机票预订后台管理系统</title>
    <!-- Bootstrap -->
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <%--    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">--%>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <%--    <link href="css/bootstrap.min.css" rel="stylesheet" media="screen">--%>
    <link href="css/fontawesome-all.min.css" rel="stylesheet" type="text/css" />
    <link href="css/dataTables.bootstrap4.min.css" rel="stylesheet" type="text/css"/>
    <link href="css/sb-admin-2.min.css" rel="stylesheet" />
</head>

<body id="page-top">
<s:if test="hasActionMessages()">
    <script language="JavaScript">
        window.onload=function(){
            var msg = '';
            <s:iterator value="actionMessages">
            msg=msg+'<s:property escape="false"/>'+'\n';
            </s:iterator>
            alert(msg);
        }
    </script>
    <s:if test="!clearErrorsAndMessages()">
        <s:set name="actionMessages" value=""/>
    </s:if>
</s:if>

<!-- Page Wrapper -->
<div id="wrapper">
    <!-- Sidebar -->
    <div class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
        <!-- Sidebar - Brand -->
        <a href="#" class="sidebar-brand d-flex align-items-center justify-content-center">
            <div class="sidebar-brand-icon">
                <i class="fas fa-plane"></i>
            </div>
            <div class="sidebar-brand-text mx-2">后台管理系统</div>
        </a>
        <!-- Divider -->
        <hr class="sidebar-divider" />
        <!-- Heading -->
        <div class="sidebar-heading">
            机票预订后台信息管理
        </div>
        <!-- Nav Item - Pages Collapse Menu -->
        <div class="nav-item ">
            <a class="nav-link collapsed" href="adminAction.action?method=loadAirplane">
                <i class="fas fa-fw fa-list"></i>
                <span>飞机信息</span>
            </a>
        </div>
        <!-- Nav Item - Pages Collapse Menu -->
        <div class="nav-item active">
            <a class="nav-link collapsed" href="adminAction.action?method=loadAirport">
                <i class="fas fa-fw fa-list 1"></i>
                <span>机场信息</span>
            </a>
        </div>
        <div class="nav-item ">
            <a class="nav-link collapsed" href="adminAction.action?method=loadFlight">
                <i class="fas fa-fw fa-list 2"></i>
                <span>航班信息</span>
            </a>
        </div>
        <!-- Nav Item - Utilities Collapse Menu -->
        <div class="nav-item ">
            <a class="nav-link collapsed" href="adminAction.action?method=loadManager">
                <i class="fas fa-fw fa-list 2"></i>
                <span>经办业务员信息</span>
            </a>
        </div>
        <!-- Divider -->
        <hr class="sidebar-divider" />
        <!-- Heading -->
        <div class="sidebar-heading">
            系统管理
        </div>
        <div class="nav-item">
            <a class="nav-link" href="login.jsp">
                <i class="fas fa-fw fa-key"></i>
                <span>退出登录</span>
            </a>
        </div>
        <!-- Divider -->
        <hr class="sidebar-divider d-none d-md-block" />
        <!-- Sidebar Toggler (Sidebar) -->
        <div class="text-center d-none d-md-inline">
            <button class="rounded-circle border-0" id="sidebarToggle"></button>
        </div>
    </div>
    <!-- End of Sidebar -->
    <!-- Button to trigger modal -->

    <!-- Content Wrapper -->
    <div id="content-wrapper" class="d-flex flex-column">
        <!-- Main Content -->
        <div id="content">
            <!-- Topbar -->
            <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                <!-- Sidebar Toggle (Topbar) -->
                <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                    <i class="fa fa-bars"></i>
                </button>
                <h3 class="m-0 font-weight-bold text-primary">机票预订后台信息管理</h3>
            </nav>
            <!-- End of Topbar -->

            <!-- Begin Page Content -->
            <div class="container-fluid">
                <h1 class="h3 mb-3 text-gray-800">机场列表</h1>
                <div class="card shadow mb-4">
                    <div class="card-header py-3">
                        <h6 class="m-0 font-weight-bold text-primary">机场信息列表</h6>
                    </div>
                    <button class="btn btn-primary" type="button" data-toggle="modal" data-target="#airportDetailModal2"
                            style="width:55px;position: absolute;top: 45px;left: 130px;z-index: 1000;">
                        添加
                    </button>
                    <div class="card-body">
                        <div class="table-responsive">
                            <table
                                    class="table table-sm table-hover table-align-middle"
                                    id="airportInfo"
                            >
                                <thead>
                                <tr>
                                    <th>机场编号</th>
                                    <th>机场名称</th>
                                    <th>所在城市</th>
                                </tr>
                                </thead>
                                <s:iterator value="airports" status="status">
                                    <tr  onclick="testAirport(this)" id="<s:property value='#status.index'/>">
                                        <td><a data-toggle="modal" data-target="#airportDetailModal" style="cursor: pointer"><s:property value="airportId"/></a></td>
                                        <td><a data-toggle="modal" data-target="#airportDetailModal" style="cursor: pointer"><s:property value="airportName"/></a></td>
                                        <td><a data-toggle="modal" data-target="#airportDetailModal" style="cursor: pointer"><s:property value="city.cityName"/></a></td>
                                    </tr>
                                </s:iterator>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- End of Main Content -->
        <%--////footer////////////////////////////////////////////////////////////////--%>
        <footer class="sticky-footer bg-white">
            <div class="container my-auto">
                <div class="copyright text-center my-auto">
                    <span>Copyright &copy; wyj 2019</span>
                </div>
            </div>
        </footer>
        <%--/////////////////////////////////////////////////////////////////////////////////--%>
    </div>
    <!-- End of Content Wrapper -->
</div>
<!-- End of Page Wrapper -->
<%--模态框/////////////////////////////////////////////////////////////////////////////////////////////////--%>
<div class="modal fade" id="airportDetailModal" tabindex="-1">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title m-0 font-weight-bold text-primary" id="exampleModalLabel">机场详情</h5>
            </div>
            <div class="modal-body">
                <form id="form-airport-input" novalidate name="airportInfo" method="post" action="adminAction.action">
                    <div class="mb-2">
                        <h5>基础信息</h5>
                        <hr />
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="input-airportId">机场编号</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <i class="input-group-text fas fa-id-card-alt"></i>
                                    </div>
                                    <input
                                            type="text"
                                            class="form-control rounded-right"
                                            id="input-airportId"
                                            name="airport.airportId"
                                            required="required"
                                    />
                                    <div class="invalid-feedback">
                                        请输入机场编号
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="input-airportName">机场名称</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <i class="input-group-text fas fa-plane"></i>
                                    </div>
                                    <input
                                            type="text"
                                            class="form-control rounded-right"
                                            id="input-airportName"
                                            name="airport.airportName"
                                    />
                                    <div class="invalid-feedback">
                                        请输入机场名称
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mb-2">
                        <h5>附加信息</h5>
                        <hr />
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="input-city">所在城市</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <i class="input-group-text fas fa-place-of-worship"></i>
                                    </div>
                                    <input
                                            type="text"
                                            class="form-control"
                                            id="input-city"
                                            name="airport.city.cityName"
                                    />
                                    <div class="invalid-feedback">
                                        请输入所在城市
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="button" onclick="submitFun('alt');">
                            更新
                        </button>
                        <button class="btn btn-primary" type="button" onclick="submitFun('del');">
                            删除
                        </button>
                        <button class="btn btn-primary" type="button" onclick="submitFun('load');">
                            取消
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="airportDetailModal2" tabindex="-1">
    <div class="modal-dialog modal-lg modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title m-0 font-weight-bold text-primary" id="exampleModalLabel2">航班详情</h5>
            </div>
            <div class="modal-body">
                <form id="form-airport-input2" novalidate name="airportInfo2" method="post" action="adminAction.action">
                    <div class="mb-2">
                        <h5>基础信息</h5>
                        <hr />
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="input-airportId">机场编号</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <i class="input-group-text fas fa-id-card-alt"></i>
                                    </div>
                                    <input
                                            type="text"
                                            class="form-control rounded-right"
                                            name="airport.airportId"
                                            required="required"
                                    />
                                    <div class="invalid-feedback">
                                        请输入机场编号
                                    </div>
                                </div>
                            </div>
                            <div class="form-group col-md-6">
                                <label for="input-airportName">机场名称</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <i class="input-group-text fas fa-plane"></i>
                                    </div>
                                    <input
                                            type="text"
                                            class="form-control rounded-right"
                                            name="airport.airportName"
                                    />
                                    <div class="invalid-feedback">
                                        请输入机场名称
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="mb-2">
                        <h5>附加信息</h5>
                        <hr />
                        <div class="form-row">
                            <div class="form-group col-md-12">
                                <label for="input-city">所在城市</label>
                                <div class="input-group">
                                    <div class="input-group-prepend">
                                        <i class="input-group-text fas fa-place-of-worship"></i>
                                    </div>
                                    <input
                                            type="text"
                                            class="form-control"
                                            name="airport.city.cityName"
                                    />
                                    <div class="invalid-feedback">
                                        请输入所在城市
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button class="btn btn-primary" type="button" onclick="submitFun2('add');">
                            添加
                        </button>
                        <button class="btn btn-primary" type="button" onclick="submitFun2('load');">
                            取消
                        </button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- 滚动到页面顶部/////////////////////////////////////////////////////////////////////////////////////////////////////// -->
<a class="scroll-to-top rounded" href="#page-top">
    <i class="fas fa-angle-up"></i>
</a>


<%--<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->--%>
<%--<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>--%>
<%--<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>--%>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>

<script src="js/jquery.easing.min.js"></script>
<script src="js/sb-admin-2.min.js"></script>
<script src="js/jquery.dataTables.min.js"></script>
<script src="js/dataTables.bootstrap4.min.js"></script>
<script src="js/dataTables-airport.js"></script>
<script src="js/myJS-airport.js"></script>
<script src="js/holder.min.js"></script>
<script src="js/bootstrap2.min.js"></script>
</body>
</html>

