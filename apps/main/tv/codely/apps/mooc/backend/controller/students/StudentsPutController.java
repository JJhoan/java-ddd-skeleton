package tv.codely.apps.mooc.backend.controller.students;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.students.application.create.CreateStudentRequest;
import tv.codely.mooc.students.application.create.StudentCreator;

@RestController
public final class StudentsPutController {
    private final StudentCreator creator;

    public StudentsPutController(StudentCreator studentCreator) {
        this.creator = studentCreator;
    }

    @PutMapping(value = "/students/{id}")
    public ResponseEntity<?> index(@PathVariable String id, @RequestBody Request request) {
        CreateStudentRequest createStudentRequest = new CreateStudentRequest(id, request.name(), request.email());
        creator.create(createStudentRequest);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

final class Request {
    private String name;
    private String email;

    public String name() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String email() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
