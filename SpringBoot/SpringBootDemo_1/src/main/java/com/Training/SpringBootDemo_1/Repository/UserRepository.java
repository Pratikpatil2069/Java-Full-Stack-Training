package com.Training.SpringBootDemo_1.Repository;

import org.springframework.data.repository.CrudRepository;

import com.Training.SpringBootDemo_1.UserModel.UserModel;

public interface UserRepository extends CrudRepository<UserModel,Integer>{

}
