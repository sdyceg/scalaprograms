package annotationTest;

public class User {
    private String name;
    @init("wang")
    private String firstName;
    @init("ergou")
    private String lastName;
    private String address;


    public String getName() {
        return name;
    }

    @init("TD")
    public void setName(String name) {
        this.name = name;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
