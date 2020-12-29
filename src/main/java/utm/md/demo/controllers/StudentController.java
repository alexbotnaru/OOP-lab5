package utm.md.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utm.md.demo.entity.Student;
import utm.md.demo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    List<String> names = new ArrayList<>();

    @GetMapping
    public List<Student> findAll(){
        List<Student> studentList = studentRepository.findAll();
        return studentList;
    }

    @GetMapping("/{studentid}")
    public Student findById(@PathVariable Long studentid){
        Student student = studentRepository.findById(studentid);
        return student;
    }

    @GetMapping("/country/{country}")
    public List<Student> findAllByCountry(@PathVariable String country){
        List<Student> studentList = studentRepository.findAllByCountry(country);
        return studentList;
    }

    @GetMapping("/ageandgrade/{age}/{grade}")
    public List<Student> findByAgeAndMinGrade(@PathVariable int age,@PathVariable Float grade){
        List<Student> studentList = studentRepository.findByAgeAndMinGrade(age,grade);
        return studentList;
    }
    @PostMapping("/test/{name}")
    public List<String> test(@PathVariable String name){
        names.add(name);
        return names;

    }

    @PostMapping("/{studentId}/{name}/{surname}/{age}/{phoneNumber}/{grade}/{adress}/{universityId}/{country}")
    public void saveStudent(@PathVariable Long studentId,@PathVariable String name, @PathVariable String surname, @PathVariable int age,
                     @PathVariable Long phoneNumber, @PathVariable float grade, @PathVariable String adress,
                     @PathVariable Long universityId, @PathVariable String country ){
        studentRepository.saveStudent(studentId, name, surname, age, phoneNumber, grade, adress, universityId, country);
    }


    @PostMapping("/reqparam")
    public void saveStudentByReqParam(@RequestParam Long studentId,@RequestParam("nume") String name,@RequestParam String surname,
                                      @RequestParam int age, @RequestParam long phoneNumber, @RequestParam float grade,
                                      @RequestParam String adress, @RequestParam(required = false) Long universityId, @RequestParam String country){
        studentRepository.saveStudent(studentId, name, surname, age, phoneNumber, grade, adress, universityId, country);
    }

    @PostMapping("/reqbody/")
    public void saveStudentByReqBody(@RequestBody Student student){
        studentRepository.saveStudentByReqBody(student);
    }

    @PutMapping("/update/{studentId}")
    public void update(@PathVariable Long studentId, @RequestBody Student student){
        studentRepository.update(studentId, student);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        studentRepository.delete(id);
    }

}
