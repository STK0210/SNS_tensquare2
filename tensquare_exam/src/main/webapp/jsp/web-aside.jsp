<%--
  Created by IntelliJ IDEA.
  User: keyuli
  Date: 2019/9/11
  Time: 9:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!-- 导航侧栏 -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="${pageContext.request.contextPath}/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${user.username}</p>
                <a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
            </div>
        </div>

        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="#"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-table"></i> <span>查询信息</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>
                <ul class="treeview-menu">

                    <li id="tables-simple">
                        <a href="all-tables-simple.html">
                            <i class="fa fa-circle-o"></i> 查看通知
                        </a>
                    </li>

                    <li id="tables-data">
                        <a href="all-tables-data.html">
                            <i class="fa fa-circle-o"></i> 查看考试表(总)
                        </a>
                    </li>

                    <li id="tables-data">
                        <a href="all-tables-data.html">
                            <i class="fa fa-circle-o"></i> 查看成绩表(总)
                        </a>
                    </li>

                    <li id="tables-data">
                        <a href="all-tables-data.html">
                            <i class="fa fa-circle-o"></i> 查看个人排名
                        </a>
                    </li>

                    <li id="tables-data">
                        <a href="all-tables-data.html">
                            <i class="fa fa-circle-o"></i> 查看个人成绩
                        </a>
                    </li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-edit"></i> <span>考试模块</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>
                <ul class="treeview-menu">

                    <li id="form-general">
                        <a href="all-form-general.html">
                            <i class="fa fa-circle-o"></i> 报名中心
                        </a>
                    </li>

                    <li id="form-advanced">
                        <a href="all-form-advanced.html">
                            <i class="fa fa-circle-o"></i> 已报名考试
                        </a>
                    </li>

                    <li id="form-editors">
                        <a href="all-form-editors.html">
                            <i class="fa fa-circle-o"></i> 在线考试
                        </a>
                    </li>

                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
