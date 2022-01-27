package tv.codely.mooc.students.infrastructure.create.persistence;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentEmail;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.infrastructure.InMemoryStudentRepository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class inMemoryStudentRepositoryShould {
    @Test
    void save_a_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        Student student = new Student(
            new StudentId("43c2efe1-5f0e-4870-8b27-3ae0f6aa3f47"),
            new StudentName("some-name"),
            new StudentEmail("some-duration")
        );

        repository.save(student);
    }

    @Test
    void return_an_existing_student() {
        InMemoryStudentRepository repository = new InMemoryStudentRepository();
        Student student = new Student(
            new StudentId("43c2efe1-5f0e-4870-8b27-3ae0f6aa3f47"),
            new StudentName("some-name"),
            new StudentEmail("some-duration")
        );

        repository.save(student);

        assertEquals(Optional.of(student), repository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
      InMemoryStudentRepository repository = new InMemoryStudentRepository();
        assertFalse(repository.search(new StudentId("43c2efe1-5f0e-4870-8b27-3ae0f6aa3f47")).isPresent());
    }
}
