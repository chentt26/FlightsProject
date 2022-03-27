package pojos;

public class Countries {
   public int id;
   public   String name;

    public Countries(String name) {
        this.name = name;
    }

    public Countries(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Countries{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
