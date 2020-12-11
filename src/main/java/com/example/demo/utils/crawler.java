package com.example.demo.utils;

import com.example.demo.domains.MenuDTO;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class crawler extends Proxy {
    @Autowired Printer printer;
    @Autowired Box<MenuDTO> menuBox;
    @Autowired MenuDTO menu;
    public Box<MenuDTO> crawling(String url){
        printer.accept("크롤링 사이트: " + url);
        try{
            Document rawData = Jsoup.connect(url).timeout(10 * 1000).get();
            Elements productName = rawData.select("a[class=_fade_link]");
            Elements price = rawData.select("p[class=pay] h2");
            Elements review = rawData.select("i[class=icon-bubble]");
            Elements wish = rawData.select("i[class=icon-heart]");
            for(int i = 0 ; i < productName.size() ; i++){
                menu = new MenuDTO();
                menu.setProductName(productName.get(i).text());
                menu.setPrice(price.get(i).text());
                printer.accept("크롤링된 게시글 " + i + "번: " + menu.toString());
                menuBox.add(menu);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return menuBox;
    }
}
