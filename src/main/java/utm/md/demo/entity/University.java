package utm.md.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString

public class University {
    private Long id;
    private String name;
    private Integer nrStudents;
    private String city;
    private String adress;
    private String country;
}
