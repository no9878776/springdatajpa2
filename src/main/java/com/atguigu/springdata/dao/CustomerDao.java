package com.atguigu.springdata.dao;

import com.atguigu.springdata.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author Yurisman
 * @create 2021-02-2021/2/3-上午 11:49
 */
public interface CustomerDao extends JpaRepository<Customer,Integer>, JpaSpecificationExecutor<Customer> {
}
