package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;

public interface ItemService {
    Item add(Item item);
    List<Item> list();

}
