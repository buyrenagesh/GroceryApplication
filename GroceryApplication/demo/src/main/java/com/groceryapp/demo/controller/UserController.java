package com.groceryapp.demo.controller;

import com.groceryapp.demo.service.GroceryStoreService;
import com.groceryapp.demo.model.GroceryItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private GroceryStoreService groceryStoreService;

    @GetMapping("/items")
    public ResponseEntity<List<GroceryItem>> viewItems() {
        List<GroceryItem> items = groceryStoreService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @PostMapping("/items")
    public ResponseEntity<GroceryItem> addToStore(@RequestParam Long id) {
        GroceryItem item = groceryStoreService.addItemToStore(id);
        if (item == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        GroceryItem createdItem = item;
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> removeFromStore(@PathVariable Long id) {
        groceryStoreService.deleteItemFromStore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/checkout")
    public ResponseEntity<Void> checkout() {
        groceryStoreService.checkout();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}