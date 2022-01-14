package com.mysql.crud.controller;

import com.mysql.crud.model.Item;
import com.mysql.crud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    ItemService itemService;

    @GetMapping()
    public List<Item> getALl(){
        return itemService.getAll();
    }

    @GetMapping("/{id}")
    public  Item getItemById(@PathVariable Long id){
        return itemService.getById(id);
    }

    @PostMapping()
    public Item create(@RequestBody Item i){
        return itemService.create(i);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Long id, @RequestBody Item i){
        return itemService.update(id,i);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
         itemService.delete(id);
    }




}
