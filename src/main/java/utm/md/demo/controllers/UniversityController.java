package utm.md.demo.controllers;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import utm.md.demo.entity.University;
import utm.md.demo.repository.UniversityRepository;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {

    @Autowired
    private UniversityRepository universityRepository;

   @GetMapping
   public List<University> findAll(){
       List<University> universityList = universityRepository.findAll();
       return universityList;
   }

    @GetMapping("/{id}")
    public University findById(@PathVariable Long id){
        University university = universityRepository.findById(id);
        return university;
    }

    @GetMapping("/country/{country}")
    public List<University> findAllByCountry(@PathVariable String country){
       List<University> universityList = universityRepository.findAllByCountry(country);
       return universityList;
    }

    @GetMapping("/nrstudents/{nrstudents}")
    public List<University> findByMinStudents(@PathVariable Integer nrStudents){
       List<University> universityList = universityRepository.findByMinStudents(nrStudents);
       return universityList;
    }

    @PostMapping("/save")
    public void saveUniversity(@RequestBody University university){
       universityRepository.saveUniversity(university);
    }

    @PutMapping("/update/{universityId}")
    public void update(@PathVariable Long universityId, @RequestBody University university){
       universityRepository.update(universityId, university);
    }

    @DeleteMapping("/{id}")
    public void delete (@PathVariable Long id){
       universityRepository.delete(id);
    }

    @PatchMapping("/updateNrStudents/{id}")
    public void updateNrStudents (@PathVariable Long id ,@RequestParam Integer nrStudents){
        universityRepository.updateNrStudents(id, nrStudents);
    }
}
