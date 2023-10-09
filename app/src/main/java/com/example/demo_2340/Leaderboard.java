package com.example.demo_2340;
import java.util.ArrayList;

public class Leaderboard {
    private volatile static Leaderboard uniqueInstance;
    protected static ArrayList<Integer> scoreList;
    private static ArrayList<String> nameList;
    private static int minScore;
    private Leaderboard() {
        scoreList = new ArrayList<>();
        nameList = new ArrayList<>();
    }
    public static Leaderboard getInstance() {
        if (uniqueInstance == null) {
            synchronized (Leaderboard.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Leaderboard();
                }
            }
        }
        return uniqueInstance;
    }
    public static void addPlayer() {
        if (scoreList.size() == 0) {
            scoreList.add(Player.getInstance().getScore());
            nameList.add(Player.getInstance().getName());
            minScore = Player.getInstance().getScore();
        } else if (scoreList.size() < 5) {
            scoreList.add(Player.getInstance().getScore());
            nameList.add(Player.getInstance().getName());
            sortLeaderboard();
            minScore = scoreList.get(scoreList.size() - 1);
        } else if (Player.getInstance().getScore() > minScore) {
            scoreList.add(Player.getInstance().getScore());
            nameList.add(Player.getInstance().getName());
            sortLeaderboard();
            minScore = scoreList.get(4);
        }
    }


    public static void sortLeaderboard() {
        int n = scoreList.size();
        for (int i = 0; i < (n - 1); i++) {
            int max = i;
            for (int j = (i + 1); j < n; j++) {
                if (scoreList.get(j) > scoreList.get(max)) {
                    max = j;
                }
            }
            swap(max, i);
        }
        if (scoreList.size() == 6) {
            scoreList.remove(5);
            nameList.remove(5);
        }
    }

    public synchronized static void swap(int i, int j) {
        int tempInt = scoreList.get(i);
        scoreList.set(i, scoreList.get(j));
        scoreList.set(j, tempInt);
        String tempString = nameList.get(i);
        nameList.set(i, nameList.get(j));
        nameList.set(j, tempString);
    }

    public static int getScore(int i) {
        return scoreList.get(i);
    }

    public static String getName(int i) {
        return nameList.get(i);
    }

    public static int getScoreListSize() {
        return scoreList.size();
    }
}