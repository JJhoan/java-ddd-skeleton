package tv.codely.mooc.courses;

import org.springframework.beans.factory.annotation.Autowired;
import tv.codely.mooc.MoocContextInfrastructureTestCase;
import tv.codely.mooc.courses.domain.CourseRepository;
import tv.codely.mooc.courses.infrastructure.persistence.InMemoryCurseRepository;

public abstract class CoursesModuleInfrastructureTestCase extends MoocContextInfrastructureTestCase {

    protected InMemoryCurseRepository inMemoryCurseRepository = new InMemoryCurseRepository();

    @Autowired
    protected CourseRepository mySqlCourseRepository;

}
