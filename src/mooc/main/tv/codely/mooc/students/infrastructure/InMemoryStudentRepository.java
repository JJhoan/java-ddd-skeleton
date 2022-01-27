package tv.codely.mooc.students.infrastructure;

import java.util.HashMap;
import java.util.Optional;

import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.domain.Service;

@Service
public class InMemoryStudentRepository implements StudentRepository {
    private final HashMap<StudentId, Student> students = new HashMap<>();

    @Override
    public void save(Student student) {
        students.put(student.id(), student);
    }

    @Override
    public Optional<Student> search(StudentId id) {
        return Optional.ofNullable(students.get(id));
    }
}
