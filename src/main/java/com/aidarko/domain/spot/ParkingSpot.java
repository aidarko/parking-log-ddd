package com.aidarko.domain.spot;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@EqualsAndHashCode(exclude = "occupied")
@ToString
public class ParkingSpot {
    private final Id id;
    private final String type;
    private final String name;
    @Setter
    private boolean occupied = false;

    public void occupy() {
        if (isOccupied()) {
            throw new IllegalStateException("Parking spot should not be occupied");
        }
        setOccupied(true);
    }

    public void unOccupy() {
        if (!isOccupied()) {
            throw new IllegalStateException("Parking spot should be occupied");
        }
        setOccupied(false);
    }

    @AllArgsConstructor
    @Getter
    @EqualsAndHashCode
    public static class Id {
        private final String value;
    }
}
