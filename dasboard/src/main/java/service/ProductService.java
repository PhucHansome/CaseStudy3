package service;

import model.Products;
import utils.MySQLConnUtils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ProductService implements IProductService{
    private static String SELECT_ALL_PRODUCT = "" +
            "SELECT " +
            "p.productId, " +
            "p.nameProduct, " +
            "p.priceProduct, " +
            "p.quantityProduct, " +
            "p.typeProduct, " +
            "p.description, " +
            "p.img " +
            "FROM products AS p ;";



    @Override
    public boolean create(Products products) {
        return false;
    }

    @Override
    public boolean update(Products products) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public List<Products> findAll() {
        List<Products> productsList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(SELECT_ALL_PRODUCT);
            ResultSet rs = statement.executeQuery();
            while (rs.next()){
                long productId = rs.getInt("productId");
                String nameProduct = rs.getString("nameProduct");
                String princeProduct = String.valueOf(rs.getDouble("priceProduct"));
                String quantityProduct = String.valueOf(rs.getInt("quantityProduct"));
                String typeProduct = rs.getString("typeProduct");
                String description = rs.getString("description");
                String image = rs.getString("img");

//                productsList.add(new Products())


            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return productsList;
    }

    @Override
    public Products findById(long productId) {
        return null;
    }
}
