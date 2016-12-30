package com.rahackya.restapp.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.rahackya.restapp.model.User;

/**
 * Created by Rajmani on 12/29/16.
 */
public class UserDao {
    private static UserDao instance = null;
    private static Connection connection = null;
    private UserDao() {
        try {
            Properties prop = new Properties();
            try {
                InputStream inputStream = UserDao.class.getResourceAsStream("/mysql.properties");
                prop.load(inputStream);
            } catch (FileNotFoundException e) {
                e.printStackTrace(System.out);
            } catch (IOException e) {
                e.printStackTrace(System.out);
            }
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            String url = "jdbc:mysql://" + prop.getProperty("host", "localhost") + ":" + prop.getProperty("port", "3306") +
                    "/" + prop.getProperty("database", "test") + "?user=" +
                    prop.getProperty("user", "root") + "&password=" + prop.getProperty("password", "root");
            
            connection = DriverManager.getConnection(url);
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }
        return instance;
    }

    public List<User> getAll() {
        List<User> users = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            stmt = connection.createStatement();
            res = stmt.executeQuery("SELECT * FROM friends;");
            users = new ArrayList<User>();
            while (res.next()) {
                User user = new User();
                user.setId(res.getInt("id"));
                user.setRollno(res.getInt("rollno"));
                user.setName(res.getString("name"));
                user.setEmail(res.getString("email"));
                user.setPhone(res.getString("phone"));
                user.setCompany(res.getString("company"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return users;
    }

    public User get(Integer id) {
        User user = null;
        Statement stmt = null;
        ResultSet res = null;
        try {
            stmt = connection.createStatement();
            res = stmt.executeQuery("SELECT * FROM friends where id="+id);
            if (res.next()) {
            	user = new User();
                user.setId(res.getInt("id"));
                user.setRollno(res.getInt("rollno"));
                user.setName(res.getString("name"));
                user.setEmail(res.getString("email"));
                user.setPhone(res.getString("phone"));
                user.setCompany(res.getString("company"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (res != null) {
                try {
                    res.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return user;
    }

    public boolean destroy(Integer id) {
        boolean success = false;
        Statement stmt = null;
        try {
            stmt = connection.createStatement();
            stmt.executeUpdate("DELETE FROM friends where id="+id);
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public boolean add(User user) {
        boolean success = false;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("INSERT into friends " +
                    "(rollno, name, email, phone, company) values (?, ?, ?, ?, ?)"
            );
            stmt.setInt(1, user.getRollno());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getCompany());
            stmt.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }

    public boolean update(Integer id, User user) {
        boolean success = false;
        PreparedStatement stmt = null;
        try {
            stmt = connection.prepareStatement("UPDATE friends SET rollno=?, name=?, email=?, phone=?, company=?" +
                    " where id=?"
            );
            stmt.setInt(1, user.getRollno());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPhone());
            stmt.setString(5, user.getCompany());
            stmt.setInt(6, id);
            stmt.executeUpdate();
            success = true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return success;
    }
}
