package com.atguigu.springdata.dao;

import com.atguigu.springdata.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Yurisman
 * @create 2021-02-2021/2/3-下午 01:17
 */
public interface UserDao extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {
}
