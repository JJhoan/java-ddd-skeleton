package tv.codely.mooc.students;

import org.junit.jupiter.api.BeforeEach;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class StudentModuleUnitTestCase {
    protected StudentRepository repository;

    @BeforeEach
    protected void setUp() {
        repository = mock(StudentRepository.class);
    }

    protected void shouldHaveSaved(Student student) {
        verify(repository, atLeastOnce()).save(student);
    }
}
