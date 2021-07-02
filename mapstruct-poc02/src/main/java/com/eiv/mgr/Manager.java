package com.eiv.mgr;

@FunctionalInterface
public interface Manager<T> {

    public T execute();

}
