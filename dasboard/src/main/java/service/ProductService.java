package service;

import model.Products;
import utils.FormatVND;
import utils.MySQLConnUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductService implements IProductService {
    private static String SELECT_ALL_PRODUCT = "" +
            "SELECT " +
            "p.productId, " +
            "p.nameProduct, " +
            "p.priceProduct, " +
            "p.quantityProduct, " +
            "p.typeProduct, " +
            "p.description, " +
            "p.img," +
            "p.createDate," +
            "p.updateDate," +
            "p.status " +
            "FROM products AS p ;";

    private static String INSERT_PRODUCT = "" +
            "INSERT INTO `products`(nameProduct, " +
            "priceProduct," +
            "quantityProduct," +
            "typeProduct," +
            "description," +
            "img," +
            "createDate ) " +
            "VALUES(?,?,?,?,?,?,now());";

    private static String UPDATE_PRODUCT = "" +
            "UPDATE casestudymodule3.`products` SET " +
            "nameProduct = ?, " +
            "priceProduct = ?, " +
            "quantityProduct = ?, " +
            "typeProduct = ?, " +
            "description = ?, " +
            "img = ?, " +
            "updateDate = now() " +
            "WHERE productId = ?";

    private static String DELETE_PRODUCT_BY_ID = "" +
//            "{CALL casestudymodule3.sp_delete_product(?)}";
            "DELETE FROM products WHERE productId =?;";

    private static String SEARCH_BY_NAME_TYPE = "" +
            "SELECT * FROM products  WHERE nameProduct LIKE ? OR typeProduct LIKE ? OR status LIKE ? ";
    private static String SETUP_SELL_STOP_PRODUCT = "" +
            "UPDATE casestudymodule3.`products` SET status = 'Dừng bán', updateDate = now()  WHERE productId = ?";
    private static String SETUP_SELLING_PRODUCT = "" +
            "UPDATE casestudymodule3.`products` SET status = 'Đang bán', updateDate = now() WHERE productId = ?";

    @Override
    public boolean create(Products products) {
        boolean success = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(INSERT_PRODUCT);
            statement.setString(1, products.getNameProduct());
            statement.setString(2, products.getPriceProduct());
            statement.setString(3, products.getQuantityProduct());
            statement.setString(4, products.getTypeProduct());
            statement.setString(5, products.getDescription());
            statement.setString(6, products.getImage());
            statement.execute();
            success = true;
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }

    @Override
    public boolean update(Products products) {
        boolean success = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(UPDATE_PRODUCT);
            statement.setString(1, products.getNameProduct());
            statement.setString(2, products.getPriceProduct());
            statement.setString(3, products.getQuantityProduct());
            statement.setString(4, products.getTypeProduct());
            statement.setString(5, products.getDescription());
            statement.setString(6, products.getImage());
            statement.setLong(7, products.getProductId());
            statement.executeUpdate();
            success = true;

        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }

    @Override
    public boolean remove(long id) {
        boolean rowDelete = false;
        try (Connection connection = MySQLConnUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID);) {
            preparedStatement.setInt(1, (int) id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rowDelete;
    }

    @Override
    public List<Products> findAll() {
        List<Products> productsList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(SELECT_ALL_PRODUCT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long productId = rs.getInt("productId");
                String nameProduct = rs.getString("nameProduct");
                String princeProduct = String.valueOf(FormatVND.doubleToVND(rs.getDouble("priceProduct")));
                String quantityProduct = String.valueOf(rs.getInt("quantityProduct"));
                String typeProduct = rs.getString("typeProduct");
                String description = rs.getString("description");
                String image = rs.getString("img");
                String createDate = String.valueOf(rs.getDate("createDate"));
                String updateDate = String.valueOf(rs.getDate("updateDate"));
                String status = rs.getString("status");

                productsList.add(new Products(productId, nameProduct, princeProduct, quantityProduct, typeProduct, description, image, createDate, updateDate, status));


            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }

    @Override
    public Products findById(long productId) {
        Products products = null;
        String query = "{CALL `get_product_by_id`(?)}";
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(query);
            statement.setLong(1, productId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String nameProduct = rs.getString("nameProduct");
                String princeProduct = rs.getString("priceProduct");
                String quantityProduct = rs.getString("quantityProduct");
                String typeProduct = rs.getString("typeProduct");
                String description = rs.getString("description");
                String image = rs.getString("img");
//                String status = rs.getString("status");
                products = new Products(productId, nameProduct, princeProduct, quantityProduct, typeProduct, description, image);
            }
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return products;
    }

    @Override
    public List<Products> findNameProducts(String str) {
        List<Products> productsList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(SEARCH_BY_NAME_TYPE);
            statement.setString(1, '%' + str + '%');
            statement.setString(2, '%' + str + '%');
            statement.setString(3, '%' + str + '%');


            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long productId = rs.getLong("productId");
                String nameProduct = rs.getString("nameProduct");
                String priceProduct = String.valueOf(FormatVND.doubleToVND(rs.getDouble("priceProduct")));
                String quantityProduct = rs.getString("quantityProduct");
                String typeProduct = rs.getString("typeProduct");
                String description = rs.getString("description");
                String image = rs.getString("img");
                String createDate = String.valueOf(rs.getDate("createDate"));
                String updateDate = String.valueOf(rs.getDate("updateDate"));
                String status = rs.getString("status");
                productsList.add(new Products(productId, nameProduct, priceProduct, quantityProduct, typeProduct, description, image, createDate, updateDate, status));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productsList;
    }


    public boolean stopSelling(long productId) {
        boolean setupStop = false;
        try (Connection connection = MySQLConnUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SETUP_SELL_STOP_PRODUCT);) {
            preparedStatement.setInt(1, (int) productId);
            setupStop = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setupStop;
    }

    @Override
    public boolean selling(long productId) {
        boolean setupSelling = false;
        try (Connection connection = MySQLConnUtils.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SETUP_SELLING_PRODUCT);) {
            preparedStatement.setInt(1, (int) productId);
            setupSelling = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return setupSelling;
    }


}
