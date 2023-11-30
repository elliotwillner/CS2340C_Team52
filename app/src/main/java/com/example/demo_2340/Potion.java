package com.example.demo_2340;

public abstract class Potion implements Observer {
    private int row;
    private int column;
    private boolean isActive;
    private boolean isCollected;
    private Player player = Player.getInstance();
    public Potion(int column, int row, boolean isActive) {
        this.column = column;
        this.row = row;
        this.isActive = isActive;
        this.isCollected = false;
        player.addObserver(this);
    }
    @Override
    public void update(int x, int y) {
        if ((isActive) && (!isCollected) && (row == (player.getRow())) && (column == (player.getColumn()))) {
            applyPowerUp(Player.getInstance());
            isCollected = true;
        }
    }
    public void activate() {
        isActive = true;
    }
    public void deactivate() {
        isActive = false;
    }
    public boolean getActive() {
        return isActive;
    }
    public boolean getCollected() {
        return isCollected;
    }
    public abstract void applyPowerUp(Player player);
}
