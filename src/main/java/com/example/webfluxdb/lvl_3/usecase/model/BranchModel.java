package com.example.webfluxdb.lvl_3.usecase.model;

import com.example.webfluxdb.lvl_1.domain.PlaneFlat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
public class BranchModel {
    private final long id;
    private final String city;
    private final int index;
    private final int number;
    private final String address;
    private final List<PlaneFlat> planes;
}