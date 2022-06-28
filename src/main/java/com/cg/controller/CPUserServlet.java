package com.cg.controller;

import model.User;
import service.IUserService;
import service.UserService;
import utils.UploadImage;
import utils.ValidateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CPUserServlet", urlPatterns = "/cp/user")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CPUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IUserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreatePage(req, resp);
                break;
            case "edit":
                showEditForm(req, resp);
                break;
            case "list":
                showListPage(req, resp);
                break;
            case "viewdetail":
                doView(req, resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            default:
                searchByName(req, resp);
                break;
        }
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList = null;
        String query = "";
        if (req.getParameter("search") != null) {
            query = req.getParameter("search");

            userList = userService.findNameUser(query);
        } else {
            userList = userService.findAll();
        }
        req.setAttribute("userList", userList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/List.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = Long.parseLong(req.getParameter("id"));
        User user = userService.findById(userId);
        List<String> errors = new ArrayList<>();
        if (!userService.existByUserId(userId)) {
            errors.add("UserId không tồn tại");
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Edit.jsp");
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html/charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                String imageName = UploadImage.uploadImages(req, resp);
                doCreate(req, resp, imageName);
                break;
            case "edit":
                imageName = UploadImage.uploadImages(req, resp);
                doUpdate(req, resp, imageName);
                break;
            case "viewdetail":
                doView(req, resp);
                break;
            default:
            case "search":
                searchByName(req, resp);
                break;
        }

    }

    private void doView(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = Long.parseLong(req.getParameter("id"));
        User user = userService.findFullById(userId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Viewdetail.jsp");
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp, String img) throws ServletException, IOException {
        User updateUser = null;
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Edit.jsp");
        long userId = Long.parseLong(req.getParameter("id").trim());
        String fullName = req.getParameter("fullName").trim();
        String phone = req.getParameter("phone").trim();
        String address = req.getParameter("address").trim();
        List<String> errors = new ArrayList<>();
        boolean isPhone = ValidateUtils.isNumberPhoneVailid(phone);
        if (fullName.isEmpty() ||
                phone.isEmpty() ||
                address.isEmpty()) {
            errors.add("Hãy nhập đầy đủ thông tin");
        }
//        try {
//           userId = Long.parseLong(userIdRaw);
        updateUser = new User(userId, fullName, phone, address, img);
//        }catch (NumberFormatException e){
//            errors.add("ID không tồn tại");
//        }
        if (fullName.isEmpty()) {
            errors.add("Full name không được để trống");
        }
        if (phone.isEmpty()) {
            errors.add("Phone không được để trống");
        }
        if (!isPhone) {
            errors.add("Phone không đúng định dạng");
        }
        if (address.isEmpty()) {
            errors.add("Address không được để trống");
        }
        if (!img.contains(".jpg") && !img.contains(".png")) {
            errors.add("Định dạng file ảnh không đúng vui lòng chọn lại");
        }

        if (errors.size() == 0) {
            updateUser = new User(userId, fullName, phone, address, img);
            boolean success = false;
            success = userService.update(updateUser);
            if (success) {
                req.setAttribute("success", true);
            } else {
                req.setAttribute("errors", true);
                errors.add("Invalid data, Please check again!");
            }
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("user", updateUser);
        }
        dispatcher.forward(req, resp);
    }


    private void doCreate(HttpServletRequest req, HttpServletResponse resp, String imageName) throws
            ServletException, IOException {
        User user;
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Create.jsp");
        String userName = req.getParameter("userName").replaceAll(" ", "").toLowerCase();
        String password = req.getParameter("password").trim();
        String fullName = req.getParameter("fullName").trim();
        String phone = req.getParameter("phone").trim();
        String email = req.getParameter("email").trim();
        String address = req.getParameter("address").trim();
        String Role = req.getParameter("role").trim();
        String img = imageName.trim();

        List<String> errors = new ArrayList<>();
        boolean isPassword = ValidateUtils.isPasswordVailid(password);
        boolean isPhone = ValidateUtils.isNumberPhoneVailid(phone);
        boolean isEmail = ValidateUtils.isEmailValid(email);
//        boolean isUserName = ValidateUtils.isUserNameVailid(userName);

        user = new User(userName, password, fullName, phone, email, address, Role, imageName);
        if (userName.isEmpty() ||
                password.isEmpty() ||
                fullName.isEmpty() ||
                phone.isEmpty() ||
                email.isEmpty() ||
                address.isEmpty() ||
                Role.isEmpty() ||
                img.isEmpty()) {
            errors.add("Vui lòng điền đầy đủ thông tin");
        }
        if (userName.isEmpty()) {
            errors.add("UserName không được để trống");
        }
        if (password.isEmpty()) {
            errors.add("Password không được để trống");
        }
        if (fullName.isEmpty()) {
            errors.add("Fullname không được để trống");
        }
        if (phone.isEmpty()) {
            errors.add("Phone Nhập vào không đúng");
        }
        if (!isPhone) {
            errors.add("Phone không đúng định dạng");
        }
        if (email.isEmpty()) {
            errors.add("Email nhập vào không đúng");
        }
        if (!isEmail) {
            errors.add("Email nhập vào không đúng dịnh dạng");
        }
        if (address.isEmpty()) {
            errors.add("Address không được để trống");
        }
        if (Role.isEmpty()) {
            errors.add("Role không được chọn");
        }
        if (img.isEmpty()) {
            errors.add("URL không được để trống");
        }
        if (userService.existsByEmail(email)) {
            errors.add("Email đã tồn tại");
        }
        if (!Role.equals("ADMIN") && !Role.equals("USER")) {
            errors.add("Role phải là ADMIN hoặc USER");
        }
//        if (!isUserName) {
//            errors.add("UserName không đúng định dạng (không có khoảng cách) ");
//        }
        if (userService.existByUsername(userName)) {
            errors.add("Username này đã tồn tại!");
        }
        if (!isPassword) {
            errors.add("Password không đúng định dạng");
        }
        if (!imageName.contains(".jpg")) {
            errors.add("Định dạng file ảnh không đúng vui lòng chọn lại");
        }
        if (errors.size() == 0) {
            user = new User(userName, password, fullName, phone, email, address, Role, imageName);
            boolean success = false;
            success = userService.create(user);

            if (success) {
                req.setAttribute("success", true);
            } else {
                req.setAttribute("errors", true);
                errors.add("Dữ liệu không hợp lệ, Vui lòng kiểm tra lại!");
            }

        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("userCreate", user);
        }
        dispatcher.forward(req, resp);
    }

    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Create.jsp");
        List<User> userList = userService.findAll();
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }

    private void showListPage(HttpServletRequest req, HttpServletResponse resp) throws
            ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/List.jsp");
        List<User> userList = userService.findAll();
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }
}
