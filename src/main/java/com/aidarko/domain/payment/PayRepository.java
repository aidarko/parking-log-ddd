package com.aidarko.domain.payment;

import java.math.BigDecimal;

interface PayRepository {
    void pay(BigDecimal amount);
}
