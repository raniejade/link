package com.polymorphicpanda.link.event;

/**
 * An {@link com.polymorphicpanda.link.event.Event} that can be consumed. Consumed events
 * will prevent it from doing its default action. This class is used internally for
 * {@link com.polymorphicpanda.link.event.ViewEvent}s.
 *
 * @author Ranie Jade Ramiso
 */
abstract class ConsumableEvent extends Event {
    private boolean consumed;

    protected ConsumableEvent(EventType<? extends Event> eventType) {
        super(eventType);
        consumed = false;
    }

    /**
     * Consume this event. How it is interpreted depends
     * on the type of {@link com.polymorphicpanda.link.event.Event}.
     */
    public void consume() {
        consumed = true;
    }

    public boolean isConsumed() {
        return consumed;
    }
}
