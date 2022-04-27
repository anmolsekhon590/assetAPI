package com.anmolsekhon.interviewproject.repos;

import com.anmolsekhon.interviewproject.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Database Access Layer
 * */
public interface AssetRepo extends JpaRepository<Asset, Long> {
}
