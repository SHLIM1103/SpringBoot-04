package com.example.demo.repositories;

import com.example.demo.domains.MenuDTO;

import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository {
	public int insert(MenuDTO menu);
    
}
