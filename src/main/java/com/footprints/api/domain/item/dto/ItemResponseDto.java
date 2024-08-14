package com.footprints.api.domain.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

public class ItemResponseDto {
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ItemResponse {

        private Long id;

        private String name;

        private Float price;
        private Float salePrice;
        private String imageUrl;

    }

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ItemRankResponse{
        private Long rank;
        private Long id;
        private String name;
        private Float price;
        private Float salePrice;
        private String imageUrl;
    }
}
