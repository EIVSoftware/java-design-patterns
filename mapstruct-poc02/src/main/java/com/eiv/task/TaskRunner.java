package com.eiv.task;

import java.util.function.Function;

public class TaskRunner<R, T extends Task<R>> {

    private T task;

    public TaskRunner<R, T> given(T task) {
        this.task = task;
        return this;
    }

    public R run() {
        return task.run();
    }

    public <O> O run(Function<R, O> convert) {
        R result = run();
        O other = convert.apply(result);
        return other;
    }
}
