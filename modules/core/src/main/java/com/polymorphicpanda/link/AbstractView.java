package com.polymorphicpanda.link;

import com.polymorphicpanda.link.event.Event;
import com.polymorphicpanda.link.event.EventHandler;
import com.polymorphicpanda.link.event.EventType;
import com.polymorphicpanda.link.event.ViewEvent;

/**
 * Base class for all {@link com.polymorphicpanda.link.View} implementations.
 *
 * @author Ranie Jade Ramiso
 */
public abstract class AbstractView implements View {
    private EventBus eventBus;

    protected AbstractView() {
        eventBus = new EventBus();
    }

    @Override
    public <T extends Event> int registerEventHandler(EventType<T> eventType, EventHandler<T> handler) {
        return eventBus.registerEventHandler(eventType, handler);
    }

    @Override
    public void unregisterEventHandlers(EventType eventType) {
        eventBus.unregisterEventHandlers(eventType);
    }

    @Override
    public void unregisterEventHandler(EventType eventType, int id) {
        eventBus.unregisterEventHandler(eventType, id);
    }

    public <T extends Event> void toggleEvent(EventType<T> eventType, T event) {
        eventBus.toggleEvent(eventType, event);
    }

    @Override
    public void show() {
        if (toggleViewEvent(ViewEvent.SHOW)) {
            getViewOperations().show();
        }
    }

    @Override
    public void close() {
        if (toggleViewEvent(ViewEvent.CLOSE)) {
            getViewOperations().close();
        }
    }

    @Override
    public void hide() {
        if (toggleViewEvent(ViewEvent.HIDE)) {
            getViewOperations().hide();
        }
    }

    private boolean toggleViewEvent(EventType<ViewEvent> eventType) {
        ViewEvent viewEvent = new ViewEvent(eventType);

        toggleEvent(eventType, viewEvent);

        return viewEvent.isConsumed();
    }

    protected abstract ViewOperations getViewOperations();

    public static interface ViewOperations {
        void show();
        void hide();
        void close();
    }
}
