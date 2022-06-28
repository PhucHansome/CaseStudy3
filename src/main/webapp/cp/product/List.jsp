<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard | Uplon - Responsive Bootstrap 4 Admin Dashboard</title>
    <%@include file="/cp/layout/header.jsp" %>
</head>
<style>
    th, td {
        text-align: center;

    }
    th {
        background-color: #2b3d51;
        color: #d9e4ef;
    }
    .btn-12{
        position: relative;
        right: 20px;
        bottom: 20px;
        border:none;
        box-shadow: none;
        width: 130px;
        height: 40px;
        line-height: 42px;
        -webkit-perspective: 230px;
        perspective: 230px;
    }
    .btn-12 span {
        background: rgb(0,172,238);
        background: linear-gradient(0deg, rgba(0,172,238,1) 0%, rgba(2,126,251,1) 100%);
        display: block;
        position: absolute;
        width: 130px;
        height: 40px;
        box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
        7px 7px 20px 0px rgba(0,0,0,.1),
        4px 4px 5px 0px rgba(0,0,0,.1);
        border-radius: 5px;
        margin:0;
        text-align: center;
        -webkit-box-sizing: border-box;
        -moz-box-sizing: border-box;
        box-sizing: border-box;
        -webkit-transition: all .3s;
        transition: all .3s;
    }
    .btn-12 span:nth-child(1) {
        box-shadow:
                -7px -7px 20px 0px #fff9,
                -4px -4px 5px 0px #fff9,
                7px 7px 20px 0px #0002,
                4px 4px 5px 0px #0001;
        -webkit-transform: rotateX(90deg);
        -moz-transform: rotateX(90deg);
        transform: rotateX(90deg);
        -webkit-transform-origin: 50% 50% -20px;
        -moz-transform-origin: 50% 50% -20px;
        transform-origin: 50% 50% -20px;
    }
    .btn-12 span:nth-child(2) {
        -webkit-transform: rotateX(0deg);
        -moz-transform: rotateX(0deg);
        transform: rotateX(0deg);
        -webkit-transform-origin: 50% 50% -20px;
        -moz-transform-origin: 50% 50% -20px;
        transform-origin: 50% 50% -20px;
    }
    .btn-12:hover span:nth-child(1) {
        box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
        7px 7px 20px 0px rgba(0,0,0,.1),
        4px 4px 5px 0px rgba(0,0,0,.1);
        -webkit-transform: rotateX(0deg);
        -moz-transform: rotateX(0deg);
        transform: rotateX(0deg);
    }
    .btn-12:hover span:nth-child(2) {
        box-shadow:inset 2px 2px 2px 0px rgba(255,255,255,.5),
        7px 7px 20px 0px rgba(0,0,0,.1),
        4px 4px 5px 0px rgba(0,0,0,.1);
        color: transparent;
        -webkit-transform: rotateX(-90deg);
        -moz-transform: rotateX(-90deg);
        transform: rotateX(-90deg);
    }
    td {
        font-size: 15px;
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
                    <img src="https://cdn.pixabay.com/photo/2012/04/10/23/04/vietnam-26834_960_720.png" alt="lang-image"
                         height="12">
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
                    <img src="https://scontent.fhan2-3.fna.fbcdn.net/v/t39.30808-6/276166943_1879329568932762_3952387809291728812_n.jpg?_nc_cat=108&ccb=1-7&_nc_sid=09cbfe&_nc_ohc=dcI8y0DbaRMAX9OlM5Q&_nc_ht=scontent.fhan2-3.fna&oh=00_AT9KXsBGMiHnIwZWSu3Q7ZtYAbzcTn3Dzd0P0SKjGgfhYw&oe=62B629A6"
                         height="40px" width="40px" style="border-radius: 50%">
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
                    <a href="/cp/login" class="dropdown-item notify-item">
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
                                    <li class="breadcrumb-item active">List Product</li>
                                </ol>
                            </div>
                            <h4 class="page-title">List Product</h4>
                        </div>
                    </div>
                </div>
                <!-- end page title -->
                <div class="row">
                    <div class="col-lg-4">
                        <div class="input-group">
                            <form method="get">
                                <input type="search" name="search" class="form-control" placeholder="Search..."
                                       style="border-radius: 20px;margin-top: -22px; margin-bottom: 10px;">
                                <button class="btn" type="submit" style="margin-top: -82px;margin-left: 149px;}">
                                    <i class="fas fa-search" style="left: 8px;color: #0000004a;"> </i>
                                </button>
                            </form>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <c:if test="${requestScope['success'] == true}">
                            <ul class="alert alert-secondary col-7">
                                <li style="font-size: 15px">Xóa thành công</li>
                            </ul>
                        </c:if>
                    </div>
                    <div class="col-lg-1" style="margin-left: -11px;">
                        <a href="/cp/product?action=create">
                            <button type="button" class="custom-btn btn-12 float-right" style="color: white">
                                <span><i class="fa-solid fa-hand-point-right"></i><b>Click!</b></span>
                                <span><b>Create Product</b></span>
                            </button>
                        </a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <table id="datatable" class="table table-hover"
                               style="border-collapse: collapse; border-spacing: 0; width: 100%;">
                            <thead>
                            <tr>
                                <th>IMAGE</th>
                                <th>NAME PRODUCT</th>
                                <th>QUANTITY</th>
                                <th>PRICE</th>
                                <th>TYPE</th>
                                <th>DESCRIPTION</th>
                                <th>STATUS</th>
                                <th>CREATEDATE</th>
                                <th>UPDATEDATE</th>
                                <th>ACTION</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${requestScope['productList']}" var="item">
                                <tr>
                                    <td class="align-middle"><img src="/assets/images/users/${item.getImage()}" alt=""
                                                                  width="150px"
                                                                  height="150px" style="border-radius:10px"></td>
                                    <td class="align-middle" style=" text-decoration: underline;"><b>${item.getNameProduct()}</b></td>
                                    <td class="align-middle">${item.getQuantityProduct()}</td>
                                    <td class="align-middle" style=" text-decoration: underline;"><b>${item.getPriceProduct()}</b></td>
                                    <td class="align-middle">${item.getTypeProduct()}</td>
                                    <td class="align-middle">${item.getDescription()}</td>
                                    <td class="align-middle">
                                    <c:if test='${item.getStatus().equals("Dừng bán")}'>
                                        <span  style="color: #dc3545; font-size: 15px;"><b>${item.getStatus()}</b></span>
                                    </c:if>
                                    <c:if test='${item.getStatus().equals("Đang bán")}'>
                                        <span style="color: #00e372;font-size: 15px;"><b>${item.getStatus()}</b></span>
                                    </c:if>
                                        <c:if test='${item.getStatus().equals("Hàng chờ")}'>
                                            <span style="color: #78a9db;font-size: 15px;"><b>${item.getStatus()}</b></span>
                                        </c:if>
                                    </td>
                                    <td class="align-middle"><b>${item.getCreateDate()}</b></td>
                                    <td class="align-middle">
                                        <c:if test="${item.getUpdateDate() == 'null'}">
                                            <p></p>
                                        </c:if>
                                        <c:if test="${item.getUpdateDate() != 'null'}">
                                            <b>${item.getUpdateDate()}</b>
                                        </c:if>
                                    </td>
                                    <td class="align-middle">
                                        <div class="btn-group">
                                            <a class=" btn btn-outline-secondary"
                                               href="/cp/product?action=edit&id=${item.getProductId()}"><i class="fa-solid fa-pen-to-square"></i></a>
                                        </div>
                                        <p></p>
                                        <div class="btn-group">
                                            <button type="button" class="btn btn-outline-secondary waves-effect dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                                <i class="mdi mdi-chevron-down"></i>
                                            </button>
                                            <div class="dropdown-menu" x-placement="bottom-start" style="position: absolute; will-change: transform; top: 0px; left: 0px; transform: translate3d(0px, 15px, 0px);">
                                                <a class="dropdown-item"  href="/cp/product?action=selling&id=${item.getProductId()}"><b>Đang bán</b></a>
                                                <a class="dropdown-item"  href="/cp/product?action=stopSell&id=${item.getProductId()}"><b>Dừng bán</b></a>
                                            </div>
                                        </div>
                                        <p></p>
                                        <div class="btn-group">
                                            <a class=" btn btn-outline-danger"
                                               href="/cp/product?action=delete&id=${item.getProductId()}"
                                               onclick="return confirm('Bạn có chắc muốn xóa sản phẩm này không?');">
                                                <i class="fa-solid fa-eraser"></i></a>
                                        </div>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>

                    </div>
                </div>
            </div>




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