package com.anmolsekhon.interviewproject.services;

import com.anmolsekhon.interviewproject.domain.Asset;
import com.anmolsekhon.interviewproject.repos.AssetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * Service Layer - Contains Business Logic
 */

@Service
@Transactional
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    // try to add Dependency Injection
    private final AssetRepo assetRepo;

    // add exception handling
    @Override
    public Asset saveAsset(Asset asset) {
        return assetRepo.save(asset);
    }

    // add exception handling
    @Override
    public List<Asset> getAllAssets() {
        return assetRepo.findAll();
    }

    // add exception handling
    @Override
    public void deleteAsset(Long assetId) {
        assetRepo.deleteById(assetId);
    }

    @Override
    public void updateAsset(Long assetId,
                            String name,
                            String description,
                            Double priceValue,
                            Long assetTypeId) {
//         Checking if user with given ID exists
        Asset asset = assetRepo.findById(assetId)
                .orElseThrow(() -> new RuntimeException(
                        "asset with id " + assetId + " does not exist"
                ));

//        checking new name is not null and not empty
//        Also, it shouldn't be the same as previous name
        if (name != null && name.length() > 0 && !Objects.equals(asset.getName(), name)) {
            asset.setName(name);
        }

//        checking new description is not null, not empty and not same as previous description
        if (description != null && description.length() > 0 && !Objects.equals(asset.getDescription(), description)) {
            asset.setDescription(description);
        }

//        checking new priceValue is not null, and it is > 0 and not same as previous priceValue
        if (priceValue != null) {
//            nested if condition, otherwise it will throw an exception if priceValue is null
//            as we are comparing its value
            if (priceValue > 0 && priceValue != asset.getPriceValue()) {
                asset.setPriceValue(priceValue);
            }
        }


//        checking if assetTypeId is not null and is either 0 or 1 because there are only 2 types
        if (assetTypeId != null) {
//            nested if condition, otherwise it will throw an exception if assetTypeId is null
//            as we are comparing its value
            if (assetTypeId == 0 || assetTypeId == 1) {
                asset.setAssetTypeId(assetTypeId);
            }
        }

    }

}
