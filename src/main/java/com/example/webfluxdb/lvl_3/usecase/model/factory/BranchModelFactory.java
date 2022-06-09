package com.example.webfluxdb.lvl_3.usecase.model.factory;

import com.example.webfluxdb.lvl_1.domain.Branch;
import com.example.webfluxdb.lvl_3.usecase.model.BranchModel;
import org.springframework.stereotype.Component;

@Component
public class BranchModelFactory {
    public BranchModel get(Branch branch) {
        return new BranchModel(
                branch.getId(),
                branch.getCity(),
                branch.getIndex(),
                branch.getNumber(),
                branch.getAddress(),
                branch.getPlanes()
        );
    }
}
