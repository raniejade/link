package com.polymorphicpanda.link;

/**
 * @author Ranie Jade Ramiso
 */
interface ObjectFactory<T> {
    T create(Class<? extends T> objectClass);
}
