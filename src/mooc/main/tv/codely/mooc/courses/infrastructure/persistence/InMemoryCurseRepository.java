package tv.codely.mooc.courses.infrastructure.persistence;

import java.util.HashMap;
import java.util.Optional;

import tv.codely.mooc.courses.domain.Course;
import tv.codely.mooc.courses.domain.CourseId;
import tv.codely.mooc.courses.domain.CourseRepository;

public final class InMemoryCurseRepository implements CourseRepository {
    private final HashMap<CourseId, Course> courses = new HashMap<>();

    @Override
    public void save(Course course) {
        courses.put(course.id(), course);
    }

    @Override
    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id));
    }
}
