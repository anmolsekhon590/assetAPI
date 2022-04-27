package com.anmolsekhon.interviewproject.services;

import com.anmolsekhon.interviewproject.domain.Asset;

import java.util.List;

/**
 * Service Interface
 **/

public interface AssetService {

    Asset saveAsset(Asset asset);
    List<Asset> getAllAssets();
    void deleteAsset(Long assetId);
}
