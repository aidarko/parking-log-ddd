package com.aidarko.infastructure;

import com.aidarko.domain.gate.Gate;
import com.aidarko.domain.gate.GateRepository;

public class GateAdapter implements GateRepository {
    @Override
    public void open(Gate.Id id) {
        // send request to open the gate
    }
}
