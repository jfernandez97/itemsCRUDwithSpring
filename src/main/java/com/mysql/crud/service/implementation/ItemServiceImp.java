package com.mysql.crud.service.implementation;

import com.mysql.crud.model.Item;
import com.mysql.crud.repository.ItemRepository;
import com.mysql.crud.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImp implements ItemService {

    @Autowired
    ItemRepository itemRepository;

    @Override
    public List<Item> getAll() {
        return (List<Item>) itemRepository.findAll();
    }

    @Override
    public Item getById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Item create(Item i) {
        return itemRepository.save(i);
    }

    @Override
    public Item update(Long id, Item i) {
        Optional<Item> optional = itemRepository.findById(id);

        Item toUpdate = null;
        if (optional.isPresent()) {
            toUpdate = optional.get();
            toUpdate.setName(i.getName());
            toUpdate.setCategory(i.getCategory());
            toUpdate.setStock(i.getStock());
            itemRepository.save(toUpdate);
        }
        return toUpdate;
    }

    @Override
    public void delete(Long id) {
        itemRepository.deleteById(id);
    }
}
