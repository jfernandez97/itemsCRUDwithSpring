package com.mysql.crud.service;

import com.mysql.crud.model.Item;

import java.util.List;
import java.util.Optional;

public interface ItemService {
    List<Item> getAll();
    Item getById(Long id);
    Item create(Item i);
    Item update(Long id, Item i);
   void delete(Long id);
}
