package jsp;

//Where do we catch the NumberFormatException?
public class UserData {
    String firstName;
    String lastName;
    int tel;

    public void setFirstName(String value) {
        firstName = value;
    }

    public void setLastName(String value) {
        lastName = value;
    }

    public void setTel(int value) {
            tel = value;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTel() {
        return tel;
    }
}