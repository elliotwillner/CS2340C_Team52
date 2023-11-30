package com.example.demo_2340;

public class scorePowerUp extends PowerUp {
    public scorePowerUp(Player player) {
        super(player);
    }

    @Override
    public void decorate(Player player) {
        player.increaseScore(50);
        GameScreen.updateScore();
    }
}
