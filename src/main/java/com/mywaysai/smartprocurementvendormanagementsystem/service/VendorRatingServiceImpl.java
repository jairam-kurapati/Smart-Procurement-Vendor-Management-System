package com.mywaysai.smartprocurementvendormanagementsystem.service;

//import org.springframework.stereotype.Service;
//
//import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;
//import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRatingRepository;
//
//import lombok.RequiredArgsConstructor;
//
//@Service
//@RequiredArgsConstructor
//public class VendorRatingServiceImpl implements VendorRatingService {
//
//    private final VendorRatingRepository repository;
//
//    public VendorRating rate(VendorRating rating){
//        return repository.save(rating);
//    }
//
import com.mywaysai.smartprocurementvendormanagementsystem.dto.VendorRatingRequest;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.Vendor;
import com.mywaysai.smartprocurementvendormanagementsystem.entity.VendorRating;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRatingRepository;
import com.mywaysai.smartprocurementvendormanagementsystem.repository.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class VendorRatingServiceImpl implements VendorRatingService {

        private final VendorRatingRepository ratingRepository;
        private final VendorRepository vendorRepository;

        public VendorRatingServiceImpl(VendorRatingRepository ratingRepository,
                                       VendorRepository vendorRepository) {
            this.ratingRepository = ratingRepository;
            this.vendorRepository = vendorRepository;
        }

        @Override
        public VendorRating createRating(VendorRatingRequest request) {

            Vendor vendor = vendorRepository.findById(request.getVendorId())
                    .orElseThrow(() -> new RuntimeException("Vendor not found"));

            VendorRating rating = new VendorRating();
            rating.setVendor(vendor);
            rating.setQualityScore(request.getQualityScore());
            rating.setDeliveryScore(request.getDeliveryScore());
            rating.setPriceScore(request.getPriceScore());

            return ratingRepository.save(rating);
        }

        @Override
        public List<VendorRating> getAllRatings() {
            return ratingRepository.findAll();
        }

        @Override
        public VendorRating getRatingById(Long id) {
            return ratingRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Rating not found"));
        }

        @Override
        public VendorRating rate(VendorRating rating) {
            return null;
        }
    }


