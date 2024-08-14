package com.footprints.api.domain.item.controller;

import com.footprints.api.domain.item.dto.ItemResponseDto.ItemResponse;
import com.footprints.api.domain.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/items")
public class ItemController {
    private final ItemService itemService;


    //베스트셀러 조회
    @GetMapping
    public ResponseEntity<?> getItemList(){
        return ResponseEntity.ok(itemService.getItemList());
    }

    //상세조회
    @GetMapping("/{id}")
    public ResponseEntity<ItemResponse> getItemById(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getItemById(id));
    }

    //이름 조회
    @GetMapping
    public ResponseEntity<?>  getItemByName(){
        return ResponseEntity.ok()
    }

    //랭킹 조회
    @GetMapping("/")
    public ResponseEntity<?> getItemRanking(){
        return ResponseEntity.ok(itemService.getItemRanking());
    }
}
