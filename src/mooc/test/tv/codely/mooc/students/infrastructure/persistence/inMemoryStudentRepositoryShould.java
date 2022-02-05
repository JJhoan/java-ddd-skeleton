package tv.codely.mooc.students.infrastructure.persistence;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentModuleInfrastructureTestCase;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentMother;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class inMemoryStudentRepositoryShould extends StudentModuleInfrastructureTestCase {
    @Test
    void save_a_student() {
        Student student = StudentMother.random();

        inMemoryStudentRepository.save(student);
    }

    @Test
    void return_an_existing_student() {
        Student student = StudentMother.random();

        inMemoryStudentRepository.save(student);

        assertEquals(Optional.of(student), inMemoryStudentRepository.search(student.id()));
    }

    @Test
    void not_return_a_non_existing_student() {
        assertFalse(inMemoryStudentRepository.search(StudentIdMother.random()).isPresent());
    }
}
