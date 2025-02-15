package com.groceryapp.demo.service;

import com.groceryapp.demo.model.GroceryItem;
import com.groceryapp.demo.repository.GroceryItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroceryItemService {

    private final GroceryItemRepository groceryItemRepository;

    @Autowired
    public GroceryItemService(GroceryItemRepository groceryItemRepository) {
        this.groceryItemRepository = groceryItemRepository;
    }

    public List<GroceryItem> getAllItems() {
        return groceryItemRepository.findAll();
    }

    public Optional<GroceryItem> getItemById(Long id) {
        return groceryItemRepository.findById(id);
    }

    public GroceryItem createItem(GroceryItem item) {
        return groceryItemRepository.save(item);
    }

    public GroceryItem updateItem(Long id, GroceryItem item) {
        item.setId(id);
        return groceryItemRepository.save(item);
    }

    public void deleteItem(Long id) {
        groceryItemRepository.deleteById(id);
    }
}