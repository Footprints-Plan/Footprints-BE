package com.footprints.api.domain.item.service;

import com.footprints.api.domain.item.dto.ItemResponseDto.ItemRankResponse;
import com.footprints.api.domain.item.dto.ItemResponseDto.ItemResponse;
import com.footprints.api.domain.item.entity.Item;
import com.footprints.api.domain.item.repository.ItemRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Service
public class ItemService {
    private final ItemRepository itemRepository;

    public List<ItemResponse> getItemList() {

    }

    public ItemResponse getItemById(Long id) {

        return itemRepository.findById(id);
    }

    public List<ItemResponse> getItemByName(String name) {
        return itemRepository.findByName();
    }

    public List<ItemRankResponse> getItemRanking() {

        return itemRepository.findByRank();
    }
}