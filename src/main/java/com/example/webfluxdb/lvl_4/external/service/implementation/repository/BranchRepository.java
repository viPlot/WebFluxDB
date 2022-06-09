package com.example.webfluxdb.lvl_4.external.service.implementation.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import com.example.webfluxdb.lvl_4.external.service.implementation.repository.raw.BranchRaw;

public interface BranchRepository extends R2dbcRepository<BranchRaw, Long> {
}