package com.footprints.api.domain.items.service;

import com.footprints.api.domain.category.entity.Category;
import com.footprints.api.domain.category.repository.CategoryRepository;
import com.footprints.api.domain.items.dto.ItemResponseDto.ItemDetailInfo;
import com.footprints.api.domain.items.dto.ItemResponseDto.ItemRankingDto;
import com.footprints.api.domain.items.entity.Items;
import com.footprints.api.domain.items.repository.ItemRepository;
import com.footprints.api.domain.items.repository.RedisItemRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;
    private final RedisItemRepository redisItemRepository;

    /**
     * 전체 조회
     */
    public List<ItemDetailInfo> getItemList(){
        List<Items> itemList = itemRepository.findAll();
        return itemList.stream()
            .map(ItemDetailInfo::toDto)
            .toList();
    }

    /**
     * id로 상세 조회
     */
    public ItemDetailInfo getItemById(@PathVariable Long id){
        Items items = itemRepository.findById(id).orElseThrow();
        return ItemDetailInfo.toDto(items);
    }


    /**
     * 이름으로 Item 리스트 조회
     */
    public List<ItemDetailInfo>  getItemByName(String name){
        List<Items> itemList = itemRepository.findByNameContaining(name);
        return itemList.stream()
            .map(ItemDetailInfo::toDto)
            .toList();
    }

    /**
     * 카레고리로 조회
     */
    public List<ItemDetailInfo>  getItemByCategory(Long id){
        Category category = categoryRepository.findById(id).orElseThrow();
        List<Items> itemList = itemRepository.findAllByCategoryId(category.getId());

        return itemList.stream()
            .map(ItemDetailInfo::toDto)
            .toList();
    }

    /**
     * 랭킹 조회 -> 레디스 설정 이후
     */
    public List<ItemRankingDto> getItemRanking() {
        List<TypedTuple<String>> redisRankings = redisItemRepository.getRankings(0,11);

        return redisRankings.stream()
            .map(tuple -> {
                String itemId = tuple.getValue();
                Double score = tuple.getScore();
                System.out.println("itemId = " + itemId + ","+"score = " + score);

                assert itemId != null;
                Optional<Items> item = itemRepository.findById(Long.parseLong(itemId));
                if(item.isEmpty()){
                    item = itemRepository.findById(1L);
                }
                return ItemRankingDto.toDto(item.get(), score.longValue());
            })
            .collect(Collectors.toList());
    }
}
