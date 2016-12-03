package com.canozel.dao;

import java.sql.SQLException;

import com.canozel.model.User;

public interface UserDAO {
	public void addUser(User user);
	public void deleteUser(int id);
	public void updateUser(User user);
	public boolean doesExistUserEmail(String email) throws SQLException;
}
