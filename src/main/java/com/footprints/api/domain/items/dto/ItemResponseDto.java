package com.footprints.api.domain.items.dto;

import com.footprints.api.domain.items.entity.Items;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;





public class ItemResponseDto {

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    public static class ItemDetailInfo {
        private Long id;
        private String category;
        private String name;
        private Long price;
        private Long salePrice;
        private String imageUrl;

        public static ItemDetailInfo toDto(Items entity) {
            return ItemDetailInfo.builder()
                .id(entity.getId())
                .category(entity.getCategory().getCategoryName())
                .name(entity.getName())
                .price(entity.getPrice())
                .salePrice(entity.getPrice())
                .imageUrl(entity.getImageUrl())
                .build();
        }
    }


}


