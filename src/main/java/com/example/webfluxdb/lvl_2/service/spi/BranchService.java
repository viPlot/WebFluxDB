package com.example.webfluxdb.lvl_2.service.spi;

import com.example.webfluxdb.lvl_1.domain.Branch;
import com.example.webfluxdb.lvl_1.domain.BranchFlat;
import reactor.core.publisher.Flux;

public interface BranchService {
    Flux<BranchFlat> findFlatAll();
    Flux<Branch> findAll();
}
