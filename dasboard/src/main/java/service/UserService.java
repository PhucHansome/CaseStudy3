package service;

import model.Products;
import model.User;
import utils.FormatVND;
import utils.MySQLConnUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private static String SELECT_ALL_USER = "" +
            "SELECT " +
            "u.userId, " +
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
            "INSERT INTO `user`(`userName`," +
            "`password`," +
            "`fullname`," +
            "`phone`," +
            "`email`," +
            "`address`," +
            "`roles`," +
            "`createDate`," +
            "`img`)" +
            " VALUES (?,?,?,?,?,?,?,now(),?);";

    private static String UPDATE_USER = "" +
            "UPDATE casestudymodule3.`user` SET  `fullname`=? ,`phone`=? , `address`=?, `img`= ? ,updateDate = now() WHERE userId =?";

    private static String USER_EXIST_BY_EMAIL = "" +
            "SELECT COUNT(*) AS COUNT " +
            "FROM user AS u " +
            "WHERE u.email = ?;";
    private static String USER_EXIST_BY_USERNAME = "" +
            "SELECT COUNT(*) AS COUNT " +
            "FROM user AS u " +
            "WHERE u.username = ?;";

    private static String USER_EXIST_BY_USERNAME_PASSWORD = "" +
            "SELECT username, password  " +
            "FROM `user` AS u  " +
            "WHERE u.password = ? ;";

    private static String SEARCH_BY_NAME_TYPE = "" +
            "SELECT * FROM user  WHERE username LIKE ? OR fullName LIKE ? OR phone LIKE ? OR email LIKE ?  ";

    @Override
    public boolean create(User user) {
        boolean success = false;

        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statemen = connection.prepareCall(INSERT_USER);
            statemen.setString(1, user.getUserName());
            statemen.setString(2, user.getPassword());
            statemen.setString(3, user.getFullName());
            statemen.setString(4, user.getPhone());
            statemen.setString(5, user.getEmail());
            statemen.setString(6, user.getAddress());
            statemen.setString(7, user.getRole());
            statemen.setString(8, user.getImg());

            statemen.execute();

            success = true;
//            String message =statemen.getString("message");
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }

    @Override
    public boolean update(User user) {
        boolean success = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(UPDATE_USER);
            statement.setString(1, user.getFullName());
            statement.setString(2, user.getPhone());
            statement.setString(3, user.getAddress());
            statement.setString(4, user.getImg());
            statement.setLong(5, user.getUserId());
            System.out.println(statement);
            statement.executeUpdate();
            success = true;

        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return success;
    }

    @Override
    public boolean remove(long id) {
        return false;
    }

    @Override
    public User findById(long userId) {
        User user = null;
        String query = "{CALL get_user_by_id(?)}";
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(query);
            statement.setLong(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String fullname = rs.getString("fullName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String img = rs.getString("img");
                user = new User(userId, fullname, phone, email, address, img);
            }
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return user;
    }

    @Override
    public User findFullById(long userId) {
        User user = null;
        String query = "{CALL get_full_user_by_id_(?)}";
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(query);
            statement.setLong(1, userId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String fullName = rs.getString("fullName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String img = rs.getString("img");
                String Role = rs.getString("roles");
                String createDate = String.valueOf(rs.getDate("createDate"));
                String updateDate = String.valueOf(rs.getDate("updateDate"));
                user = new User(userId, username, password, fullName, phone, email, address, Role, createDate, updateDate, img);
            }
        } catch (SQLException e) {
            MySQLConnUtils.printSQLException(e);
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(SELECT_ALL_USER);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String fullName = rs.getString("fullName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("roles");
                String createDate = String.valueOf(rs.getDate("createDate"));
                String updateDate = String.valueOf(rs.getDate("updateDate"));
                String img = rs.getString("img");

                userList.add(new User(userId, userName, fullName, phone, email, address, role, createDate, updateDate, img));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> findNameUser(String query) {
        List<User> userList = new ArrayList<>();
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(SEARCH_BY_NAME_TYPE);
            statement.setString(1, '%' + query + '%');
            statement.setString(2, '%' + query + '%');
            statement.setString(3, '%' + query + '%');
            statement.setString(4, '%' + query + '%');
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                long userId = rs.getInt("userId");
                String userName = rs.getString("userName");
                String fullName = rs.getString("fullName");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                String address = rs.getString("address");
                String role = rs.getString("roles");
                String createDate = String.valueOf(rs.getDate("createDate"));
                String updateDate = String.valueOf(rs.getDate("updateDate"));
                String img = rs.getString("img");
                userList.add(new User(userId, userName, fullName, phone, email, address, role, createDate, updateDate, img));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public boolean existsByEmail(String email) {
        boolean exist = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(USER_EXIST_BY_EMAIL);
            statement.setString(1, email);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    exist = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    @Override
    public boolean existByUsername(String username) {
        boolean exist = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            PreparedStatement statement = connection.prepareCall(USER_EXIST_BY_USERNAME);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int count = rs.getInt("count");
                if (count > 0) {
                    exist = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }

    @Override
    public boolean existByPassWord1(String username) {
        boolean exist = false;
        try {
            Connection connection = MySQLConnUtils.getConnection();
            CallableStatement statement = connection.prepareCall(USER_EXIST_BY_USERNAME_PASSWORD);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String userName = rs.getString("username");
                String password = rs.getString("password");
                if (userName != null && password != null) {
                    exist = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exist;
    }


}
