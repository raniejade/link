package com.polymorphicpanda.link.event;

/**
 * Handler called when an {@link com.polymorphicpanda.link.event.Event} occurs.
 *
 * @author Ranie Jade Ramiso
 */
@FunctionalInterface
public interface EventHandler<T extends Event> {
    void handle(T event);
}
