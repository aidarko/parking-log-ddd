package com.aidarko.domain.gate;

public interface GateRepository {
    /**
     * Send an event to open the Gate.
     * @param id
     */
    void open(Gate.Id id);
}
