<%--
  Created by IntelliJ IDEA.
  User: keyuli
  Date: 2019/9/11
  Time: 13:37
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
        <!-- search form -->
        <!--<form action="#" method="get" class="sidebar-form">
<div class="input-group">
    <input type="text" name="q" class="form-control" placeholder="搜索...">
    <span class="input-group-btn">
    <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>
    </button>
  </span>
</div>
</form>-->
        <!-- /.search form -->


        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <li class="header">菜单</li>

            <li id="admin-index"><a href="#"><i class="fa fa-dashboard"></i> <span>首页</span></a></li>

            <!-- 菜单 -->

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-book"></i> <span>信息发布</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>
                <ul class="treeview-menu">

                    <li id="tables-simple">
                        <a href="all-tables-simple.html">
                            <i class="fa fa-circle-o"></i> 发布通知消息
                        </a>
                    </li>

                </ul>
            </li>

            <li class="treeview">
                <a href="#">
                    <i class="fa fa-cogs"></i> <span>管理模块</span>
                    <span class="pull-right-container">
									<i class="fa fa-angle-left pull-right"></i>
								</span>
                </a>
                <ul class="treeview-menu">

                    <li id="form-general">
                        <a href="/jsp/all-problem-manage-list.jsp">
                            <i class="fa fa-circle-o"></i> 题库管理
                        </a>
                    </li>

                    <li id="form-advanced">
                        <a href="all-form-advanced.html">
                            <i class="fa fa-circle-o"></i> 试卷管理
                        </a>
                    </li>

                    <li id="form-editors">
                        <a href="all-form-editors.html">
                            <i class="fa fa-circle-o"></i> 成绩管理
                        </a>
                    </li>

                </ul>
            </li>

        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
<!-- 导航侧栏 /-->
