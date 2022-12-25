package com.aidarko.app.event;

import lombok.Value;

@Value
public class ValidTicketScannedEvent {
    String gateId;
}
