package com.example.demo.impls;

import com.example.demo.domains.MenuDTO;
import com.example.demo.repositories.MenuRepository;
import com.example.demo.services.MenuService;
import com.example.demo.utils.Box;
import com.example.demo.utils.Printer;
import com.example.demo.utils.crawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired MenuRepository menuRepository;
    @Autowired Printer printer;
    @Autowired MenuDTO menu;
    
    @Override
    public int register(MenuDTO menu) {
        return menuRepository.insert(menu);
    }
    @Override
    public int crawling(String url) {
        // var menuBox = new Box<MenuDTO>();
        // menuBox = crawler.crawling(url);
        // printer.accept("제품수: " + menuBox.size());
        // for(int i = 0 ; i < menuBox.size() ; i++){
        //     menu = new MenuDTO();
        //     menu = menuBox.get(i);
        // }
        return 0;
    }

}
