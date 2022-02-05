package tv.codely.shared.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public abstract class Identifier implements Serializable {
    private final String value;

    public Identifier(String value) {
        this.value = UUID.fromString(value).toString();
    }

    public String value() {
        return value.toString();
    }

    public String getValue() {
        return value;
    }

    protected Identifier(){
        this.value = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Identifier that = (Identifier) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
