package com.eiv.task;

@FunctionalInterface
public interface Task<T> {

    T run();
}
