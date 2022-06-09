package com.example.webfluxdb.lvl_2.service.spi;

import com.example.webfluxdb.lvl_1.domain.PlaneFlat;
import reactor.core.publisher.Mono;

public interface PlaneService {
    Mono<PlaneFlat> findFlatById(long id);
    Mono<PlaneFlat> save(PlaneFlat plane);
    void delete(PlaneFlat plane);

}
