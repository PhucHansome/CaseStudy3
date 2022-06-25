<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Dashboard | Uplon - Responsive Bootstrap 4 Admin Dashboard</title>
    <%@include file="/cp/layout/header.jsp" %>
</head>

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
                                    <li class="breadcrumb-item active">Edit Product</li>
                                </ol>
                            </div>
                            <h4 class="page-title">Edit Product</h4>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-12">
                        <form action="" method="post" class="parsley-examples"  enctype="multipart/form-data"  data-parsley-validate="" novalidate="">
                            <div class="mb-3 col-6">
                                <span>Name Product</span>
                                <input type="text" required="" class="form-control" name="nameProduct" value="${products.nameProduct}" autofocus>
                            </div>
                            <div class="mb-3 col-6">
                                <span>Quantity</span>
                                <input type="text" required="" class="form-control" name="quantityProduct" value="${products.quantityProduct}">
                            </div>
                            <div class="mb-3 col-6">
                                <span>Prince</span>
                                <input type="text" required="" class="form-control" name="priceProduct" value="${products.priceProduct}">
                            </div>
                            <div class="mb-3 col-6">
                                <span>Type</span>
                                <Select required="" name="typeProduct" id="typeProduct" class="form-control" value="${products.typeProduct}">
                                    <option value="SmartPhone" >SmartPhone</option>
                                    <option value="LapTop">LapTop</option>
                                    <option value="Accessory">Accessory</option>
                                </Select>
                            </div>
                            <div class="mb-3 col-6">
                                <span>Description</span>
                                <input type="text" class="form-control" name="description" required=""  value="${products.description}">
                            </div>
                            <div class="mb-3 col-6">
                                <span>Images</span>
                                <input type="file" class="form-control-file" name="file" required  accept="image/jpeg, image/png">
                            </div>
                            <div class="row">
                                <div class="form-group text-right mb-0">
                                    <button href="/cp/user?action=edit&id=${products.productId}" class="btn btn-primary waves-effect waves-light mr-1" type="submit"
                                            style="margin-left: 25px;">
                                       Save
                                    </button>
                                </div>
                            </div>
                        </form>
                        <div style="margin-top: 20px">
                            <c:if test="${requestScope['success'] == true}">
                                <ul class="alert alert-success col-3">
                                    <li style="font-size: 15px">Sửa thành công</li>
                                </ul>
                            </c:if>
                            <c:if test="${!requestScope['errors'].isEmpty()}">
                                <ul >
                                    <c:forEach items="${requestScope['errors']}" var="item">
                                        <li  class="alert alert-danger col-3" style="font-size: 15px">
                                                ${item}
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:if>
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