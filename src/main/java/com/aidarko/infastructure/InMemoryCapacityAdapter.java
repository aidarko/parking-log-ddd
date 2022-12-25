package com.aidarko.infastructure;

import com.aidarko.domain.CapacityRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@Getter
public class InMemoryCapacityAdapter implements CapacityRepository {

    private int capacity;

    @Override
    public void increase() {
        capacity++;
    }

    @Override
    public void decrease() {
        capacity--;
    }
}
