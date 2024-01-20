package com.example.webshop.controller;

import com.example.webshop.model.ShopItem;
import com.example.webshop.model.ShopItemList;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class WebshopController {

    ShopItem shopItem = new ShopItem();
    ShopItemList shopItemList = new ShopItemList();
    List<ShopItem> itemsList = shopItemList.getItemsList();


    @GetMapping("/webshop")
    public String webshop(Model model) {

        model.addAttribute("itemsList", shopItemList.getItemsList());

        return "home";
    }

    @GetMapping("/only-available")
    public String OnlyAvailable(Model model) {

        model.addAttribute("itemsList", shopItemList.outOfStorage());

        return "home";
    }

    @GetMapping("/cheapest-first")
    public String CheapestFirst(Model model) {

        model.addAttribute("itemsList", shopItemList.priceAscending());

        return "home";
    }

    @GetMapping("/contains-nike")
    public String ContainsNike(Model model) {

        model.addAttribute("itemsList", shopItemList.contains("nike"));

        return "home";
    }

    @PostMapping("/contains")
    public String Contains(@RequestParam String search, Model model) {

        model.addAttribute("itemsList", shopItemList.contains(search));

        return "home";
    }


   /*
   @GetMapping("/average-stock")
    public String AverageStock(Model model) {

        model.addAttribute("itemsList", shopItemList.getItemsList());

        return "home";
    }

    @GetMapping("/most-expensive")
    public String MostExpensive(Model model) {

        model.addAttribute("itemsList", shopItemList.getItemsList());

        return "home";
    }
    */

}
