package com.polymorphicpanda.link.event;

/**
 * Represents an event.
 *
 * @author Ranie Jade Ramiso
 */
public class Event {
    private EventType<? extends Event> eventType;

    protected Event(EventType<? extends Event> eventType) {
        this.eventType = eventType;
    }

    public EventType getEventType() {
        return eventType;
    }
}
