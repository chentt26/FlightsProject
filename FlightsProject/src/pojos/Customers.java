package pojos;

public class Customers {
  public   int id,userId;
  public   String firstName,lastName,address,phoneNo,creditCardNo;

    public Customers(int userId, String firstName, String lastName, String address, String phoneNo, String creditCardNo) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.creditCardNo = creditCardNo;
    }

    public Customers(int id, int userId, String firstName, String lastName, String address, String phoneNo, String creditCardNo) {
        this.id = id;
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phoneNo = phoneNo;
        this.creditCardNo = creditCardNo;
    }

    @Override
    public String toString() {
        return "Customers{" +
                "id=" + id +
                ", userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address='" + address + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", creditCardNo='" + creditCardNo + '\'' +
                '}';
    }
}
