package com.example.demo_2340;

import android.widget.ImageView;

public interface Enemy extends Observer {
    void display();
    void move();
    int getRow();
    int getColumn();
    void setDamage(int difficulty);
    void onCollision();

    void takeDamage();
    boolean isPendingRemoval();
    void setImageView(ImageView imageView);
    void setImageViewVisibility(boolean visible);
    void setPendingRemoval(boolean isPendingRemoval);
    boolean isActive();

    void setActive(boolean b);
}
