package tv.codely.shared.infrastructure.bus.event.spring;

import java.util.List;

import org.springframework.context.ApplicationEventPublisher;
import tv.codely.shared.domain.Service;
import tv.codely.shared.domain.bus.event.DomainEvent;
import tv.codely.shared.domain.bus.event.EventBus;

@Service
public final class SpringApplicationEventBus implements EventBus {
    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @Override
    public void publish(final List<DomainEvent<?>> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent<?> event) {
        this.publisher.publishEvent(event);}
}
