package utm.md.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import utm.md.demo.entity.Student;
import utm.md.demo.entity.Teacher;

import java.util.List;

@Repository
public class TeacherRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Teacher> findAll() {
        List<Teacher> teacherList = jdbcTemplate.query(
                "SELECT * FROM teachers",
                (response, rowNumber) ->
                        new Teacher(response.getLong("teacherid"),
                                response.getString("name"),
                                response.getString("surname"),
                                response.getInt("age"),
                                response.getString("object"),
                                response.getString("email"),
                                response.getLong("universityid")));

        return teacherList;

    }

    public void saveTeacherByReqBody(Teacher teacher){
        jdbcTemplate.update("INSERT INTO teachers(teacherId, name, surname, age, object, email, universityId)\n" +
                        "VALUES(?, ?, ?, ?, ?, ?, ?)",teacher.getId(), teacher.getName(), teacher.getSurname(), teacher.getAge(),
                teacher.getObject(), teacher.getEmail(),teacher.getUniversityid());
    }

    public void update(Long teacherId, Teacher teacher){
        jdbcTemplate.update("UPDATE teachers SET name = ?, surname = ?, age = ?, object = ?, email = ?, universityid = ?  WHERE teacherId = ? ",
                teacher.getName(), teacher.getSurname(),teacher.getAge(), teacher.getObject(),teacher.getEmail(), teacher.getUniversityid(),teacherId);

    }
    public void delete(Long teacherId){
        jdbcTemplate.update("DELETE FROM teachers WHERE teacherId = ?",teacherId);
    }
}


