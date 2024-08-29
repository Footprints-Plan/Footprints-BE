package com.footprints.api.domain.items.controller;

import com.footprints.api.domain.items.dto.ItemResponseDto.ItemDetailInfo;
import com.footprints.api.domain.items.dto.ItemResponseDto.ItemRankingDto;
import com.footprints.api.domain.items.service.ItemService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;

    //다 조회
    @GetMapping("/all")
    public ResponseEntity<List<ItemDetailInfo>> getItemList(){
        return ResponseEntity.ok(itemService.getItemList());
    }

    //상세조회
    @GetMapping("/{id}")
    public ResponseEntity<ItemDetailInfo> getItemById(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    @GetMapping("/rank")
    public ResponseEntity<List<ItemRankingDto>> getItemRanking() {
        return ResponseEntity.ok(itemService.getItemRanking());
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<List<ItemDetailInfo>> getItemByCategory(@PathVariable Long id) {
        return ResponseEntity.ok(itemService.getItemByCategory(id));
    }
}
