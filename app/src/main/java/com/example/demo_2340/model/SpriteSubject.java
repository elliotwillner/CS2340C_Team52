package com.example.demo_2340.model;

public interface SpriteSubject {
    void subscribe(SpriteObserver observer);
    void unsubscribe(SpriteObserver observer);
    void notifySubscribers();
}
