package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ItemRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository repository;

    public Item add(Item item){

    // item.setUnitPrice(((item.getUnitPrice())));
        return repository.save(item);
    }

    public List<Item> list(){
        return repository.findAll();
    }
}
