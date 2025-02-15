package com.groceryapp.demo.service;

import com.groceryapp.demo.model.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroceryStoreService {

    private final GroceryItemService groceryItemService;
    private final List<GroceryItem> storeItems;

    @Autowired
    public GroceryStoreService(GroceryItemService groceryItemService) {
        this.groceryItemService = groceryItemService;
        this.storeItems = new ArrayList<>();
    }

    public List<GroceryItem> getAllItems() {
        return new ArrayList<>(storeItems);
    }

    public GroceryItem addItemToStore(Long id) {
        GroceryItem item = groceryItemService.getItemById(id).orElse(null);
        if (item != null) {
            storeItems.add(item);
            return item;
        }
        return null;
    }

    public void deleteItemFromStore(Long id) {
        storeItems.removeIf(item -> item.getId().equals(id));
    }

    public void checkout() {
        storeItems.clear();
    }
}