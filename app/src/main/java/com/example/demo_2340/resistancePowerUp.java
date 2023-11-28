package com.example.demo_2340;
import java.util.Timer;
import java.util.TimerTask;

public class resistancePowerUp extends PowerUp {
    public resistancePowerUp(Player player) {
        super(player);
    }

    @Override
    public void decorate(Player player) {
        player.setDamageMultiplier(player.getDamageMultiplier()/2);
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                player.setDamageMultiplier(player.getDamageMultiplier()*2);
            }
        } , 1000);
    }
}
