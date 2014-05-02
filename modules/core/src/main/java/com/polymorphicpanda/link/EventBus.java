package com.polymorphicpanda.link;

import com.polymorphicpanda.link.event.Event;
import com.polymorphicpanda.link.event.EventHandler;
import com.polymorphicpanda.link.event.EventType;

import java.util.HashMap;
import java.util.Map;

/**
 * Handles event publishing and subscription. Not part of the
 * public API.
 *
 * @author Ranie Jade Ramiso
 */
class EventBus {
    private Map<EventType, Map<Integer, EventHandler>> eventHandlersMap;
    private Map<EventType, EventHandlerIdGenerator> eventHandlerIdGeneratorMap;

    public EventBus() {
        eventHandlersMap = new HashMap<>();
        eventHandlerIdGeneratorMap = new HashMap<>();
    }

    public <T extends Event> int registerEventHandler(EventType<T> eventType, EventHandler<T> handler) {
        EventHandlerIdGenerator generator = getIdGenerator(eventType);

        int id = generator.getNextAvailableId();

        Map<Integer, EventHandler> handlerMap = getEventHandlerMap(eventType);

        handlerMap.put(id, handler);

        return id;
    }

    public void unregisterEventHandlers(EventType eventType) {
        clearMapsForEventType(eventType);
    }

    public void unregisterEventHandler(EventType eventType, int id) {
        Map<Integer, EventHandler> handlerMap = getEventHandlerMap(eventType);

        handlerMap.remove(id);

        if (handlerMap.size() == 0) {
            clearMapsForEventType(eventType);
        }
    }

    @SuppressWarnings("unchecked")
    public <T extends Event> void toggleEvent(EventType<T> eventType, T event) {
        Map<Integer, EventHandler> handlerMap = getEventHandlerMap(eventType);

        handlerMap.values().stream()
                .forEach(handler -> {
                    handler.handle(event);
                });
    }

    private EventHandlerIdGenerator  getIdGenerator(EventType eventType) {
        EventHandlerIdGenerator generator = eventHandlerIdGeneratorMap.get(eventType);

        if (generator == null) {
            generator = new EventHandlerIdGenerator();
            eventHandlerIdGeneratorMap.put(eventType, generator);
        }

        return generator;
    }

    private Map<Integer, EventHandler> getEventHandlerMap(EventType eventType) {
        Map<Integer, EventHandler> handlerMap = eventHandlersMap.get(eventType);

        if (handlerMap == null) {
            handlerMap = new HashMap<>();
            eventHandlersMap.put(eventType, handlerMap);
        }

        return handlerMap;
    }

    private void clearMapsForEventType(EventType eventType) {
        eventHandlersMap.remove(eventType);
        eventHandlerIdGeneratorMap.remove(eventType);
    }

    class EventHandlerIdGenerator {
        private int counter;

        public EventHandlerIdGenerator() {
            counter = 0;
        }

        public int getNextAvailableId() {
            return counter++;
        }
    }
}
