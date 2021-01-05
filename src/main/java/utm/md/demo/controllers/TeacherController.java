package utm.md.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utm.md.demo.entity.Student;
import utm.md.demo.entity.Teacher;
import utm.md.demo.repository.TeacherRepository;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherRepository teacherRepository;

    @GetMapping
    public List<Teacher> findAll(){
        List<Teacher> teacherList = teacherRepository.findAll();
        return teacherList;
    }

    @PostMapping("/save/")
    public void saveTeacherByReqBody(@RequestBody Teacher teacher){
        teacherRepository.saveTeacherByReqBody(teacher);
    }

    @PutMapping("/update/{teacherId}")
    public void update(@PathVariable Long teacherId, @RequestBody Teacher teacher){
        teacherRepository.update(teacherId, teacher);

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        teacherRepository.delete(id);
    }

    @PatchMapping("/patch/{id}")
    public void patch(@PathVariable Long id){}

}
