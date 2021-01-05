package utm.md.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import utm.md.demo.entity.Student;
import utm.md.demo.entity.StudentDetails;

import java.util.List;

@Repository
public class StudentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Student> findAll() {
        List<Student> studentList = jdbcTemplate.query(
                "SELECT * FROM students",
                    (response, rowNumber) ->
                    new Student(response.getLong("studentid"),
                            response.getString("name"),
                            response.getString("surname"),
                            response.getInt("age"),
                            response.getLong("phonenumber"),
                            response.getFloat("grade"),
                            response.getString("studentadress"),
                            response.getLong("universityid"),
                            response.getString("country")));

        return studentList;

    }

    public Student findById(long studentid) {
        Student student = jdbcTemplate.queryForObject("SELECT * FROM students WHERE studentid = ?",
                new Object[]{studentid},
                (response, rowNumber) ->
                        new Student(response.getLong("studentid"),
                                response.getString("name"),
                                response.getString("surname"),
                                response.getInt("age"),
                                response.getLong("phonenumber"),
                                response.getFloat("grade"),
                                response.getString("studentadress"),
                                response.getLong("universityid"),
                                response.getString("country")));
        return student;
    }

    public List<Student> findAllByCountry(String country) {
        List<Student> studentList = jdbcTemplate.query(
                "SELECT * FROM students WHERE country = ? ",
                new Object[]{country},
                (response, rowNumber) ->
                        new Student(response.getLong("studentid"),
                                response.getString("name"),
                                response.getString("surname"),
                                response.getInt("age"),
                                response.getLong("phonenumber"),
                                response.getFloat("grade"),
                                response.getString("studentadress"),
                                response.getLong("universityid"),
                                response.getString("country")));

        return studentList;
    }
    public List<Student> findByAgeAndMinGrade(int age,Float grade) {
        List<Student> studentList = jdbcTemplate.query(
                "SELECT * FROM students WHERE age = ? AND grade >= ? ",
                new Object[]{age,grade},
                (response, rowNumber) ->
                        new Student(response.getLong("studentid"),
                                response.getString("name"),
                                response.getString("surname"),
                                response.getInt("age"),
                                response.getLong("phonenumber"),
                                response.getFloat("grade"),
                                response.getString("studentadress"),
                                response.getLong("universityid"),
                                response.getString("country")));

        return studentList;
    }

    public void saveStudent(Long studentId, String name, String surname, int age, Long phoneNumber, float grade,  String adress, Long universityId, String country){
        jdbcTemplate.update("INSERT INTO students(studentId, name, surname, age, phoneNumber, grade, studentAdress, universityId, country)\n" +
                "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)", studentId, name, surname, age, phoneNumber, grade, adress, universityId, country );

    }

    public void saveStudentByReqBody(Student student){
        jdbcTemplate.update("INSERT INTO students(studentId, name, surname, age, phoneNumber, grade, studentAdress, universityId, country)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)",student.getId(), student.getName(), student.getSurname(), student.getAge(),
                                                            student.getPhoneNumber(), student.getGrade(), student.getAdress(),student.getUniversityId(),student.getCountry());
    }

    public void update(Long studentId, Student student){
        jdbcTemplate.update("UPDATE students SET name = ?, surname = ?, age = ?, phonenumber = ?, grade = ?, studentadress = ?, universityid = ?, country = ? WHERE studentId = ? ",
                student.getName(),student.getSurname(),student.getAge(),student.getPhoneNumber(),student.getGrade(),student.getAdress(),student.getUniversityId(),student.getCountry(),studentId);
    }

    public void delete(Long studentId){
        jdbcTemplate.update("DELETE FROM students WHERE studentId = ?",studentId);
    }


    public StudentDetails findByIdDetailed(long studentid) {
        StudentDetails studentDetails = jdbcTemplate.queryForObject("SELECT students.studentid,name,surname,studentAdress,grade,country,universities.universityname,universities.adress,nrstudents FROM students\n" +
                        "    inner join universities\n" +
                        "        on students.universityId = universities.universityid WHERE studentid = ?",
                new Object[]{studentid},
                (response, rowNumber) ->
                        new StudentDetails(response.getLong("studentid"),
                                response.getString("name"),
                                response.getString("surname"),
                                response.getString("studentadress"),
                                response.getFloat("grade"),
                                response.getString("country"),
                                response.getString("universityname"),
                                response.getString("adress"),
                                response.getInt("nrStudents")));
        return studentDetails;
    }
}

