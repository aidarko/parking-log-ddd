package com.aidarko.domain.payment;

import java.math.BigDecimal;

interface RatesRepository {
    BigDecimal getRatePerHour();
}
