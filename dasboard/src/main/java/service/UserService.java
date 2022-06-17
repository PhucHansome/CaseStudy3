package service;

import model.User;
import utils.MySQLConnUtils;

import java.awt.*;
import java.awt.image.RescaleOp;
import java.net.CacheRequest;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PrimitiveIterator;

public class UserService implements IUserService {

    private static String SELECT_ALL_USER = "" +
            "SELECT " +
            "u.username, " +
            "u.fullName, " +
            "u.phone, " +
            "u.email, " +
            "u.address, " +
            "u.roles, " +
            "u.createDate, " +
            "u.updateDate," +
            "u.img " +
            "From user AS u ;";
    private static String SP_INSERT_USER = "{CALL `sp_insert_user`(?,?,?,?,?,?,?,now(),?,?,?)}";

    private static String INSERT_USER = "" +
            "INSERT INTO `user`(`userName`,`password`,`fullname`,`phone`,`email`,`address`,`roles`,`createDate`,`img`)"+
    " VALUES (?,?,?,?,?,?,?,now(),?);";
//    IN `user_name` VARCHAR(255),
//    IN `pass_word` VARCHAR(255),
//    IN `full_Name` VARCHAR(255),
//    IN `phones` BIGINT,
//    IN `emails` VARCHAR(255),
//    IN `addresss` VARCHAR(255),
//    IN`roless` VARCHAR(255),
//    IN `imgs` LONGTEXT,
//    OUT message VARCHAR(255)

    @Override
    public boolean create(User user) {
    boolean success = false;

        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statemen = connection.prepareCall(INSERT_USER);
            statemen.setString(1,user.getUserName());
            statemen.setString(2,user.getPassword());
            statemen.setString(3,user.getFullName());
            statemen.setLong(4,user.getPhone());
            statemen.setString(5,user.getEmail());
            statemen.setString(6,user.getAddress());
            statemen.setString(7,user.getRole());
            statemen.setString(8,user.getImg());

            statemen.execute();

            success = true;
            String message =statemen.getString("message");
        } catch (SQLException e){
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public User findById(int userId) {
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(SELECT_ALL_USER);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("userName");
                String fullName = rs.getString("fullName");
                long phone = rs.getLong("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String roles = rs.getString("roles");
                String createDate = String.valueOf(rs.getDate("createDate"));
                String updateDate = String.valueOf(rs.getDate("updateDate"));
                String image = rs.getString("img");

                userList.add(new User(userName,fullName,phone,email,address,roles,createDate,updateDate,image));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
}
