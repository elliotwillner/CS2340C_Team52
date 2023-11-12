package com.example.demo_2340;

public interface Enemy {
    void display();
    void move();
    int getRow();
    int getColumn();
    void onCollision();
}
