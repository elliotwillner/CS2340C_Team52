package com.example.demo_2340;

public interface Enemy extends Observer {
    void display();
    void move();
    int getRow();
    int getColumn();
    void setDamage(int difficulty);
    void onCollision();

    void takeDamage(int damage);
}
