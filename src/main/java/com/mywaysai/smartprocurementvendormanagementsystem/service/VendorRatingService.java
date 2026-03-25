package com.mywaysai.smartprocurementvendormanagementsystem.service;

import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorRatingRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;

import java.util.List;

public interface VendorRatingService {
    VendorRating createRating(VendorRatingRequest request);

    List<VendorRating> getAllRatings();

    VendorRating getRatingById(Long id);

    VendorRating rate(VendorRating rating);
}

