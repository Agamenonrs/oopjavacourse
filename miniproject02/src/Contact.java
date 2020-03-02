import java.util.Objects;

public class Contact {

    private String name;
    private String email;
    private String mobileNumber;
    private String workNumber;
    private String homeNumber;
    private String city;
    //Sucessfully added a new contact!

    public Contact(String name, String email, String mobileNumber, String workNumber, String homeNumber, String city) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.workNumber = workNumber;
        this.homeNumber = homeNumber;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getWorkNumber() {
        return workNumber;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", workNumber='" + workNumber + '\'' +
                ", homeNumber='" + homeNumber + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return name.equals(contact.name) &&
                mobileNumber.equals(contact.mobileNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mobileNumber);
    }
}
