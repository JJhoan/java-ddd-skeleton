package tv.codely.apps.mooc.backend.controller.courses_counter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.courses_counter.application.find.CoursesCounterFinder;
import tv.codely.mooc.courses_counter.application.find.CoursesCounterResponse;

@RestController
public final class CoursesCounterGetController {
    private final CoursesCounterFinder finder;

    public CoursesCounterGetController(CoursesCounterFinder finder) {
        this.finder = finder;
    }

    @GetMapping("/courses-counter")
    public Map<String, Integer> index() {
        CoursesCounterResponse response = finder.find();

        return new HashMap<String, Integer>() {{
            put("total", response.total());
        }};
    }
}
