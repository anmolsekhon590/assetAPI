package com.anmolsekhon.interviewproject.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import java.time.LocalDate;

import static javax.persistence.GenerationType.AUTO;

/**
 * This Asset Class represents an Entity 'Asset' in the Database
 * */
@Data
@Entity
@AllArgsConstructor
@RequiredArgsConstructor
public class Asset {
//    Defining assetId as primary key and its generation is set to auto
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long assetId;
    private String name;
    private String description;
    private Double priceValue;
    private LocalDate purchaseDate;
    private Long assetTypeId;
}
