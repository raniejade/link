package com.polymorphicpanda.link.event;

/**
 * Type of {@link com.polymorphicpanda.link.event.Event}.
 *
 * @author Ranie Jade Ramiso
 */
public final class EventType<T extends Event> {
    private String name;

    public EventType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
