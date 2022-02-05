package tv.codely.apps.mooc.backend.controller.students;

import org.junit.jupiter.api.Test;
import tv.codely.apps.mooc.backend.controller.ApplicationTestCase;

public final class StudentsPutControllerShould extends ApplicationTestCase {

    @Test
    void create_a_valid_non_existing_student() throws Exception {
        this.assertRequestWithBody(
            "PUT",
            "/students/1aab45ba-3c7a-4344-8936-78466eca77fa",
            "{\"name\": \"Jorge\", \"email\": \"jorge@gm.com\"}",
            201
        );
    }
}

