package com.footprints.api.domain.items.repository;

import com.footprints.api.config.redis.BaseRedisRepository;
import jakarta.annotation.PostConstruct;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisItemRepository extends BaseRedisRepository implements Serializable  {
    private final RedisTemplate<String, String> redisTemplate;

    public static final String RANKING = "Item_rankings"; // 채팅룸에 입장한 클라이언트의 sessionId와 채팅룸 id를 맵핑한 정보 저장
    private ZSetOperations<String, String> zSetOperations;

    @PostConstruct
    protected void init() {
        classInstance = RedisItemRepository.class;
        zSetOperations = redisTemplate.opsForZSet();
    }

    public List<TypedTuple<String>> getRankings(long start, long end) {
        return zSetOperations.rangeWithScores(RANKING, start, end).stream()
            .sorted((a, b) -> Double.compare(b.getScore(), a.getScore())) // 역순으로 정렬
            .collect(Collectors.toList());
    }

}
