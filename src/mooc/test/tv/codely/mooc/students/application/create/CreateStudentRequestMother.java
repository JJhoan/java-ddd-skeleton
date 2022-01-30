package tv.codely.mooc.students.application.create;

import tv.codely.mooc.students.domain.StudentEmail;
import tv.codely.mooc.students.domain.StudentEmailMother;
import tv.codely.mooc.students.domain.StudentId;
import tv.codely.mooc.students.domain.StudentIdMother;
import tv.codely.mooc.students.domain.StudentName;
import tv.codely.mooc.students.domain.StudentNameMother;

public final class CreateStudentRequestMother {

    public static CreateStudentRequest create(StudentId id, StudentName name, StudentEmail email) {
        return new CreateStudentRequest(id.value(), name.value(), email.value());
    }

    public static CreateStudentRequest random() {
        return create(StudentIdMother.random(), StudentNameMother.random(), StudentEmailMother.random());
    }
}
