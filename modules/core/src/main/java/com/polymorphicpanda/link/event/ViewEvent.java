package com.polymorphicpanda.link.event;

/**
 * Type of {@link com.polymorphicpanda.link.event.Event} that a {@link com.polymorphicpanda.link.View}
 * publishes during certain scenarios.
 *
 * @author Ranie Jade Ramiso
 */
public class ViewEvent extends ConsumableEvent {
    /**
     * Published when a request to close the view is made.
     */
    public static EventType<ViewEvent> CLOSE = new EventType<>("view.close");

    /**
     * Published when a request to hide the view is made.
     */
    public static EventType<ViewEvent> HIDE = new EventType<>("view.hide");

    /**
     * Published when a request to show the view is made.
     */
    public static EventType<ViewEvent> SHOW = new EventType<>("view.show");

    public ViewEvent(EventType<? extends Event> eventType) {
        super(eventType);
    }
}
