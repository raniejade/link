package com.polymorphicpanda.link;

/**
 * The P (Presenter) part of MVP.
n *
 * The presenter binds the business logic to the view, it supervises the communication between them.
 *
 * @author Ranie Jade Ramiso
 */
public abstract class Presenter<T extends View> {
    private T view;

    /**
     * The {@link com.polymorphicpanda.link.View} this presenter supervises.
     */
    public T getView() {
        return view;
    }

    void setView(T view) {
        this.view = view;
    }
}
