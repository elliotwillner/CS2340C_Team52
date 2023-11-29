package com.example.demo_2340;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Handler;
import android.widget.Space;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameScreen extends AppCompatActivity implements Observer {
    private ImageView mapImageView;
    private TextView nameTextView;
    private static TextView healthTextView;
    private ImageView spriteImageView;
    private ImageView enemyImageView;
    private ImageView enemyImageView2;
    private ImageView weaponImageView;
    private TextView difficultyTextView;
    private static TextView playerScoreTextView;
    private static Player player = Player.getInstance();
    //switch out playerScore and playerName uses for the Player variables
    private static int playerScore;
    private String playerName;
    private GridLayout grid;
    private Handler handler;
    private Runnable runnable;

    private List<Enemy> enemies;
    private Handler enemyHandler;
    private Runnable enemyRunnable;
    private ImageView potionView1;
    private ImageView potionView2;
    private ImageView potionView3;
    private ImageView potionView4;
    private ImageView potionView5;
    private ImageView potionView6;
    private ImageView potionView7;
    private ImageView potionView8;
    private ImageView potionView9;
    private ImageView potionView10;
    private ImageView potionView11;
    private ImageView potionView12;
    private Potion potion1;
    private Potion potion2;
    private Potion potion3;
    private Potion potion4;
    private Potion potion5;
    private Potion potion6;
    private Potion potion7;
    private Potion potion8;
    private Potion potion9;
    private Potion potion10;
    private Potion potion11;
    private Potion potion12;


    private int currMap = 1;
    private TileMap tileMap = new TileMap();
    private List<Potion> potionsList1 = new ArrayList<>();
    private List<Potion> potionsList2 = new ArrayList<>();
    private List<Potion> potionsList3 = new ArrayList<>();
    private Map<Potion, ImageView> potionImageViewMap;
    public void initializePotionLists() {
        potionImageViewMap = new HashMap<>();
        potion1 = new resistancePotion(9, 8, true);
        potion2 = new healthPotion(13, 10, true);
        potion3 = new scorePotion(5, 9, false);
        potion4 = new scorePotion(4, 2, false);
        potion5 = new scorePotion(10, 3, false);
        potion6 = new scorePotion(12, 7, false);
        potion7 = new scorePotion(5, 13, false);
        potion8 = new healthPotion(1, 14, false);
        potion9 = new healthPotion(14, 14, false);
        potion10 = new healthPotion(14, 2, false);
        potion11 = new healthPotion(1, 7, false);
        potion12 = new healthPotion(14, 8, false);
        potionsList1.add(potion1);
        potionsList1.add(potion2);
        potionsList2.add(potion3);
        potionsList2.add(potion4);
        potionsList2.add(potion5);
        potionsList2.add(potion6);
        potionsList2.add(potion7);
        potionsList3.add(potion8);
        potionsList3.add(potion9);
        potionsList3.add(potion10);
        potionsList3.add(potion11);
        potionsList3.add(potion12);
        potionView1 = findViewById(R.id.potion1ImageView);
        potionView1.setImageResource(R.drawable.resistance_potion);
        potionView2 = findViewById(R.id.potion2ImageView);
        potionView2.setImageResource(R.drawable.health_potion);
        potionView3 = findViewById(R.id.potion3ImageView);
        potionView3.setImageResource(R.drawable.score_potion);
        potionView4 = findViewById(R.id.potion4ImageView);
        potionView4.setImageResource(R.drawable.score_potion);
        potionView5 = findViewById(R.id.potion5ImageView);
        potionView5.setImageResource(R.drawable.score_potion);
        potionView6 = findViewById(R.id.potion6ImageView);
        potionView6.setImageResource(R.drawable.score_potion);
        potionView7 = findViewById(R.id.potion7ImageView);
        potionView7.setImageResource(R.drawable.score_potion);
        potionView8 = findViewById(R.id.potion8ImageView);
        potionView8.setImageResource(R.drawable.health_potion);
        potionView9 = findViewById(R.id.potion9ImageView);
        potionView9.setImageResource(R.drawable.health_potion);
        potionView10 = findViewById(R.id.potion10ImageView);
        potionView10.setImageResource(R.drawable.health_potion);
        potionView11 = findViewById(R.id.potion11ImageView);
        potionView11.setImageResource(R.drawable.health_potion);
        potionView12 = findViewById(R.id.potion12ImageView);
        potionView12.setImageResource(R.drawable.health_potion);

        potionImageViewMap.put(potion1, potionView1);
        potionImageViewMap.put(potion2, potionView2);
        potionImageViewMap.put(potion3, potionView3);
        potionImageViewMap.put(potion4, potionView4);
        potionImageViewMap.put(potion5, potionView5);
        potionImageViewMap.put(potion6, potionView6);
        potionImageViewMap.put(potion7, potionView7);
        potionImageViewMap.put(potion8, potionView8);
        potionImageViewMap.put(potion9, potionView9);
        potionImageViewMap.put(potion10, potionView10);
        potionImageViewMap.put(potion11, potionView11);
        potionImageViewMap.put(potion12, potionView12);
    }


    public void activatePotionList(int map) {
        if (map == 1) {
           for (Potion potion : potionsList1) {
               potion.activate();
           }
           //deactivate
           for (Potion potion : potionsList2) {
               potion.deactivate();
           }
           for (Potion potion : potionsList3) {
               potion.deactivate();
           }
        } else if (map == 2) {
           for (Potion potion : potionsList2) {
               potion.activate();
           }
           //deactivate
           for (Potion potion : potionsList1) {
               potion.deactivate();
           }
           for (Potion potion : potionsList3) {
               potion.deactivate();
           }
        } else {
           for (Potion potion : potionsList3) {
               potion.activate();
           }
           //deactivate
           for (Potion potion : potionsList1) {
               potion.deactivate();
           }
           for (Potion potion : potionsList2) {
               potion.deactivate();
           }
        }
        for (Potion potion : potionsList1) {
            if ((potion.getActive()) && !(potion.getCollected())) {
                (potionImageViewMap.get(potion)).setVisibility(View.VISIBLE);
            } else {
                (potionImageViewMap.get(potion)).setVisibility(View.INVISIBLE);
            }
        }
        for (Potion potion : potionsList2) {
            if ((potion.getActive()) && !(potion.getCollected())) {
                (potionImageViewMap.get(potion)).setVisibility(View.VISIBLE);
            } else {
                (potionImageViewMap.get(potion)).setVisibility(View.INVISIBLE);
            }
        }
        for (Potion potion : potionsList3) {
            if ((potion.getActive()) && !(potion.getCollected())) {
                (potionImageViewMap.get(potion)).setVisibility(View.VISIBLE);
            } else {
                (potionImageViewMap.get(potion)).setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public void update(int x, int y) {
        mapImageView = findViewById(R.id.mapImageView);
        for (Potion potion : potionsList1) {
            if ((potion.getActive()) && !(potion.getCollected())) {
                (potionImageViewMap.get(potion)).setVisibility(View.VISIBLE);
            } else {
                (potionImageViewMap.get(potion)).setVisibility(View.INVISIBLE);
            }
        }
        for (Potion potion : potionsList2) {
            if ((potion.getActive()) && !(potion.getCollected())) {
                (potionImageViewMap.get(potion)).setVisibility(View.VISIBLE);
            } else {
                (potionImageViewMap.get(potion)).setVisibility(View.INVISIBLE);
            }
        }
        for (Potion potion : potionsList3) {
            if ((potion.getActive()) && !(potion.getCollected())) {
                (potionImageViewMap.get(potion)).setVisibility(View.VISIBLE);
            } else {
                (potionImageViewMap.get(potion)).setVisibility(View.INVISIBLE);
            }
        }
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("currMap = " + currMap);

        int tileType = 0;
        tileType = tileMap.getMap(currMap)[y][x].getType();

        System.out.println("The tile type is " + tileType);
        GridLayout gridLayout = findViewById(R.id.grid);
        switch (tileType) {
        case 2:
            player.setRow(2);
            player.setColumn(7);
            break;
        case 3:
            // Handle type 3 tile
            gridLayout.setBackgroundResource(R.drawable.map2);
            player.setRow(2);
            player.setColumn(7);
            currMap = 2;
            activatePotionList(currMap);
            break;
        case 4:
            // Handle type 4 tile
            gridLayout.setBackgroundResource(R.drawable.map3);
            player.setRow(2);
            player.setColumn(7);
            currMap = 3;
            activatePotionList(currMap);
            break;
        case 5:
            System.out.println("Won!");
            Intent intent = new Intent(GameScreen.this, EndScreenActivity.class);
            intent.putExtra("won", true);
            Player.getInstance().setName(player.getName());
            Player.getInstance().setScore(player.getScore());
            Player.getInstance().setDate(Calendar.getInstance().getTime());
            Leaderboard.addPlayer();
            player.reset();
            handler.removeCallbacks(runnable);
            startActivity(intent);
            finish();
            break;
        case 6:
            // Handle type 6 tile
            gridLayout.setBackgroundResource(R.drawable.map1);
            player.setRow(13);
            player.setColumn(7);
            currMap = 1;
            activatePotionList(currMap);
            break;
        case 7:
            // Handle type 7 tile
            gridLayout.setBackgroundResource(R.drawable.map2);
            player.setRow(13);
            player.setColumn(7);
            currMap = 2;
            activatePotionList(currMap);
            break;
        default:
            // Handle other cases (if needed)
            break;
        }
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);
        playerScoreTextView = findViewById(R.id.playerScoreTextView);
        initializePotionLists();
        //activatePotionList(1);
        playerScore = 101;
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                if (playerScore != 0) {
                    player.setScore(player.getScore() - 1);
                    updateScore();
                    handler.postDelayed(this, 1000);
                }
                if (player.getHealth() <= 0 || player.getScore() <= 0) {
                    System.out.println("Game Over!");
                    Intent intent = new Intent(GameScreen.this, EndScreenActivity.class);
                    intent.putExtra("won", false);
                    Player.getInstance().setName(playerName);
                    Player.getInstance().setScore(playerScore);
                    Player.getInstance().setDate(Calendar.getInstance().getTime());
                    Leaderboard.addPlayer();
                    player.reset();
                    handler.removeCallbacks(runnable);
                    startActivity(intent);
                    finish();
                }
            }
        };
        handler.postDelayed(runnable, 1000);
        grid = findViewById(R.id.grid);
        for (int x = 0; x < grid.getColumnCount(); x++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(0, 1, 1);
            params.columnSpec = GridLayout.spec(x, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            grid.addView(new Space(this), params);
        }
        for (int y = 0; y < grid.getRowCount(); y++) {
            GridLayout.LayoutParams params = new GridLayout.LayoutParams();
            params.rowSpec = GridLayout.spec(y, 1, 1);
            params.columnSpec = GridLayout.spec(0, 1, 1);
            params.setGravity(Gravity.FILL);
            params.width = 0;
            grid.addView(new Space(this), params);
        }
        nameTextView = findViewById(R.id.nameTextView);
        healthTextView = findViewById(R.id.healthTextView);
        spriteImageView = findViewById(R.id.spriteImageView);
        enemyImageView = findViewById(R.id.enemyImageView);
        enemyImageView2 = findViewById(R.id.enemyImageView2);
        difficultyTextView = findViewById(R.id.difficultyTextView);
        mapImageView = findViewById(R.id.mapImageView);
        mapImageView.setImageResource(R.drawable.map1);
        weaponImageView = findViewById(R.id.weaponImageView);
        playerName = getIntent().getStringExtra("playerName");
        String spriteID = getIntent().getStringExtra("selectedCharacter");
        int difficulty = getIntent().getIntExtra("selectedDifficulty", 1);

        player.setName(playerName);
        player.setDifficulty(difficulty);
        player.addObserver(this);
        System.out.println("Initial Column: " + player.getColumn());
        System.out.println("Initial Row: " + player.getRow());

        GridLayout.LayoutParams params =
                (GridLayout.LayoutParams) spriteImageView.getLayoutParams();
        params.rowSpec = GridLayout.spec(player.getRow());
        params.columnSpec = GridLayout.spec(player.getColumn());
        spriteImageView.setLayoutParams(params);

        EnemyFactory enemyFactory = new EnemyFactory(this, R.drawable.dungeon_tileset, 16, 16);
        Enemy troll = enemyFactory.createEnemy(EnemyType.TROLL);
        Enemy imp = enemyFactory.createEnemy(EnemyType.IMP);
        player.addObserver(troll);
        player.addObserver(imp);

        GridLayout.LayoutParams enemyParams =
                (GridLayout.LayoutParams) enemyImageView.getLayoutParams();
        enemyParams.rowSpec = GridLayout.spec(5);
        enemyParams.columnSpec = GridLayout.spec(5);
        enemyImageView.setLayoutParams(enemyParams);
        enemyImageView.setImageResource(R.drawable.troll_image);

        GridLayout.LayoutParams enemyParams2 =
                (GridLayout.LayoutParams) enemyImageView2.getLayoutParams();
        enemyParams2.rowSpec = GridLayout.spec(8);
        enemyParams2.columnSpec = GridLayout.spec(8);
        enemyImageView2.setLayoutParams(enemyParams2);
        enemyImageView2.setImageResource(R.drawable.imp_image);

        System.out.println("Updating");
        nameTextView.setText(playerName);

        enemies = new ArrayList<>();
        enemies.add(troll);
        enemies.add(imp);
        System.out.println("HERE");

        enemyHandler = new Handler();
        enemyRunnable = new Runnable() {
            @Override
            public void run() {
                // Update the position for each enemy
                for (Enemy enemy : enemies) {
                    enemy.move();
                    enemy.onCollision();
                    if (enemy.isPendingRemoval()) {
                        System.out.println("Removing enemy");
                        enemies.remove(enemy);
                        player.DefeatEnemyUpdateScore(enemy);
                        updateScore();
                    }
                }
                enemyHandler.postDelayed(this, 2000); // Update every 2 seconds

                GridLayout.LayoutParams params =
                        (GridLayout.LayoutParams) enemyImageView.getLayoutParams();
                params.rowSpec = GridLayout.spec(troll.getRow());
                params.columnSpec = GridLayout.spec(troll.getColumn());
                System.out.println("Troll x: " + troll.getColumn());
                System.out.println("Troll y: " + troll.getRow());
                enemyImageView.setLayoutParams(params);

                GridLayout.LayoutParams params2 =
                        (GridLayout.LayoutParams) enemyImageView2.getLayoutParams();
                params2.rowSpec = GridLayout.spec(imp.getRow());
                params2.columnSpec = GridLayout.spec(imp.getColumn());
                System.out.println("Imp x: " + imp.getColumn());
                System.out.println("Imp y: " + imp.getRow());
                enemyImageView2.setLayoutParams(params2);
            }
        };
        enemyHandler.postDelayed(enemyRunnable, 2000);

        if (difficulty == 3) {
            difficultyTextView.setText("Difficulty: Hard");
        } else if (difficulty == 2) {
            difficultyTextView.setText("Difficulty: Medium");
        } else {
            difficultyTextView.setText("Difficulty: Easy");
        }

        for (Enemy enemy : enemies) {
            enemy.setDamage(player.getDifficulty());
        }

        healthTextView.setText("Health: " + player.getHealth());

        if (spriteID.equals("Mage")) {
            spriteImageView.setImageResource(R.drawable.mage_image);
        } else if (spriteID.equals("Rogue")) {
            spriteImageView.setImageResource(R.drawable.rogue_image);
        } else if (spriteID.equals("Warrior")) {
            spriteImageView.setImageResource(R.drawable.warrior_image);
        }
    }
    public static void updateHealth() {
        if (healthTextView != null) {
            healthTextView.setText("Health: " + String.valueOf(player.getHealth()));
        }
    }
    public static void updateScore() {
        if (playerScoreTextView != null) {
            playerScoreTextView.setText("Score: " + String.valueOf(player.getScore()));
        }
    }
    public static void damageScore() {
        player.setScore(player.getScore() - 5);
        updateScore();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
        case KeyEvent.KEYCODE_DPAD_LEFT:
            if (player.getColumn() > 0) {
                player.setMoveStrategy(new MoveLeft());
                player.move(tileMap.getMap(currMap));
            }
            break;
        case KeyEvent.KEYCODE_DPAD_UP:
            if (player.getRow() > 0) {
                player.setMoveStrategy(new MoveUp());
                player.move(tileMap.getMap(currMap));
            }
            break;
        case KeyEvent.KEYCODE_DPAD_RIGHT:
            if (player.getColumn() < 15) {
                player.setMoveStrategy(new MoveRight());
                player.move(tileMap.getMap(currMap));
            }
            break;
        case KeyEvent.KEYCODE_DPAD_DOWN:
            if (player.getRow() < 15) {
                player.setMoveStrategy(new MoveDown());
                player.move(tileMap.getMap(currMap));
            }
            break;
        case KeyEvent.KEYCODE_SPACE:
            System.out.println("Attacking!");
            attackWithWeapon();
            break;
        default:
            break;
        }
        GridLayout.LayoutParams params =
                (GridLayout.LayoutParams) spriteImageView.getLayoutParams();
        params.rowSpec = GridLayout.spec(player.getRow());
        params.columnSpec = GridLayout.spec(player.getColumn());
        spriteImageView.setLayoutParams(params);
        return true;
    }
    public int getScore() {
        return playerScore;
    }

    private void attackWithWeapon() {
        GridLayout.LayoutParams weaponParams =
                (GridLayout.LayoutParams) weaponImageView.getLayoutParams();
        weaponParams.rowSpec = GridLayout.spec(player.getRow());
        weaponParams.columnSpec = GridLayout.spec(player.getColumn());
        weaponImageView.setVisibility(View.VISIBLE);
        weaponImageView.setLayoutParams(weaponParams);
        player.attack();
        animateWeapon();
    }

    private void animateWeapon() {
        Player.getInstance().setIsAttacking(true);
        RotateAnimation animation = new RotateAnimation(30, 330,
                Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);

        animation.setDuration(500);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Player.getInstance().setIsAttacking(false);
                weaponImageView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        weaponImageView.startAnimation(animation);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        player.removeObserver(this);
    }
}
