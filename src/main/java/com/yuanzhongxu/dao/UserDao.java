package com.yuanzhongxu.dao;

import com.yuanzhongxu.model.User;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection con, User user) throws SQLException {
        //String sql = "insert into yzx(username,password,email,gender,birthdate)"+"values(?,?,?,?,?)";

//        PreparedStatement ps = con.prepareStatement(sql);
//        ps.setString(1,Username);
//        ps.setString(2,Password);
//        ps.setString(3,Email);
//        ps.setString(4,Gender);
//        ps.setString(5,BirthDate);
//        ps.executeUpdate();
        return false;
    }

    @Override
    public int deleteUser(Connection con, User user) throws SQLException {
        //String sql="delete * from yzx where id=?";
        return 0;
    }

    @Override
    public int updateUser(Connection con, User user) throws SQLException {
        //String sql="update where id=?";
        return 0;
    }

    @Override
    public User findById(Connection con, Integer id) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from yzx where id=? ";

        User user = null;
        try {
            ResultSet rs;
            //user = null;
            PreparedStatement st = con.prepareStatement(sql);
            rs = st.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthdate(rs.getDate("birthdate"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return user;
    }

    @Override
    public User findByUsernamePassword(Connection con, String username, String password) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from yzx where username=? and password=?";
        User user = null;
        try  {
            ResultSet rs;
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1,username);
            st.setString(2,password);
            rs = st.executeQuery();
            if(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setGender(rs.getString("gender"));
                user.setBirthdate(rs.getDate("birthdate"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return user;
    }

    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from yzx where username=? ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return (List<User>) user;

    }

    @Override
    public List<User> findByPassword(Connection con, String password) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from yzx where password=? ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return (List<User>) user;
    }

    @Override
    public List<User> findByEmail(Connection con, String email) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from yzx where email=? ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return (List<User>) user;
    }

    @Override
    public List<User> findByGender(Connection con, String gender) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from yzx where gender=? ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return (List<User>) user;
    }

    @Override
    public List<User> findByBirthdate(Connection con, Date birthDate) throws SQLException {
        String sql = "select id,username,password,email,gender,birthdate from yzx where birthdate=? ";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return (List<User>) user;
    }

    @Override
    public List<User> findAllUser(Connection con) throws SQLException {
        String sql = "select * from yzx";
        PreparedStatement st=con.prepareStatement(sql);
        ResultSet rs=st.executeQuery();
        User user=null;
        if(rs.next()){
            user=new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }

        return (List<User>) user;
    }
}
