package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ItemRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Inventory;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.InventoryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final ItemRepository itemRepository;
    private final InventoryRepository repository;
    public Inventory updateStock(Inventory inv){

        Item item = itemRepository.findById(inv.getItem().getId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        inv.setItem(item);

        return repository.save(inv);
    }
//    public Inventory updateStock(Inventory inv){
//        return repository.save(inv);
//    }

    public List<Inventory> all(){
        return repository.findAll();
    }
}

