package com.luv2code.studybaseweb.dao.daoInterface;

import com.luv2code.studybaseweb.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDAO extends JpaRepository<User, String> {

}
