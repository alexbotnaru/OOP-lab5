package utm.md.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import utm.md.demo.entity.Student;
import utm.md.demo.entity.University;

import java.util.List;

@Repository
public class UniversityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<University> findAll(){
        List<University> universityList = jdbcTemplate.query(
                "SELECT * FROM universities",
                (response, rowNumber) ->
                        new University(response.getLong("universityid"),
                                response.getString("universityname"),
                                response.getInt("nrstudents"),
                                response.getString("city"),
                                response.getString("adress"),
                                response.getString("country")));
        return universityList;
    }

    public University findById(long id){
        University university = jdbcTemplate.queryForObject("SELECT * FROM universities WHERE universityid = ?",
                new Object[]{id},
                (response, rowNumber) ->
                new University(response.getLong("universityid"),
                        response.getString("universityname"),
                        response.getInt("nrstudents"),
                        response.getString("city"),
                        response.getString("adress"),
                        response.getString("country")));
        return university;
    }

    public List<University> findAllByCountry(String country) {
        List<University> universityList = jdbcTemplate.query(
                "SELECT * FROM universities WHERE country = ? ",
                new Object[]{country},
                (response, rowNumber) ->
                        new University(response.getLong("universityid"),
                                response.getString("universityname"),
                                response.getInt("nrstudents"),
                                response.getString("city"),
                                response.getString("adress"),
                                response.getString("country")));
        return universityList;
    }

    public List<University> findByMinStudents(Integer nrStudents) {
        List<University> universityList = jdbcTemplate.query(
                "SELECT * FROM universities WHERE nrstudents >= ? ",
                new Object[]{nrStudents},
                (response, rowNumber) ->
                        new University(response.getLong("universityid"),
                                response.getString("universityname"),
                                response.getInt("nrstudents"),
                                response.getString("city"),
                                response.getString("adress"),
                                response.getString("country")));
        return universityList;
    }

    public void saveUniversity(University university){
        jdbcTemplate.update("INSERT INTO universities(universityId, universityName, nrStudents, city, adress,country)\n" +
                "VALUES (?, ?, ?, ?, ?, ?);",university.getId(),university.getName(), university.getNrStudents(),university.getCity(),university.getAdress(),university.getCountry());
    }

    public void update(Long universityId, University university){
        jdbcTemplate.update("UPDATE universities SET universityName = ?, nrStudents = ?, city = ?, adress = ?, universitycountry = ? WHERE universityId = ? ",
                university.getName(), university.getNrStudents(), university.getCity(), university.getAdress(),university.getCountry(),universityId);
    }

    public void delete(Long universityId){
        jdbcTemplate.update("DELETE FROM universities WHERE universityId = ?",universityId);
    }
}
