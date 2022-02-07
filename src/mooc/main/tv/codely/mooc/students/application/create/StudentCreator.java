package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.StudentEmail;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.mooc.students.domain.Student;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public class StudentCreator {
    private final StudentRepository studentRepository;
    private final EventBus eventBus;

    public StudentCreator(StudentRepository studentRepository, EventBus eventBus) {
        this.studentRepository = studentRepository;
        this.eventBus = eventBus;
    }

    public void create(CreateStudentRequest request) {
        StudentId id = new StudentId(request.id());
        StudentName name = new StudentName(request.name());
        StudentEmail email = new StudentEmail(request.email());

        Student student = Student.create(id, name, email);

        studentRepository.save(student);
        eventBus.publish(student.pullDomainEvents());
    }
}
