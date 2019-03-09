package com.example.gbcu.util;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler computation();

    Scheduler io();

    Scheduler ui();
}
