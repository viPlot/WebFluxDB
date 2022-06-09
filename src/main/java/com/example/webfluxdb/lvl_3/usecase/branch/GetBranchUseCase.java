package com.example.webfluxdb.lvl_3.usecase.branch;

import com.example.webfluxdb.lvl_2.service.spi.BranchService;
import com.example.webfluxdb.lvl_3.usecase.model.BranchModel;
import com.example.webfluxdb.lvl_3.usecase.model.factory.BranchModelFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBranchUseCase {
    private final BranchService branchService;
    private final BranchModelFactory responseFactory;

    public Mono<List<BranchModel>> get() {
        return branchService.findAll()
                .map(responseFactory::get)
                .collectList();
    }
}
