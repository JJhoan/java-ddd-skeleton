package tv.codely.mooc.students.application.create;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentEmail;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.domain.StudentRepository;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;

final class StudentCreatorShould {

    @Test
    void create_a_valid_student() {
        StudentRepository repository = mock(StudentRepository.class);
        StudentCreator creator = new StudentCreator(repository);
        System.out.println(UUID.randomUUID());
        CreateStudentRequest request = new CreateStudentRequest("43c2efe1-5f0e-4870-8b27-3ae0f6aa3f47", "name", "email");


        Student student = new Student(
            new StudentId(request.id()),
            new StudentName(request.name()),
            new StudentEmail(request.email())
        );

        creator.create(request);

        verify(repository, atLeastOnce()).save(student);
    }
}
