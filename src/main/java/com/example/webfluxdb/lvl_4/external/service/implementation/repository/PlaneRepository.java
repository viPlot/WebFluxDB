package com.example.webfluxdb.lvl_4.external.service.implementation.repository;

import com.example.webfluxdb.lvl_4.external.service.implementation.repository.raw.PlaneRaw;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PlaneRepository extends R2dbcRepository<PlaneRaw, Long> {
}