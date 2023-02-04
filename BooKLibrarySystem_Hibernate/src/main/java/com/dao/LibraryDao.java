package com.dao;

import java.util.List;

import com.entity.User;

public interface LibraryDao {

	void createUser();

	List<User> loadUser();

	void updateUser(int id);

	void deleteCustomer();

}
