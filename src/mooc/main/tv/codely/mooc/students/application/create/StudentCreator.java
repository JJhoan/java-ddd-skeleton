package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.StudentEmail;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.mooc.students.domain.Student;
import tv.codely.shared.domain.Service;

@Service
public class StudentCreator {
    private final StudentRepository studentRepository;

    public StudentCreator(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void create(CreateStudentRequest request) {
        Student student = new Student(
            new StudentId(request.id()),
            new StudentName(request.name()),
            new StudentEmail(request.email())
        );

        studentRepository.save(student);
    }
}
