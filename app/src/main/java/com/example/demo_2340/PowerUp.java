package com.example.demo_2340;
public abstract class PowerUp extends Player {
    protected Player player;
    public PowerUp(Player player) {
        super();
        this.player = player;
    }
    public abstract void decorate(Player player);
}