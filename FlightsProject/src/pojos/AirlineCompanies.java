package pojos;

public class AirlineCompanies {
   public int id,countryId,userId;
    public String name;

    public AirlineCompanies(int countryId, int userId, String name) {
        this.countryId = countryId;
        this.userId = userId;
        this.name = name;
    }

    public AirlineCompanies(int id, int countryId, int userId, String name) {
        this.id = id;
        this.countryId = countryId;
        this.userId = userId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "AirlineCompanies{" +
                "id=" + id +
                ", countryId=" + countryId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                '}';
    }
}
