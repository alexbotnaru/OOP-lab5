package utm.md.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

//@Getter
//@Setter
//@AllArgsConstructor

public class User {
    private String firstName;
    private String lastName;

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

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}




