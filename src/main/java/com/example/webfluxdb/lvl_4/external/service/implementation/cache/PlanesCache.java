package com.example.webfluxdb.lvl_4.external.service.implementation.cache;

import com.example.webfluxdb.lvl_1.domain.PlaneFlat;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import lombok.Data;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Signal;

@Service
@Data
public class PlanesCache {
    private final Cache<Long, Signal<? extends PlaneFlat>> cache;

    public PlanesCache() {
        this.cache = Caffeine.newBuilder()
                .maximumSize(100)
                .build();
    }

    public PlaneFlat evict(PlaneFlat value) {
        cache.invalidate(value.getId());
        return value;
    }
}
