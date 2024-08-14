package com.footprints.api.domain.item.entity;

import com.footprints.api.common.BaseTimeEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

//장바구니
public class Item extends BaseTimeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long rank;

    private String name;

    private String brand;

    private Long price;

    private Long salePrice;

}
