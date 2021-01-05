package utm.md.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class Teacher {
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String object;
    private String email;
    private Long universityid;
}
