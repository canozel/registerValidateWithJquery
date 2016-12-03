package com.canozel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.canozel.model.User;
import com.canozel.util.DBUtil;

public class UserDAOImpl implements UserDAO {
	
	private Connection conn;
	
	public UserDAOImpl() {
		conn = DBUtil.getConnection();
	}
	
	@Override
	public void addUser(User user) {
		try {
            String query = "insert into users (email, password) values (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString( 1, user.getEmail());
            preparedStatement.setString( 2, user.getPassword());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void deleteUser(int id) {
		try {
            String query = "delete from users where id=?";
            PreparedStatement preparedStatement = conn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	@Override
	public void updateUser(User user) {
		// TODO

	}
	
	@Override
	public boolean doesExistUserEmail(String email) throws SQLException {
		PreparedStatement preparedStatement = null;
        try {
            String query = "select email from users where email=?";
            preparedStatement = conn.prepareStatement( query );
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            return resultSet.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	preparedStatement.close();
		}
		return false;
        
	}

}
