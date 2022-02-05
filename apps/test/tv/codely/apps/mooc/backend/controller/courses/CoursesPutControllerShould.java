package tv.codely.apps.mooc.backend.controller.courses;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.backend.controller.ApplicationTestCase;

public final class CoursesPutControllerShould extends ApplicationTestCase {
    @Test
    void create_a_valid_non_existing_course() throws Exception {
        this.assertRequestWithBody(
            "PUT",
            "/courses/a3256f62-6053-44db-9bc8-ca3c16955518",
            "{\"name\": \"The best course\", \"duration\": \"5 hours\"}",
            201
        );
    }
}
