package com.cg.controller;

import model.User;
import service.IUserService;
import service.UserService;
import utils.ValidateUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CPUserServlet", urlPatterns = "/cp/user")
public class CPUserServlet extends HttpServlet {
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
                break;
            case "list":
                showListPage(req, resp);
                break;
            default:
                showListPage(req, resp);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                doCreate(req, resp);
                break;
            default:
                showListPage(req, resp);
                break;
        }

    }

    private void doCreate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Create.jsp");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String fullName = req.getParameter("fullName");
        String strphone = req.getParameter("phone");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String Role = req.getParameter("role");
        String img = req.getParameter("img");

        List<String> errors = new ArrayList<>();

        boolean isPhone = ValidateUtils.isNumberVailid(strphone);
        boolean isEmail = ValidateUtils.isEmailValid(email);

        if (userName.isEmpty()) {
            errors.add("Userame không được để trống");
        } else if (password.isEmpty()) {
            errors.add("Password không được để trống");
        } else if (fullName.isEmpty()) {
            errors.add("Fullname không được để trống");
        } else if (!isPhone && strphone.isEmpty()) {
            errors.add("Phone Nhập vào không đúng");
        } else if (!isEmail && email.isEmpty()) {
            errors.add("Email nhập vào không đúng");
        } else if (address.isEmpty()) {
            errors.add("Address không được để trống");
        } else if (Role.isEmpty()) {
            errors.add("Role không được chọn");
        } else if (img.isEmpty()) {
            errors.add("URL không được để trống");
        } else if (errors.size() == 0) {
            long phone = Long.parseLong(strphone);
            User user = new User(userName,password,fullName,phone,email,address,Role,img);
            boolean success = false;
            if (phone > 0){
                success = userService.create(user);
            }else{
                errors.add("phone sai");
            }
            if (success){
                req.setAttribute("success", true);
            } else {
                req.setAttribute("error", true);
                errors.add("Invalid data, Please check again!");
            }
        }
        if(errors.size() > 0){
            req.setAttribute("error", errors);
        }
        dispatcher.forward(req,resp);
    }

    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/Create.jsp");
        List<User> userList = userService.findAll();
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }

    private void showListPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/user/List.jsp");
        List<User> userList = userService.findAll();
        req.setAttribute("userList", userList);
        dispatcher.forward(req, resp);
    }
}
