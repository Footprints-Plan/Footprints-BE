package com.footprints.api.domain.items.dto;

import com.footprints.api.domain.items.entity.Items;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemResponseDto {
    private Long id;
    private String name;
    private Long price;
    private Long salePrice;
    private String imageUrl;


    public static ItemResponseDto toSimpleDto(Items entity){
        return ItemResponseDto.builder()
            .id(entity.getId())
            .name(entity.getName())
            .price(entity.getPrice())
            .salePrice(entity.getPrice())
            .imageUrl(entity.getImageUrl())
            .build();
    }

}
