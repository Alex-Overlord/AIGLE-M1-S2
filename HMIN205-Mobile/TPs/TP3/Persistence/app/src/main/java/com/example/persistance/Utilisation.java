package com.example.persistance;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class Utilisation implements LifecycleObserver {

    private static int counter = 0;

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void NombreUtilisation() {
        counter++;
    }

    public int getCounter() {
        return counter;
    }
}
