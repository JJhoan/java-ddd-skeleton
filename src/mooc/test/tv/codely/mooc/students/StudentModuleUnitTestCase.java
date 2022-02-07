package tv.codely.mooc.students;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.students.domain.Student;
import tv.codely.mooc.students.domain.StudentRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public abstract class StudentModuleUnitTestCase extends UnitTestCase {
    protected StudentRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(StudentRepository.class);
    }

    protected void shouldHaveSaved(Student student) {
        verify(repository, atLeastOnce()).save(student);
    }
}
