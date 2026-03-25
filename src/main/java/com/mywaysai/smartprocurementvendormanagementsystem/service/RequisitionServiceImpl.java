package com.mywaysai.smartprocurementvendormanagementsystem.service;

import java.util.List;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Item;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.ItemRepository;
import org.springframework.stereotype.Service;

import com.mywaysai.smartprocurementvendormanagementsystem.entity.Requisition;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.RequisitionRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RequisitionServiceImpl implements RequisitionService {

    private final RequisitionRepository repository;
    private final ItemRepository itemRepository;
    public Requisition create(Requisition r){


        Item item = itemRepository.findById(r.getItem().getId())
                .orElseThrow(() -> new RuntimeException("Item not found"));

        r.setItem(item);



        r.setStatus("PENDING");
        return repository.save(r);
    }





    public List<Requisition> list(){
        return repository.findAll();
    }

    @Override
    public List<Requisition> findAll() {

        return   repository.findAll();

    }
}
