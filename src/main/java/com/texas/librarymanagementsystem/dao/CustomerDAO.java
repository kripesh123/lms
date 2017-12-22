package com.texas.librarymanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.texas.librarymanagementsystem.entity.Customer;

@Repository
public interface CustomerDAO extends JpaRepository<Customer, Long>{

}
