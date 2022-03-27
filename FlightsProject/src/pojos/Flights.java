package pojos;

import java.time.LocalDateTime;

public class Flights {
    public int id,airLineCompanyId,originCountryId,destinationCountryId,remainingTickets;
    public LocalDateTime departureTime,landingTime;

    public Flights(int airLineCompanyId, int originCountryId, int destinationCountryId, int remainingTickets, LocalDateTime departureTime, LocalDateTime landingTime) {
        this.airLineCompanyId = airLineCompanyId;
        this.originCountryId = originCountryId;
        this.destinationCountryId = destinationCountryId;
        this.remainingTickets = remainingTickets;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
    }

    public Flights(int id, int airLineCompanyId, int originCountryId, int destinationCountryId, int remainingTickets, LocalDateTime departureTime, LocalDateTime landingTime) {
        this.id = id;
        this.airLineCompanyId = airLineCompanyId;
        this.originCountryId = originCountryId;
        this.destinationCountryId = destinationCountryId;
        this.remainingTickets = remainingTickets;
        this.departureTime = departureTime;
        this.landingTime = landingTime;
    }

    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", airLineCompanyId=" + airLineCompanyId +
                ", originCountryId=" + originCountryId +
                ", destinationCountryId=" + destinationCountryId +
                ", remainingTickets=" + remainingTickets +
                ", departureTime=" + departureTime +
                ", landingTime=" + landingTime +
                '}';
    }
}
