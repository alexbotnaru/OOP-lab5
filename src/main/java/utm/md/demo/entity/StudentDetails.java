package utm.md.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor

public class StudentDetails {
    private Long id;
    private String name;
    private String surname;
    private String adress;
    private float grade;
    private String country;
    private String universityName;
    private String universityAdress;
    private Integer nrStudents;

}
