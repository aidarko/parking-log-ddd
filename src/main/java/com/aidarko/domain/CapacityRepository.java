package com.aidarko.domain;

public interface CapacityRepository {
    void increase();

    void decrease();

    int getCapacity();
}
