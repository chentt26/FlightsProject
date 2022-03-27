package pojos;

public class Tickets {
    public int id,customerId,flightId;

    public Tickets(int customerId, int flightId) {
        this.customerId = customerId;
        this.flightId = flightId;
    }

    public Tickets(int id, int customerId, int flightId) {
        this.id = id;
        this.customerId = customerId;
        this.flightId = flightId;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", flightId=" + flightId +
                '}';
    }
}
