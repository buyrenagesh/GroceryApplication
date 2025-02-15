package com.groceryapp.demo.controller;
import com.groceryapp.demo.model.GroceryItem;
import com.groceryapp.demo.service.GroceryItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/grocery-items")
public class GroceryItemController {

    @Autowired
    private GroceryItemService groceryItemService;

    @GetMapping
    public ResponseEntity<List<GroceryItem>> getAllItems() {
        List<GroceryItem> items = groceryItemService.getAllItems();
        return new ResponseEntity<>(items, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroceryItem> getItemById(@PathVariable Long id) {
        GroceryItem item = groceryItemService.getItemById(id).get();
        return item != null ? new ResponseEntity<>(item, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<GroceryItem> createItem(@RequestBody GroceryItem item) {
        GroceryItem createdItem = groceryItemService.createItem(item);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroceryItem> updateItem(@PathVariable Long id, @RequestBody GroceryItem item) {
        GroceryItem updatedItem = groceryItemService.updateItem(id, item);
        return updatedItem != null ? new ResponseEntity<>(updatedItem, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        groceryItemService.deleteItem(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}