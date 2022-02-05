package tv.codely.mooc.courses;

import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.shared.infrastructure.UnitTestCase;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.mock;

public abstract class CoursesModuleUnitTestCase extends UnitTestCase {
    protected CourseRepository repository;

    @BeforeEach
    protected void setUp() {
        super.setUp();
        repository = mock(CourseRepository.class);
    }

    protected void shouldHaveSaved(Course course) {
        Mockito.verify(repository, atLeastOnce()).save(course);
    }
}
