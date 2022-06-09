package com.example.webfluxdb.lvl_1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder(toBuilder = true)
public class Branch {
    private final long id;
    private final String city;
    private final int index;
    private final int number;
    private final String address;
    private final List<PlaneFlat> planes;
}
