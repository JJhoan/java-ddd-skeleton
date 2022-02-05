package tv.codely.mooc.students.infrastructure.persistence;

import java.util.Optional;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import tv.codely.mooc.students.StudentModuleInfrastructureTestCase;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentMother;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
final class MySqlStudentRepositoryShould extends StudentModuleInfrastructureTestCase {

    @Test
    void save_a_course() {
        Student student = StudentMother.random();

        mySqlStudentRepository.save(student);
    }

    @Test
    void return_an_existing_course() {
        Student course = StudentMother.random();

        mySqlStudentRepository.save(course);

        assertEquals(Optional.of(course), mySqlStudentRepository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(mySqlStudentRepository.search(StudentIdMother.random()).isPresent());
    }

}
