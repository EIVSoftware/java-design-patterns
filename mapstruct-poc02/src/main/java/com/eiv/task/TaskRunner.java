package com.eiv.task;

public class TaskRunner<R, T extends Task<R>> {

    private T task;

    public TaskRunner<R, T> given(T task) {
        this.task = task;
        return this;
    }

    public R run() {
        return task.run();
    }

}
