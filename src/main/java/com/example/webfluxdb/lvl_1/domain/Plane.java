package com.example.webfluxdb.lvl_1.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class Plane {
    private final long id;
    private final int speed;
    private final int inceptDate;
    private final int range;
    private final int numberOfSeats;
    private final String model;
    private final long branchId;
    private final List<BranchFlat> branches;
}
