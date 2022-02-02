package tv.codely.mooc.courses.infrastructure.persistence;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import tv.codely.mooc.courses.CoursesModuleInfrastructureTestCase;
import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseIdMother;
import tv.codely.mooc.courses.domain.CourseMother;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

final class InMemoryCourseRepositoryShould extends CoursesModuleInfrastructureTestCase {
    @Test
    void save_a_course() {
        Course course = CourseMother.random();

        inMemoryCurseRepository.save(course);
    }

    @Test
    void return_an_existing_course() {
        Course course = CourseMother.random();

        inMemoryCurseRepository.save(course);

        assertEquals(Optional.of(course), inMemoryCurseRepository.search(course.id()));
    }

    @Test
    void not_return_a_non_existing_course() {
        assertFalse(inMemoryCurseRepository.search(CourseIdMother.random()).isPresent());
    }
}
