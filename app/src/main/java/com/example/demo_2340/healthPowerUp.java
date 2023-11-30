package com.example.demo_2340;

public class healthPowerUp extends PowerUp {
    public healthPowerUp(Player player) {
        super(player);
    }
    @Override
    public void decorate(Player player) {
        player.setHealth(player.getHealth() + 50);
        GameScreen.updateHealth();
    }
}
