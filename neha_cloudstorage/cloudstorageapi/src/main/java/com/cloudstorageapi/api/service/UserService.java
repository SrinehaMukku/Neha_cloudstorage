package com.cloudstorageapi.api.service;

 
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.cloudstorageapi.api.entity.UserEntity;
import com.cloudstorageapi.api.model.UserIdRequest;
import com.cloudstorageapi.api.model.UserRequestBody;
import com.cloudstorageapi.api.repositories.UserRepository;

@Service
public class UserService  {

	@Autowired
	private  UserRepository UserRepository;

	

	public UserEntity createUser(UserRequestBody UserRequestBodyObj) {

		UserEntity newUser = new UserEntity();
		newUser.setUserName(UserRequestBodyObj.getUserName());
		newUser.setUserId(UserRequestBodyObj.getParentUserId());
		newUser.setCreatedAt(UserRequestBodyObj.getCreatedAt());
	 
		return UserRepository.save(newUser);		 
	}

	public UserEntity updateUser(UserRequestBody UserRequestBodyObj) {
		UserEntity newUser = new UserEntity();
		newUser.setUserId(UserRequestBodyObj.getUserId() );
		newUser.setUserName(UserRequestBodyObj.getUserName());
		newUser.setUserId(UserRequestBodyObj.getParentUserId());
		newUser.setCreatedAt(UserRequestBodyObj.getCreatedAt());
		return UserRepository.save(newUser);		 
	}

	public Page<UserEntity> listallusersfromdb(int pageNumber, int size) {
		Pageable pageable = PageRequest.of(pageNumber, size);
		return UserRepository.listallusersfromdb(pageable);
	}
 
	public String deleteUser(UserIdRequest fld) {
		int UserId= fld.getUserId();
		UserRepository.deleteById(UserId);
		return "User Deleted";
	}

	public String countNumberOfUsers() {

		return UserRepository.countNumberOfUsers();
	}

}
