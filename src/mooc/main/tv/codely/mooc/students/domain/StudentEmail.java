package tv.codely.mooc.students.domain;

import java.util.regex.Pattern;

import tv.codely.shared.domain.StringValueObject;

public final class StudentEmail extends StringValueObject {

    private static final Pattern EMAIL = Pattern.compile("^(.+)@(\\S+)$");

    public StudentEmail(String value) {
        super(value);
        checkBody(value);
    }

    private StudentEmail() {
        super(null);
    }

    private void checkBody(String value) {
        if(!EMAIL.matcher(value).matches()) {
            throw new IllegalArgumentException("invalid email " + value);
        }
    }
}
