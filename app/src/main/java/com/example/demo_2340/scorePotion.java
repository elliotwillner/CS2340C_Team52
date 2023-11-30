package com.example.demo_2340;

public class scorePotion extends Potion {
    public scorePotion(int column, int row, boolean isActive) {
        super(column, row, isActive);
    }
    @Override
    public void applyPowerUp(Player player) {
        player.applyPowerUp(new scorePowerUp(player));
    }
}
