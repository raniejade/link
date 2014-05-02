package com.polymorphicpanda.link;

/**
 * Factory class for creating {@link com.polymorphicpanda.link.Presenter} instances.
 *
 * @author Ranie Jade Ramiso
 */
public interface PresenterFactory<T extends Presenter> extends ObjectFactory<T> {
}
