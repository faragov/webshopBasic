package com.example.webshop.model;

import java.util.*;
import java.util.stream.Collectors;

public class ShopItemList {

    private int shopPiece;

    private List<ShopItem> itemsList = new ArrayList<>(Arrays.asList(
            new ShopItem("Running shoes", "Nike running shoes for every day sport",
                    1000.0, 5),
            new ShopItem("Printer", "Some HP printer that will print pages",
                    3000.0, 2),
            new ShopItem("Coca Cola", "0,5l standard coke",
                    25.0, 0),
            new ShopItem("Wokin", "Chicken with fried rice and WOKIN sauce ",
                    119.0, 100),
            new ShopItem("T-shirt", "Blue with a corgi on a bike",
                    300.0, 1)));

    public ShopItemList() {
    }

    public List<ShopItem> getItemsList() {
        return itemsList;
    }

    public void setItemsList(List<ShopItem> itemsList) {
        this.itemsList = itemsList;
    }

    public void addNew(ShopItem shopItem) {
        itemsList.add(shopItem);
    }

    public void removeItem(ShopItem shopItem) {
        if (shopItem.getQuantityOfStock() == 0) {
            itemsList.remove(shopItem);
            throw new RuntimeException("This product is not available");
        }
    }

    public int shopItem(ShopItem shopItem, int shopPiece) {
        this.shopPiece = shopPiece;
        shopItem.setQuantityOfStock(shopItem.getQuantityOfStock() - shopPiece);
        return shopItem.getQuantityOfStock();
    }

    public List<ShopItem> outOfStorage(){
        return itemsList.stream()
                .filter(item -> item.getQuantityOfStock() != 0)
                .collect(Collectors.toList());
    }

    public List<ShopItem> priceAscending(){
        return itemsList.stream()
                .sorted(Comparator.comparingDouble(ShopItem::getPrice))
                .collect(Collectors.toList());
    }

    public List<ShopItem> contains(String search){
        return itemsList.stream()
                .filter(item -> item.getName().toLowerCase().contains(search.toLowerCase())
                        || item.getDescription().toLowerCase().contains(search.toLowerCase()) )
                .collect(Collectors.toList());
    }

}
