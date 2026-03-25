package com.mywaysai.smartprocurementvendormanagementsystem.controller;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorRatingRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;
import com.mywaysai.smartprocurementvendormanagementsystem.service.VendorRatingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendor-ratings")
public class VendorRatingController {

    private final VendorRatingService service;

    public VendorRatingController(VendorRatingService service) {
        this.service = service;
    }

    @PostMapping
    public VendorRating create(@RequestBody VendorRatingRequest request) {
        return service.createRating(request);
    }

    @GetMapping
    public List<VendorRating> getAll() {
        return service.getAllRatings();
    }

    @GetMapping("/{id}")
    public VendorRating getById(@PathVariable Long id) {
        return service.getRatingById(id);
    }
}
