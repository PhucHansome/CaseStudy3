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
            default:
                showListPage(req, resp);
                break;
        }
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long userId = Long.parseLong(req.getParameter("id"));
        User user = userService.findById(userId);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Edit.jsp");
        req.setAttribute("user", user);
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
            default:
                showListPage(req, resp);
                break;
        }

    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp, String img) throws ServletException, IOException {
        User updateUser;
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Edit.jsp");
        long userId = Long.parseLong(req.getParameter("id").trim());
        String fullName = req.getParameter("fullName").trim();
        String phone = req.getParameter("phone").trim();
        String email = req.getParameter("email").trim();
        String address = req.getParameter("address").trim();
        List<String> errors = new ArrayList<>();
        boolean isPhone = ValidateUtils.isNumberVailid(phone);
        boolean isEmail = ValidateUtils.isEmailValid(email);

        updateUser = new User(userId, fullName, phone, email, address, img);
        if (fullName.isEmpty() ||
                phone.isEmpty() ||
                email.isEmpty() ||
                address.isEmpty()) {
            errors.add("Hãy nhập đầy đủ thông tin");
        } else if (fullName.isEmpty()) {
            errors.add("");
        }
        if (fullName.isEmpty()) {
            errors.add("Full name không được để trống");
        }
        if (phone.isEmpty()) {
            errors.add("Phone không được để trống");
        }
        if (!isPhone) {
            errors.add("Phone không đúng định dạng");
        }
        if (email.isEmpty()) {
            errors.add("Email không được để trống");
        }
        if (!isEmail) {
            errors.add("Email không đúng định dạng");
        }
        if (address.isEmpty()) {
            errors.add("Address không được để trống");
        }
        if (userService.existsByEmail(email)) {
            errors.add("Email đã tồn tại");
        } else if (errors.size() == 0) {

            updateUser = new User(userId, fullName, phone, email, address, img);
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


    private void doCreate(HttpServletRequest req, HttpServletResponse resp, String imageName) throws ServletException, IOException {
        User user;
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Create.jsp");
        String userName = req.getParameter("userName").trim();
        String password = req.getParameter("password").trim();
        String fullName = req.getParameter("fullName").trim();
        String phone = req.getParameter("phone").trim();
        String email = req.getParameter("email").trim();
        String address = req.getParameter("address").trim();
        String Role = req.getParameter("role").trim();
        String img = imageName.trim();

        List<String> errors = new ArrayList<>();

        boolean isPhone = ValidateUtils.isNumberVailid(phone);
        boolean isEmail = ValidateUtils.isEmailValid(email);

        user = new User(userName, password, fullName, phone, email, address, Role, imageName);
        if (userName.isEmpty() ||
                password.isEmpty() ||
                fullName.isEmpty() ||
                phone.isEmpty() ||
                email.isEmpty() ||
                address.isEmpty() ||
                Role.isEmpty() ||
                img.isEmpty()) {
            errors.add("Hãy nhập đầy đủ thông tin");
        } else if (userName.isEmpty()) {
            errors.add("");
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
        if (!Role.equals("ADMIN") && !Role.equals("USER")){
            errors.add("Role phải là ADMIN hoặc USER");
        } else if (errors.size() == 0) {
            user = new User(userName, password, fullName, phone, email, address, Role, imageName);
            boolean success = false;
            success = userService.create(user);

            if (success) {
                req.setAttribute("success", true);
            } else {
                req.setAttribute("errors", true);
                errors.add("Invalid data, Please check again!");
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
