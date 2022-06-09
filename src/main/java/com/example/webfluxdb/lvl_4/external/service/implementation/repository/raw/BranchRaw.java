package com.example.webfluxdb.lvl_4.external.service.implementation.repository.raw;

import com.example.webfluxdb.lvl_1.domain.BranchFlat;
import com.example.webfluxdb.lvl_1.domain.PlaneFlat;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Table("branch")
public class BranchRaw {
    @Id
    private long id;
    private String city;
    private int index;
    private int number;
    private String address;
    private List<Long> planes;

    public BranchFlat toBrunchFlat() {
        return new BranchFlat(id, city, index, number, address, planes);
    }
}
