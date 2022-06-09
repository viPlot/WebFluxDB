package com.example.webfluxdb.lvl_4.external.controller;

import com.example.webfluxdb.lvl_3.usecase.branch.GetBranchUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetBranchesController {
    private final GetBranchUseCase useCase;

    public Mono<ServerResponse> handle(ServerRequest request) {
        return useCase.get()
                .flatMap(list -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(list));
    }
}