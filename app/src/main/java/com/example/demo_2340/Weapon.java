package com.example.demo_2340;

public class Weapon {
    private int damage;

    public Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void attack(Enemy enemy) {
        enemy.takeDamage(damage);
    }
}

