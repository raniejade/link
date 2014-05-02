package com.polymorphicpanda.link;

import com.polymorphicpanda.link.event.Event;
import com.polymorphicpanda.link.event.EventHandler;
import com.polymorphicpanda.link.event.EventType;

/**
 * The V (View) part of MVP.
 *
 * A {@link com.polymorphicpanda.link.View} represents a user interface, where the
 * user can interact too.
 *
 * @author Ranie Jade Ramiso
 */
public interface View {
    /**
     * Show the view.
     */
    void show();

    /**
     * Close the view.
     */
    void close();

    /**
     * Hide the view.
     */
    void hide();

    /**
     * Register an event handler for a particular {@link com.polymorphicpanda.link.event.EventType}.
     *
     * Multiple {@link com.polymorphicpanda.link.event.EventHandler} can be registered, but the order on
     * how they are invoked is not guaranteed.
     *
     * @param eventType Type of {@link com.polymorphicpanda.link.event.Event}.
     * @param handler The {@link com.polymorphicpanda.link.event.EventHandler} to register.
     *
     * @return An integer unique only to the particular {@link com.polymorphicpanda.link.event.EventType}
     *         that can be used to un-register it later on.
     */
    <T extends Event> int registerEventHandler(EventType<T> eventType, EventHandler<T> handler);

    /**
     *
     * @param eventType Type of {@link com.polymorphicpanda.link.event.Event}.
     * @param id The id of an {@link com.polymorphicpanda.link.event.EventHandler} provided
     *           by {@link #registerEventHandler}.
     */
    void unregisterEventHandler(EventType eventType, int id);

    /**
     * Un-register all {@link com.polymorphicpanda.link.event.EventHandler} on
     * the given {@link com.polymorphicpanda.link.event.EventType}.
     *
     * @param eventType Type of {@link com.polymorphicpanda.link.event.Event}.
     */
    void unregisterEventHandlers(EventType eventType);
}
