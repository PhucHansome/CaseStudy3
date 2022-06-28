package com.cg.controller;

import model.Products;
import service.IProductService;
import service.ProductService;
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

@WebServlet(name = "CPProductServlet", urlPatterns = "/cp/product")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 50, // 50MB
        maxRequestSize = 1024 * 1024 * 50) // 50MB
public class CPProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    IProductService productService;

    @Override
    public void init() throws ServletException {
        productService = new ProductService();
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
            case "delete":
                deleteProduct(req, resp);
                break;
            case"selling":
                setupSelling(req,resp);
                break;
            case "stopSell":
                setupStopSell(req,resp);
                break;
            case "search":
                searchByName(req, resp);
                break;
            default:
                searchByName(req, resp);
                break;
        }
    }

    private void setupStopSell(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("id"));
        productService.stopSelling(productId);
        List<Products> productsList = productService.findAll();
        req.setAttribute("productList", productsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/List.jsp");
        dispatcher.forward(req, resp);
    }

    private void setupSelling(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("id"));
        productService.selling(productId);
        List<Products> productsList = productService.findAll();
        req.setAttribute("productList", productsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/List.jsp");
        dispatcher.forward(req, resp);
    }

    private void searchByName(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Products> productsList = null;
        String query = "";
        if (req.getParameter("search") != null) {
            query = req.getParameter("search");

            productsList = productService.findNameProducts(query);
        } else {
            productsList = productService.findAll();
        }
        req.setAttribute("productList", productsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/List.jsp");
        dispatcher.forward(req, resp);
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("id"));
        productService.remove(productId);
        List<Products> productsList = productService.findAll();
        req.setAttribute("productList", productsList);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/List.jsp");
        dispatcher.forward(req, resp);
    }

    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long productId = Long.parseLong(req.getParameter("id"));
        Products products = productService.findById(productId);
        List<String> errors = new ArrayList<>();
        if (!productService.existByProductId(productId)) {
            errors.add("UserId không tồn tại");
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/Edit.jsp");
        req.setAttribute("products", products);
        dispatcher.forward(req, resp);
    }

    private void showCreatePage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/Create.jsp");
        List<Products> productsList = productService.findAll();
        req.setAttribute("productList", productsList);
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
            case "search":
                searchByName(req, resp);
                break;

        }
    }

    private void doUpdate(HttpServletRequest req, HttpServletResponse resp, String imageName) throws ServletException, IOException {
        Products updateProduct;
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/Edit.jsp");
        long productId = Long.parseLong(req.getParameter("id").trim());
        String nameProduct = req.getParameter("nameProduct").trim();
        String priceProduct = req.getParameter("priceProduct").trim();
        String quantityProduct = req.getParameter("quantityProduct").trim();
        String typeProduct = req.getParameter("typeProduct").trim();
        String description = req.getParameter("description").trim();
//        String image = imageName;
        List<String> errors = new ArrayList<>();
        boolean isPrinceProduct = ValidateUtils.isNumberVailid(priceProduct);
        boolean isQuantityProduct = ValidateUtils.isNumberVailid(quantityProduct);
        double checkPrice = Double.parseDouble(priceProduct);
        updateProduct = new Products(productId, nameProduct, priceProduct, quantityProduct, typeProduct, description, imageName);


        if (
                nameProduct.isEmpty() ||
                        priceProduct.isEmpty() ||
                        quantityProduct.isEmpty() ||
                        typeProduct.isEmpty() ||
                        description.isEmpty() ) {
            errors.add("Hãy nhập đầy đủ thông tin");
        }
        if (nameProduct.isEmpty()) {
            errors.add("Name Product không được để trống");
        }
        if (priceProduct.isEmpty()) {
            errors.add("Price Product không được để trống");
        }
        if (quantityProduct.isEmpty()) {
            errors.add("Quantity Product không được để trống");
        }
        if (typeProduct.isEmpty()) {
            errors.add("Type Product không được để trống");
        }
        if (description.isEmpty()) {
            errors.add("Description không được để trống ");
        }
        if (!isPrinceProduct) {
            errors.add("Price Product phải là một số và là một số dương");
        }
        if (checkPrice > 999999999){
            errors.add("Price phải nhỏ hơn 1 tỷ đồng!");
        }
        if (!isQuantityProduct) {
            errors.add("Quantity Product phải là một số và là một số dương");
        }
        if (!typeProduct.equals("SmartPhone") && !typeProduct.equals("LapTop") && !typeProduct.equals("Accessory")) {
            errors.add("Type Không đúng, xin hãy chọn lại");
        }
        if(!imageName.contains(".jpg") ){
            errors.add("Định dạng file ảnh không đúng vui lòng chọn lại");
        }
        if (errors.size() == 0) {
            updateProduct = new Products(productId, nameProduct, priceProduct, quantityProduct, typeProduct, description, imageName);
            boolean success = false;
            success = productService.update(updateProduct);
            if (success) {
                req.setAttribute("success", true);
            } else {
                req.setAttribute("errors", true);
                errors.add("Invalid data, Please check again!");
            }
        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("products", updateProduct);
        }
        dispatcher.forward(req, resp);
    }


    private void doCreate(HttpServletRequest req, HttpServletResponse resp, String imageName) throws ServletException, IOException {
        Products products;
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/Create.jsp");
        String nameProduct = req.getParameter("nameProduct").trim();
        String priceProduct = req.getParameter("priceProduct").trim();
        String quantityProduct = req.getParameter("quantityProduct").trim();
        String typeProduct = req.getParameter("typeProduct").trim();
        String description = req.getParameter("description").trim();
//        String image = imageName.trim();
        List<String> errors = new ArrayList<>();
        boolean isPriceProduct = ValidateUtils.isNumberVailid(priceProduct);
        boolean isQuantityProduct = ValidateUtils.isNumberVailid(quantityProduct);


        products = new Products(nameProduct, priceProduct, quantityProduct, typeProduct, description, imageName);


        if (
                nameProduct.isEmpty() ||
                        priceProduct.isEmpty() ||
                        quantityProduct.isEmpty() ||
                        typeProduct.isEmpty() ||
                        description.isEmpty()
        ) {
            errors.add("Vui lòng điền đầy đủ thông tin");
        } else if (nameProduct.isEmpty()) {
            errors.add("");
        }
        if (nameProduct.isEmpty()) {
            errors.add("Name Product không được để trống");
        }
        if (priceProduct.isEmpty()) {
            errors.add("Prince Product không được để trống");
        }
        if (quantityProduct.isEmpty()) {
            errors.add("Quantity Product không được để trống");
        }
        if (typeProduct.isEmpty()) {
            errors.add("Type Không được để trống");
        }
        if (description.isEmpty()) {
            errors.add("Description không được để trống");
        }

        if (!isPriceProduct) {
            errors.add("Prince phải là một số và là số dương");
        }
        if (!isQuantityProduct) {
            errors.add("Quantity phải là một số và là số dương");
        }
        if (!typeProduct.equals("SmartPhone") && !typeProduct.equals("LapTop") && !typeProduct.equals("Accessory")) {
            errors.add("Type Không đúng, xin hãy chọn lại");
        }
        if(!imageName.contains(".jpg")){
            errors.add("Định dạng file ảnh không đúng vui lòng chọn lại");
        }
        if (errors.size() == 0) {
            products = new Products(nameProduct, priceProduct, quantityProduct, typeProduct, description, imageName);
            boolean success = false;
            success = productService.create(products);
            if (success) {
                req.setAttribute("success", true);
            } else {
                req.setAttribute("errors", true);
                errors.add("Invalid data, Please check again!");
            }


        }
        if (errors.size() > 0) {
            req.setAttribute("errors", errors);
            req.setAttribute("productCreate", products);
        }
        dispatcher.forward(req, resp);
    }

    private void showListPage(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/cp/product/List.jsp");
        List<Products> productsList = productService.findAll();
        req.setAttribute("productList", productsList);
        dispatcher.forward(req, resp);
    }
}
