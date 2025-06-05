package com.luv2code.studybaseweb.service.interfaces;

import com.luv2code.studybaseweb.entity.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    User findById(String user_id);

    User save(User user);
}
