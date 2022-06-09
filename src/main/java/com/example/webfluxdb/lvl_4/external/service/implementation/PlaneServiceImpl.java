package com.example.webfluxdb.lvl_4.external.service.implementation;

import com.example.webfluxdb.lvl_1.domain.PlaneFlat;
import com.example.webfluxdb.lvl_2.service.spi.PlaneService;
import com.example.webfluxdb.lvl_4.external.service.implementation.cache.PlanesCache;
import com.example.webfluxdb.lvl_4.external.service.implementation.repository.PlaneRepository;
import com.example.webfluxdb.lvl_4.external.service.implementation.repository.raw.PlaneRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.cache.CacheMono;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class PlaneServiceImpl implements PlaneService {
    private final PlaneRepository planeRepository;
    private final TransactionOperations transactionOperations;
    private final PlanesCache cache;

    @Override
    public Mono<PlaneFlat> findFlatById(long id) {
        return CacheMono.lookup(cache.getCache().asMap(), id)
                .onCacheMissResume(transactionOperations.findFlatById(id));
    }

    @Override
    public Mono<PlaneFlat> save(PlaneFlat plane) {
        return findFlatById(plane.getId())
                .map(cache::evict)
                .flatMap(p -> Mono.just(PlaneRaw.from(p))
                        .flatMap(planeRepository::save)
                        .map(PlaneRaw::toPlaneFlat)
                        .map(cache::evict));
    }

    @Override
    public void delete(PlaneFlat plane) {
         findFlatById(plane.getId())
                .map(cache::evict)
                .flatMap(p -> Mono.just(PlaneRaw.from(p))
                        .flatMap(planeRepository::delete));
    }

    @Service
    @RequiredArgsConstructor
    public static class TransactionOperations {
        private final PlaneRepository planeRepository;

        @Transactional(readOnly = true)
        public Mono<PlaneFlat> findFlatById(long id) {
            return planeRepository.findById(id)
                    .map(PlaneRaw::toPlaneFlat)
                    .doOnNext(plane -> System.out.println("> FROM DB: " + plane));
        }
    }
}
