package com.example.demo_2340;

public class resistancePotion extends Potion {
    public resistancePotion(int column, int row, boolean isActive) {
        super(column, row, isActive);
    }
    @Override
    public void applyPowerUp(Player player) {
        player.applyPowerUp(new resistancePowerUp(player));
    }
}
