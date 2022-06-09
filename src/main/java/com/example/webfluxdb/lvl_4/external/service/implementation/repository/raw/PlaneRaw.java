package com.example.webfluxdb.lvl_4.external.service.implementation.repository.raw;

import com.example.webfluxdb.lvl_1.domain.PlaneFlat;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("Plane")
@NoArgsConstructor
@AllArgsConstructor
public class PlaneRaw {
    @Id
    private long id;
    private int speed;
    private int inceptDate;
    private int range;
    private int numberOfSeats;
    private String model;
    private long branchId;
    private List<Long> branches;

    public PlaneFlat toPlaneFlat() {
        return new PlaneFlat(id, speed, inceptDate, range, numberOfSeats, model, branchId, branches);
    }

    public static PlaneRaw from(PlaneFlat flat) {
        return new PlaneRaw(
                flat.getId(),
                flat.getSpeed(),
                flat.getInceptDate(),
                flat.getRange(),
                flat.getNumberOfSeats(),
                flat.getModel(),
                flat.getBranchId(),
                flat.getBranches()
        );
    }
}