<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard | Uplon - Responsive Bootstrap 4 Admin Dashboard</title>
    <%@include file="/cp/layout/header.jsp" %>
</head>
<style>
    .navbar-custom {
        background-color: #2b3d51;
        padding: 0 10px 0 0;
        position: fixed;
        left: 0;
        right: 0;
        height: 70px;
        z-index: 100;
    }
</style>
<body>

<!-- Begin page -->
<div id="wrapper">


    <!-- Topbar Start -->
    <div class="navbar-custom">
        <ul class="list-unstyled topnav-menu float-right mb-0">

            <li class="dropdown notification-list dropdown d-none d-lg-inline-block ml-2">
                <a class="nav-link dropdown-toggle mr-0 waves-effect waves-light" data-toggle="dropdown" href="#"
                   role="button" aria-haspopup="false" aria-expanded="false">
                    <img src="/assets/images/flags/us.jpg" alt="lang-image" height="12">
                </a>
                <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <img src="/assets/images/flags/germany.jpg" alt="lang-image" class="mr-1" height="12"> <span
                            class="align-middle">German</span>
                    </a>

                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <img src="/assets/images/flags/italy.jpg" alt="lang-image" class="mr-1" height="12"> <span
                            class="align-middle">Italian</span>
                    </a>

                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <img src="/assets/images/flags/spain.jpg" alt="lang-image" class="mr-1" height="12"> <span
                            class="align-middle">Spanish</span>
                    </a>

                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <img src="/assets/images/flags/russia.jpg" alt="lang-image" class="mr-1" height="12"> <span
                            class="align-middle">Russian</span>
                    </a>

                </div>
            </li>

            <li class="dropdown notification-list">
                <a class="nav-link dropdown-toggle  waves-effect waves-light" data-toggle="dropdown" href="#"
                   role="button" aria-haspopup="false" aria-expanded="false">
                    <i class="mdi mdi-bell-outline noti-icon"></i>
                    <span class="noti-icon-badge"></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                    <!-- item-->
                    <div class="dropdown-item noti-title">
                        <h5 class="font-16 text-white m-0">
                                    <span class="float-right">
                                        <a href="" class="text-white">
                                            <small>Clear All</small>
                                        </a>
                                    </span>Notification
                        </h5>
                    </div>

                    <div class="slimscroll noti-scroll">

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <div class="notify-icon bg-success">
                                <i class="mdi mdi-settings-outline"></i>
                            </div>
                            <p class="notify-details">New settings
                                <small class="text-muted">There are new settings available</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <div class="notify-icon bg-info">
                                <i class="mdi mdi-bell-outline"></i>
                            </div>
                            <p class="notify-details">Updates
                                <small class="text-muted">There are 2 new updates available</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <div class="notify-icon bg-danger">
                                <i class="mdi mdi-account-plus"></i>
                            </div>
                            <p class="notify-details">New user
                                <small class="text-muted">You have 10 unread messages</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <div class="notify-icon bg-info">
                                <i class="mdi mdi-comment-account-outline"></i>
                            </div>
                            <p class="notify-details">Caleb Flakelar commented on Admin
                                <small class="text-muted">4 days ago</small>
                            </p>
                        </a>

                        <!-- item-->
                        <a href="javascript:void(0);" class="dropdown-item notify-item">
                            <div class="notify-icon bg-secondary">
                                <i class="mdi mdi-heart"></i>
                            </div>
                            <p class="notify-details">Carlos Crouch liked
                                <b>Admin</b>
                                <small class="text-muted">13 days ago</small>
                            </p>
                        </a>
                    </div>

                    <!-- All-->
                    <a href="javascript:void(0);" class="dropdown-item text-primary notify-item notify-all">
                        View all
                        <i class="fi-arrow-right"></i>
                    </a>

                </div>
            </li>

            <li class="dropdown notification-list">
                <a class="nav-link dropdown-toggle  waves-effect waves-light" data-toggle="dropdown" href="#"
                   role="button" aria-haspopup="false" aria-expanded="false">
                    <i class="mdi mdi-email-outline noti-icon"></i>
                    <span class="noti-icon-badge"></span>
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-lg">

                    <!-- item-->
                    <div class="dropdown-item noti-title">
                        <h5 class="font-16 text-white m-0">
                                    <span class="float-right">
                                        <a href="" class="text-white">
                                            <small>Clear All</small>
                                        </a>
                                    </span>Messages
                        </h5>
                    </div>

                    <div class="slimscroll noti-scroll">

                        <div class="inbox-widget">
                            <a href="#">
                                <div class="inbox-item">
                                    <div class="inbox-item-img"><img src="/assets/images/users/avatar-1.jpg"
                                                                     class="rounded-circle" alt=""></div>
                                    <p class="inbox-item-author">Chadengle</p>
                                    <p class="inbox-item-text text-truncate">Hey! there I'm available...</p>
                                </div>
                            </a>
                            <a href="#">
                                <div class="inbox-item">
                                    <div class="inbox-item-img"><img src="/assets/images/users/avatar-2.jpg"
                                                                     class="rounded-circle" alt=""></div>
                                    <p class="inbox-item-author">Tomaslau</p>
                                    <p class="inbox-item-text text-truncate">I've finished it! See you so...</p>
                                </div>
                            </a>
                            <a href="#">
                                <div class="inbox-item">
                                    <div class="inbox-item-img"><img src="/assets/images/users/avatar-3.jpg"
                                                                     class="rounded-circle" alt=""></div>
                                    <p class="inbox-item-author">Stillnotdavid</p>
                                    <p class="inbox-item-text text-truncate">This theme is awesome!</p>
                                </div>
                            </a>
                            <a href="#">
                                <div class="inbox-item">
                                    <div class="inbox-item-img"><img src="/assets/images/users/avatar-4.jpg"
                                                                     class="rounded-circle" alt=""></div>
                                    <p class="inbox-item-author">Kurafire</p>
                                    <p class="inbox-item-text text-truncate">Nice to meet you</p>
                                </div>
                            </a>
                            <a href="#">
                                <div class="inbox-item">
                                    <div class="inbox-item-img"><img src="/assets/images/users/avatar-5.jpg"
                                                                     class="rounded-circle" alt=""></div>
                                    <p class="inbox-item-author">Shahedk</p>
                                    <p class="inbox-item-text text-truncate">Hey! there I'm available...</p>

                                </div>
                            </a>
                        </div> <!-- end inbox-widget -->

                    </div>
                    <!-- All-->
                    <a href="javascript:void(0);" class="dropdown-item text-primary notify-item notify-all">
                        View all
                        <i class="fi-arrow-right"></i>
                    </a>

                </div>
            </li>

            <li class="dropdown notification-list">
                <a class="nav-link dropdown-toggle nav-user mr-0 waves-effect waves-light" data-toggle="dropdown"
                   href="#" role="button" aria-haspopup="false" aria-expanded="false">
                    <img src="https://scontent.fsgn2-3.fna.fbcdn.net/v/t39.30808-6/276166943_1879329568932762_3952387809291728812_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=1E2tXsOrm-QAX-cwz6t&_nc_ht=scontent.fsgn2-3.fna&oh=00_AT9XQ36lQRMTvKt2znfiFeLAtKvBrOo0IYC6lJTnyWBSTg&oe=62B03AE6"
                         alt="user-image" class="rounded-circle">
                    <span class="d-none d-sm-inline-block ml-1 font-weight-medium">Phúc Nguyễn</span>
                    <i class="mdi mdi-chevron-down d-none d-sm-inline-block"></i>
                </a>
                <div class="dropdown-menu dropdown-menu-right profile-dropdown ">
                    <!-- item-->
                    <div class="dropdown-header noti-title">
                        <h6 class="text-overflow text-white m-0">Welcome !</h6>
                    </div>

                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <i class="mdi mdi-account-outline"></i>
                        <span>Profile</span>
                    </a>

                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <i class="mdi mdi-settings-outline"></i>
                        <span>Settings</span>
                    </a>

                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <i class="mdi mdi-lock-outline"></i>
                        <span>Lock Screen</span>
                    </a>

                    <div class="dropdown-divider"></div>

                    <!-- item-->
                    <a href="javascript:void(0);" class="dropdown-item notify-item">
                        <i class="mdi mdi-logout-variant"></i>
                        <span>Logout</span>
                    </a>

                </div>
            </li>
        </ul>

        <!-- LOGO -->
        <%@include file="/cp/layout/navbar/logo-box.jsp" %>
        <%@include file="/cp/layout/navbar/topnav-menu-left.jsp" %>
    </div>
    <!-- end Topbar -->


    <!-- ========== Left Sidebar Start ========== -->
    <%@include file="/cp/layout/left-sidemenu.jsp" %>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->

    <div class="content-page">
        <div class="content">

            <!-- Start Content-->
            <div class="container-fluid">

                <!-- start page title -->
                <div class="row">
                    <div class="col-12">
                        <div class="page-title-box">
                            <div class="page-title-right">
                                <ol class="breadcrumb m-0">
                                    <li class="breadcrumb-item"><a href="javascript: void(0);">Uplon</a></li>
                                    <li class="breadcrumb-item active">Create User</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Create User</h4>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <form action="" method="post" class="parsley-examples"  enctype="multipart/form-data" data-parsley-validate="" novalidate="">
                            <div class="row">

                                <div class="mb-3 col-6">
                                    <label for="userName" class="form-label">User Name<span
                                            class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="userName" name="userName"value="${userCreate.userName}">
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="password" class="form-label">Password<span
                                            class="text-danger">*</span></label>
                                    <input type="password" class="form-control" id="password" name="password" value="${userCreate.password}">
                                </div>
                            </div>
                            <div class="row">

                                <div class="mb-3 col-6">
                                    <label for="fullName" class="form-label">Full Name<span
                                            class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="fullName" name="fullName" value="${userCreate.fullName}">
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="phone" class="form-label">Phone<span
                                            class="text-danger">*</span></label>
                                    <input type="number" class="form-control" id="phone" name="phone" value="${userCreate.phone}">

                                </div>
                            </div>
                            <div class="row">

                                <div class="mb-3 col-6">
                                    <label for="email" class="form-label">Email<span
                                            class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="email" name="email" value="${userCreate.email}">
                                </div>
                                <div class="mb-3 col-6">
                                    <label for="address" class="form-label">Address<span
                                            class="text-danger">*</span></label>
                                    <input type="text" class="form-control" id="address" name="address" value="${userCreate.address}">
                                </div>

                            </div>
                            <div class="row">
                                <div class="mb-3 col-6">
                                    <label for="file" class="form-label">Images<span
                                            class="text-danger">*</span></label>
                                    <input type="file" class="form-control" id="file" name="file" value="${userCreate.img}">
                                    <%--                                    <input type="text" readonly value="img">--%>

                                </div>
                                <div class="mb-3 col-6">
                                    <label for="role" class="form-label">Role<span
                                            class="text-danger">*</span></label>
                                    <select name="role" id="role" class="form-control" value="${userCreate.role}">
                                        <option value="ADMIN">ADMIN</option>
                                        <option value="USER">USER</option>
                                    </select>
                                </div>

                            </div>
                            <div class="row">
                                <div class="form-group text-right mb-0">
                                    <button class="btn btn-primary waves-effect waves-light mr-1" style="margin-bottom: 10px" type="submit">
                                        Submit
                                    </button>
                                    <button type="reset" class="btn btn-secondary waves-effect" style="margin-bottom: 10px">
                                        Cancel
                                    </button>
                                </div>
                            </div>
                        </form>
                        <div class="row" style="margin-top: 20px">
                            <div class="col-12">
                                <c:if test="${requestScope['success'] == true}">
                                        <span class="alert alert-success col-3" style="font-size: 15px">Thêm mới thành công</span>
                                </c:if>
                                <c:if test="${!requestScope['errors'].isEmpty()}">
                                    <c:forEach items="${requestScope['errors']}" var="item">
                                            <div class="alert alert-danger col-3" style="margin-top: -20px;">
                                            <span style="font-size: 15px;" >
                                                    ${item}
                                            </span>
                                            </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- end page title -->

            <!-- Footer Start -->
            <%@include file="/cp/layout/footer.jsp" %>
            <!-- end Footer -->

        </div>

        <!-- ============================================================== -->
        <!-- End Page content -->
        <!-- ============================================================== -->

    </div>
    <!-- END wrapper -->

    <!-- Right Sidebar -->
    <%@include file="/cp/layout/rightBar.jsp" %>

    <%@include file="/cp/layout/script/script.jsp" %>

</body>
</html>