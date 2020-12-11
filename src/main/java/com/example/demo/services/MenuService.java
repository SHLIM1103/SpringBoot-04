package com.example.demo.services;

import com.example.demo.domains.MenuDTO;

import org.springframework.stereotype.Component;

@Component
public interface MenuService {
	public int register(MenuDTO menu);
	public int crawling(String url);

}