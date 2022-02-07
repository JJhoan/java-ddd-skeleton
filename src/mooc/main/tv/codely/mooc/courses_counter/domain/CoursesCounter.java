package tv.codely.mooc.courses_counter.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import tv.codely.mooc.courses.domain.CourseId;

public final class CoursesCounter {
    private final CoursesCounterId id;
    private CoursesCounterTotal total;
    private List<CourseId> existingCourses;

    public CoursesCounter(CoursesCounterId id, CoursesCounterTotal total, List<CourseId> existingCourses) {
        this.id = id;
        this.total = total;
        this.existingCourses = existingCourses;
    }

    private CoursesCounter() {
        this.id = null;
        this.total = null;
        this.existingCourses = null;
    }

    public CoursesCounterId id() {
        return id;
    }

    public CoursesCounterTotal total() {
        return total;
    }

    public List<CourseId> existingCourses() {
        return existingCourses;
    }

    public static CoursesCounter initialize(String id) {
        return new CoursesCounter(new CoursesCounterId(id), CoursesCounterTotal.initialize(), new ArrayList<>());
    }

    public boolean hasIncremented(CourseId id) {
        return existingCourses.contains(id);
    }

    public void increment(CourseId id) {
        total = total.increment();
        existingCourses.add(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CoursesCounter that = (CoursesCounter) o;
        return id.equals(that.id) &&
               total.equals(that.total) &&
               existingCourses.equals(that.existingCourses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, existingCourses);
    }
}