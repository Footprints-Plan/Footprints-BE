package com.footprints.api.domain.items.service;

import com.footprints.api.domain.items.dto.ItemResponseDto;
import com.footprints.api.domain.items.entity.Items;
import com.footprints.api.domain.items.repository.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    //베스트셀러 조회
    @GetMapping("/all")
    public List<ItemResponseDto> getItemList(){
        List<Items> itemList = itemRepository.findAll();
        return itemList.stream()
            .map(ItemResponseDto::toSimpleDto)
            .toList();
    }

    //상세조회
    @GetMapping("/{id}")
    public ItemResponseDto getItemById(@PathVariable Long id){
        Items items = itemRepository.findById(id).orElseThrow();
        return ItemResponseDto.toSimpleDto(items);
    }

    //이름 조회
    @GetMapping
    public ResponseEntity<?>  getItemByName(){
        return ResponseEntity.ok("");
    }

    @GetMapping("/rank")
    public ResponseEntity<?> getItemRanking() {
        return ResponseEntity.ok("");
    }
}
