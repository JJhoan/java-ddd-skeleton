package tv.codely.shared.domain.bus.event;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import tv.codely.shared.domain.Utils;

public abstract class DomainEvent<T extends DomainEvent<?>> {
    private final String aggregateId;
    private final String eventId;
    private final String occurredOn;

    public DomainEvent(String aggregateId) {
        this.aggregateId = aggregateId;
        this.eventId = UUID.randomUUID().toString();
        this.occurredOn = Utils.dateToString(LocalDateTime.now());
    }

    public DomainEvent(String aggregateId, String eventId, String occurredOn) {
        this.aggregateId = aggregateId;
        this.eventId     = eventId;
        this.occurredOn  = occurredOn;
    }

    public String aggregateId() {
        return aggregateId;
    }

    public String eventId() {
        return eventId;
    }

    public String occurredOn() {
        return occurredOn;
    }

    protected abstract String eventName();

    protected abstract Map<String, Serializable> toPrimitive();

    protected abstract T fromPrimitives(
        String aggregateId,
        Map<String, Serializable> body,
        String eventId,
        String occurredOn
    );
}
