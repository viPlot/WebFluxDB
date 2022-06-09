package com.example.webfluxdb.lvl_4.external.service.implementation;

import com.example.webfluxdb.lvl_1.domain.Branch;
import com.example.webfluxdb.lvl_1.domain.BranchFlat;
import com.example.webfluxdb.lvl_2.service.spi.BranchService;
import com.example.webfluxdb.lvl_2.service.spi.PlaneService;
import com.example.webfluxdb.lvl_4.external.service.implementation.repository.BranchRepository;
import com.example.webfluxdb.lvl_4.external.service.implementation.repository.raw.BranchRaw;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BranchServiceImpl implements BranchService {
    private final BranchRepository branchRepository;
    private final PlaneService planeService;

    @Override
    @Transactional(readOnly = true)
    public Flux<BranchFlat> findFlatAll() {
        return branchRepository.findAll()
                .map(BranchRaw::toBrunchFlat);
    }

    @Override
    @Transactional(readOnly = true)
    public Flux<Branch> findAll() {
        return findFlatAll()
                .flatMap(this::toDomain);
    }

    private Mono<Branch> toDomain(BranchFlat branchFlat) {
        return Flux.fromIterable(branchFlat.getPlanes())
                .flatMap(planeService::findFlatById)
                .collectList()
                .map(planes -> new Branch(
                        branchFlat.getId(),
                        branchFlat.getCity(),
                        branchFlat.getIndex(),
                        branchFlat.getNumber(),
                        branchFlat.getAddress(),
                        planes
                ));
    }
}
