package com.polymorphicpanda.link;

import com.polymorphicpanda.link.event.ViewEvent;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class EventBusTest {
    private EventBus eventBus;

    @Before
    public void setup() {
        eventBus = new EventBus();
    }

    /*
     * Register handler.
     */
    @Test
    public void test_registerEventHandler0() {
        CountDownLatch latch = new CountDownLatch(1);

        eventBus.registerEventHandler(ViewEvent.HIDE, event -> latch.countDown());

        eventBus.toggleEvent(ViewEvent.HIDE, new ViewEvent(ViewEvent.HIDE));

        try {
            latch.await();
        } catch (InterruptedException e) {
            fail();
        }
    }

    /*
     * Handler should only be triggered on the proper event type.
     */
    @Test
    public void test_registerEventHandler1() {
        eventBus.registerEventHandler(ViewEvent.HIDE, event -> fail());

        eventBus.toggleEvent(ViewEvent.SHOW, new ViewEvent(ViewEvent.SHOW));
    }

    /*
     * un-register handler.
     */
    @Test
    public void test_unregisterEventHanlder0() {
        CountDownLatch latch = new CountDownLatch(2);
        int id = eventBus.registerEventHandler(ViewEvent.HIDE, event -> {
            latch.countDown();
        });

        eventBus.toggleEvent(ViewEvent.HIDE, new ViewEvent(ViewEvent.HIDE));

        eventBus.unregisterEventHandler(ViewEvent.HIDE, id);

        eventBus.toggleEvent(ViewEvent.HIDE, new ViewEvent(ViewEvent.HIDE));

        try {
            latch.await(1000, TimeUnit.MILLISECONDS);

            assertEquals(1, latch.getCount());
        } catch (InterruptedException e) {
            fail();
        }
    }

    /*
     * un-register handler.
     */
    @Test
    public void test_unregisterEventHanlders0() {
        CountDownLatch latch = new CountDownLatch(2);
        int id = eventBus.registerEventHandler(ViewEvent.HIDE, event -> {
            latch.countDown();
        });

        eventBus.toggleEvent(ViewEvent.HIDE, new ViewEvent(ViewEvent.HIDE));

        eventBus.unregisterEventHandlers(ViewEvent.HIDE);

        eventBus.toggleEvent(ViewEvent.HIDE, new ViewEvent(ViewEvent.HIDE));

        try {
            latch.await(1000, TimeUnit.MILLISECONDS);

            assertEquals(1, latch.getCount());
        } catch (InterruptedException e) {
            fail();
        }
    }
}