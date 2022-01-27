package tv.codely.shared.domain;

import com.github.javafaker.Faker;

public final class IntegerMother {
    public static Integer random() {
        return Faker.instance().number().randomDigit();
    }
}
