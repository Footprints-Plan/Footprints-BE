package com.footprints.api.domain.items.controller;

import com.footprints.api.domain.items.service.ItemService;
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

    //다 조회
    @GetMapping("/best")
    public ResponseEntity<?> getItemList(){
        return ResponseEntity.ok(itemService.getItemList());
    }

    //상세조회
    @GetMapping("/{id}")
    public ResponseEntity<?> getItemById(@PathVariable Long id){
        return ResponseEntity.ok(itemService.getItemById(id));
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
