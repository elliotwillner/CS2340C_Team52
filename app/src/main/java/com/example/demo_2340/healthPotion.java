package com.example.demo_2340;

public class healthPotion extends Potion {
    public healthPotion(int column, int row, boolean isActive) {
        super(column, row, isActive);
    }
    @Override
    public void applyPowerUp(Player player) {
        player.applyPowerUp(new healthPowerUp(player));
    }
}
