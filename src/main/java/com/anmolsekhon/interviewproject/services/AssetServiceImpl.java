package com.anmolsekhon.interviewproject.services;

import com.anmolsekhon.interviewproject.domain.Asset;
import com.anmolsekhon.interviewproject.repos.AssetRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service Layer - Contains Business Logic
 * */

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService{

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
}
