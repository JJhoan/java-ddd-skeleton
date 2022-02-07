package tv.codely.mooc.students.domain;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import tv.codely.shared.domain.bus.event.DomainEvent;

public final class StudentCreatedDomainEvent extends DomainEvent<StudentCreatedDomainEvent> {
    private final String name;
    private final String email;

    public StudentCreatedDomainEvent(String aggregateId, String name, String email) {
        super(aggregateId);
        this.name = name;
        this.email = email;
    }

    public StudentCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String name, String email) {
        super(aggregateId, eventId, occurredOn);
        this.name = name;
        this.email = email;
    }

    @Override
    public String eventName() {
        return "student.created";
    }

    @Override
    public Map<String, Serializable> toPrimitives() {
        return new HashMap<String, Serializable>() {{
            put("name", name);
            put("email", email);
        }};
    }

    @Override
    public StudentCreatedDomainEvent fromPrimitives(String aggregateId, Map<String, Serializable> body, String eventId, String occurredOn) {
        return new StudentCreatedDomainEvent(
            aggregateId,
            eventId,
            occurredOn,
            (String) body.get("name"),
            (String) body.get("email")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentCreatedDomainEvent that = (StudentCreatedDomainEvent) o;
        return name.equals(that.name) && email.equals(that.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email);
    }
}
