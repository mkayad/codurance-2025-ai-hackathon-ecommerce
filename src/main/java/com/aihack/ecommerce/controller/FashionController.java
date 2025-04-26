package com.aihack.ecommerce.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aihack.ecommerce.model.FashionItem;
import com.aihack.ecommerce.service.FashionItemService;

import java.io.IOException;
import java.util.List;

@Controller
public class FashionController {
    
    private final FashionItemService fashionItemService;
    
    public FashionController(FashionItemService fashionItemService) {
        this.fashionItemService = fashionItemService;
    }
    
    @GetMapping("/fashion")
    public String showFashionItems(Model model) {
        try {
            List<FashionItem> fashionItems = fashionItemService.getFashionItems();
            model.addAttribute("fashionItems", fashionItems);
            return "fashion";
        } catch (IOException e) {
            throw new RuntimeException("Failed to load fashion items", e);
        }
    }
}
