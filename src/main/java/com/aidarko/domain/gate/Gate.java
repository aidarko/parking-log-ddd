package com.aidarko.domain.gate;

import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
public class Gate {
    @Value
    public static class Id {
        String value;
    }
}
