package com.cg.controller;

import model.User;
import service.IUserService;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CPLoginServlet", urlPatterns = "/cp/login")
public class CPLoginServlet extends HttpServlet {
    IUserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserService();

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/login/Login.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> user = userService.findAll();
        String userName = req.getParameter("userName").replaceAll(" ", "").toLowerCase();
        ;
        String password = req.getParameter("password");
        String role = req.getParameter("role");
        boolean checkRole = false;

        List<String> errors = new ArrayList<>();
        if (userService.existByUsername(userName)) {
            if (userService.existByPassWord1(password)) {
                resp.sendRedirect("/cp/user");
            } else {
                errors.add("Username or Password sai! Xin vui lòng nhập lại!");
                if (errors.size() > 0) {
                    req.setAttribute("errors", errors);
                }
                resp.sendRedirect("/cp/login");
            }
        } else {
            errors.add("Username or Password sai! Xin vui lòng nhập lại!");
            if (errors.size() > 0) {
                req.setAttribute("errors", errors);
            }
            resp.sendRedirect("/cp/login");
        }

    }

}


