package com.example.demo_2340;

public class TileMap {
    private Tile[][] map1;
    private Tile[][] map2;
    private Tile[][] map3;
    public TileMap() {
        map1 = new Tile[][] {
            //row1
            {new Tile(1, 1, 1), new Tile(2, 1, 1), new Tile(3, 1, 1), new Tile(4, 1, 1),
                    new Tile(5, 1, 1), new Tile(6, 1, 1), new Tile(7, 1, 1), new Tile(8, 1, 1),
                    new Tile(9, 1, 1), new Tile(10, 1, 1), new Tile(11, 1, 1), new Tile(12, 1, 1),
                    new Tile(13, 1, 1), new Tile(14, 1, 1), new Tile(15, 1, 1), new Tile(16, 1, 1)},
            //row2
            {new Tile(1, 2, 1), new Tile(2, 2, 1), new Tile(3, 2, 1), new Tile(4, 2, 1),
                    new Tile(5, 2, 1), new Tile(6, 2, 1), new Tile(7, 2, 1), new Tile(8, 2, 1),
                    new Tile(9, 2, 1), new Tile(10, 2, 1), new Tile(11, 2, 1), new Tile(12, 2, 1),
                    new Tile(13, 2, 1), new Tile(14, 2, 1), new Tile(15, 2, 1), new Tile(16, 2, 1)},
            //row3
            {new Tile(1, 3, 1), new Tile(2, 3, 1), new Tile(3, 3, 1), new Tile(4, 3, 1),
                    new Tile(5, 3, 1), new Tile(6, 3, 1), new Tile(7, 3, 1), new Tile(8, 3, 1),
                    new Tile(9, 3, 1), new Tile(10, 3, 1), new Tile(11, 3, 1), new Tile(12, 3, 1),
                    new Tile(13, 3, 1), new Tile(14, 3, 1), new Tile(15, 3, 1), new Tile(16, 3, 1)},
            //row4
            {new Tile(1, 4, 1), new Tile(2, 4, 1), new Tile(3, 4, 1), new Tile(4, 4, 1),
                    new Tile(5, 4, 1), new Tile(6, 4, 1), new Tile(7, 4, 1), new Tile(8, 4, 1),
                    new Tile(9, 4, 1), new Tile(10, 4, 1), new Tile(11, 4, 1), new Tile(12, 4, 1),
                    new Tile(13, 4, 1), new Tile(14, 4, 1), new Tile(15, 4, 1), new Tile(16, 4, 1)},
            //row5
            {new Tile(1, 5, 1), new Tile(2, 5, 1), new Tile(3, 5, 1), new Tile(4, 5, 1),
                    new Tile(5, 5, 1), new Tile(6, 5, 1), new Tile(7, 5, 1), new Tile(8, 5, 1),
                    new Tile(9, 5, 1), new Tile(10, 5, 1), new Tile(11, 5, 1), new Tile(12, 5, 1),
                    new Tile(13, 5, 1), new Tile(14, 5, 1), new Tile(15, 5, 1), new Tile(16, 5, 1)},
            //row6
            {new Tile(1, 6, 1), new Tile(2, 6, 1), new Tile(3, 6, 1), new Tile(4, 6, 1),
                    new Tile(5, 6, 1), new Tile(6, 6, 1), new Tile(7, 6, 1), new Tile(8, 6, 1),
                    new Tile(9, 6, 1), new Tile(10, 6, 1), new Tile(11, 6, 1), new Tile(12, 6, 1),
                    new Tile(13, 6, 1), new Tile(14, 6, 1), new Tile(15, 6, 1), new Tile(16, 6, 1)},
            //row7
            {new Tile(1, 7, 1), new Tile(2, 7, 1), new Tile(3, 7, 1), new Tile(4, 7, 1),
                    new Tile(5, 7, 1), new Tile(6, 7, 1), new Tile(7, 7, 1), new Tile(8, 7, 1),
                    new Tile(9, 7, 1), new Tile(10, 7, 1), new Tile(11, 7, 1), new Tile(12, 7, 1),
                    new Tile(13, 7, 1), new Tile(14, 7, 1), new Tile(15, 7, 1), new Tile(16, 7, 1)},
            //row8
            {new Tile(1, 8, 1), new Tile(2, 8, 1), new Tile(3, 8, 1), new Tile(4, 8, 1),
                    new Tile(5, 8, 1), new Tile(6, 8, 1), new Tile(7, 8, 1), new Tile(8, 8, 1),
                    new Tile(9, 8, 1), new Tile(10, 8, 1), new Tile(11, 8, 1), new Tile(12, 8, 1),
                    new Tile(13, 8, 1), new Tile(14, 8, 1), new Tile(15, 8, 1), new Tile(16, 8, 1)},
            //row9
            {new Tile(1, 9, 1), new Tile(2, 9, 1), new Tile(3, 9, 1), new Tile(4, 9, 1),
                    new Tile(5, 9, 1), new Tile(6, 9, 1), new Tile(7, 9, 1), new Tile(8, 9, 1),
                    new Tile(9, 9, 1), new Tile(10, 9, 1), new Tile(11, 9, 1), new Tile(12, 9, 1),
                    new Tile(13, 9, 1), new Tile(14, 9, 1), new Tile(15, 9, 1), new Tile(16, 9, 1)},
            //row10
            {new Tile(1, 10, 1), new Tile(2, 10, 1), new Tile(3, 10, 1), new Tile(4, 10, 1),
                    new Tile(5, 10, 1), new Tile(6, 10, 1), new Tile(7, 10, 1), new Tile(8, 10, 1),
                    new Tile(9, 10, 1), new Tile(10, 10, 1), new Tile(11, 10, 1), new Tile(12, 10, 1),
                    new Tile(13, 10, 1), new Tile(14, 10, 1), new Tile(15, 10, 1), new Tile(16, 10, 1)},
            //row11
            {new Tile(1, 11, 1), new Tile(2, 11, 1), new Tile(3, 11, 1), new Tile(4, 11, 1),
                    new Tile(5, 11, 1), new Tile(6, 11, 1), new Tile(7, 11, 1), new Tile(8, 11, 1),
                    new Tile(9, 11, 1), new Tile(10, 11, 1), new Tile(11, 11, 1), new Tile(12, 11, 1),
                    new Tile(13, 11, 1), new Tile(14, 11, 1), new Tile(15, 11, 1), new Tile(16, 11, 1)},
            //row12
            {new Tile(1, 12, 1), new Tile(2, 12, 1), new Tile(3, 12, 1), new Tile(4, 12, 1),
                    new Tile(5, 12, 1), new Tile(6, 12, 1), new Tile(7, 12, 1), new Tile(8, 12, 1),
                    new Tile(9, 12, 1), new Tile(10, 12, 1), new Tile(11, 12, 1), new Tile(12, 12, 1),
                    new Tile(13, 12, 1), new Tile(14, 12, 1), new Tile(15, 12, 1), new Tile(16, 12, 1)},
            //row13
            {new Tile(1, 13, 1), new Tile(2, 13, 1), new Tile(3, 13, 1), new Tile(4, 13, 1),
                    new Tile(5, 13, 1), new Tile(6, 13, 1), new Tile(7, 13, 1), new Tile(8, 13, 1),
                    new Tile(9, 13, 1), new Tile(10, 13, 1), new Tile(11, 13, 1), new Tile(12, 13, 1),
                    new Tile(13, 13, 1), new Tile(14, 13, 1), new Tile(15, 13, 1), new Tile(16, 13, 1)},
            //row14
            {new Tile(1, 14, 1), new Tile(2, 14, 1), new Tile(3, 14, 1), new Tile(4, 14, 1),
                    new Tile(5, 14, 1), new Tile(6, 14, 1), new Tile(7, 14, 1), new Tile(8, 14, 1),
                    new Tile(9, 14, 1), new Tile(10, 14, 1), new Tile(11, 14, 1), new Tile(12, 14, 1),
                    new Tile(13, 14, 1), new Tile(14, 14, 1), new Tile(15, 14, 1), new Tile(16, 14, 1)},
            //row15
            {new Tile(1, 15, 1), new Tile(2, 15, 1), new Tile(3, 15, 1), new Tile(4, 15, 1),
                    new Tile(5, 15, 1), new Tile(6, 15, 1), new Tile(7, 15, 1), new Tile(8, 15, 1),
                    new Tile(9, 15, 1), new Tile(10, 15, 1), new Tile(11, 15, 1), new Tile(12, 15, 1),
                    new Tile(13, 15, 1), new Tile(14, 15, 1), new Tile(15, 15, 1), new Tile(16, 15, 1)},
            //row16
            {new Tile(1, 16, 1), new Tile(2, 16, 1), new Tile(3, 16, 1), new Tile(4, 16, 1),
                    new Tile(5, 16, 1), new Tile(6, 16, 1), new Tile(7, 16, 1), new Tile(8, 16, 1),
                    new Tile(9, 16, 1), new Tile(10, 16, 1), new Tile(11, 16, 1), new Tile(12, 16, 1),
                    new Tile(13, 16, 1), new Tile(14, 16, 1), new Tile(15, 16, 1), new Tile(16, 16, 1)},
        };
        map2 = new Tile[][] {
            //row1
            {new Tile(1, 1, 1), new Tile(2, 1, 1), new Tile(3, 1, 1), new Tile(4, 1, 1),
                    new Tile(5, 1, 1), new Tile(6, 1, 1), new Tile(7, 1, 1), new Tile(8, 1, 1),
                    new Tile(9, 1, 1), new Tile(10, 1, 1), new Tile(11, 1, 1), new Tile(12, 1, 1),
                    new Tile(13, 1, 1), new Tile(14, 1, 1), new Tile(15, 1, 1), new Tile(16, 1, 1)},
            //row2
            {new Tile(1, 2, 1), new Tile(2, 2, 1), new Tile(3, 2, 1), new Tile(4, 2, 1),
                    new Tile(5, 2, 1), new Tile(6, 2, 1), new Tile(7, 2, 1), new Tile(8, 2, 1),
                    new Tile(9, 2, 1), new Tile(10, 2, 1), new Tile(11, 2, 1), new Tile(12, 2, 1),
                    new Tile(13, 2, 1), new Tile(14, 2, 1), new Tile(15, 2, 1), new Tile(16, 2, 1)},
            //row3
            {new Tile(1, 3, 1), new Tile(2, 3, 1), new Tile(3, 3, 1), new Tile(4, 3, 1),
                    new Tile(5, 3, 1), new Tile(6, 3, 1), new Tile(7, 3, 1), new Tile(8, 3, 1),
                    new Tile(9, 3, 1), new Tile(10, 3, 1), new Tile(11, 3, 1), new Tile(12, 3, 1),
                    new Tile(13, 3, 1), new Tile(14, 3, 1), new Tile(15, 3, 1), new Tile(16, 3, 1)},
            //row4
            {new Tile(1, 4, 1), new Tile(2, 4, 1), new Tile(3, 4, 1), new Tile(4, 4, 1),
                    new Tile(5, 4, 1), new Tile(6, 4, 1), new Tile(7, 4, 1), new Tile(8, 4, 1),
                    new Tile(9, 4, 1), new Tile(10, 4, 1), new Tile(11, 4, 1), new Tile(12, 4, 1),
                    new Tile(13, 4, 1), new Tile(14, 4, 1), new Tile(15, 4, 1), new Tile(16, 4, 1)},
            //row5
            {new Tile(1, 5, 1), new Tile(2, 5, 1), new Tile(3, 5, 1), new Tile(4, 5, 1),
                    new Tile(5, 5, 1), new Tile(6, 5, 1), new Tile(7, 5, 1), new Tile(8, 5, 1),
                    new Tile(9, 5, 1), new Tile(10, 5, 1), new Tile(11, 5, 1), new Tile(12, 5, 1),
                    new Tile(13, 5, 1), new Tile(14, 5, 1), new Tile(15, 5, 1), new Tile(16, 5, 1)},
            //row6
            {new Tile(1, 6, 1), new Tile(2, 6, 1), new Tile(3, 6, 1), new Tile(4, 6, 1),
                    new Tile(5, 6, 1), new Tile(6, 6, 1), new Tile(7, 6, 1), new Tile(8, 6, 1),
                    new Tile(9, 6, 1), new Tile(10, 6, 1), new Tile(11, 6, 1), new Tile(12, 6, 1),
                    new Tile(13, 6, 1), new Tile(14, 6, 1), new Tile(15, 6, 1), new Tile(16, 6, 1)},
            //row7
            {new Tile(1, 7, 1), new Tile(2, 7, 1), new Tile(3, 7, 1), new Tile(4, 7, 1),
                    new Tile(5, 7, 1), new Tile(6, 7, 1), new Tile(7, 7, 1), new Tile(8, 7, 1),
                    new Tile(9, 7, 1), new Tile(10, 7, 1), new Tile(11, 7, 1), new Tile(12, 7, 1),
                    new Tile(13, 7, 1), new Tile(14, 7, 1), new Tile(15, 7, 1), new Tile(16, 7, 1)},
            //row8
            {new Tile(1, 8, 1), new Tile(2, 8, 1), new Tile(3, 8, 1), new Tile(4, 8, 1),
                    new Tile(5, 8, 1), new Tile(6, 8, 1), new Tile(7, 8, 1), new Tile(8, 8, 1),
                    new Tile(9, 8, 1), new Tile(10, 8, 1), new Tile(11, 8, 1), new Tile(12, 8, 1),
                    new Tile(13, 8, 1), new Tile(14, 8, 1), new Tile(15, 8, 1), new Tile(16, 8, 1)},
            //row9
            {new Tile(1, 9, 1), new Tile(2, 9, 1), new Tile(3, 9, 1), new Tile(4, 9, 1),
                    new Tile(5, 9, 1), new Tile(6, 9, 1), new Tile(7, 9, 1), new Tile(8, 9, 1),
                    new Tile(9, 9, 1), new Tile(10, 9, 1), new Tile(11, 9, 1), new Tile(12, 9, 1),
                    new Tile(13, 9, 1), new Tile(14, 9, 1), new Tile(15, 9, 1), new Tile(16, 9, 1)},
            //row10
            {new Tile(1, 10, 1), new Tile(2, 10, 1), new Tile(3, 10, 1), new Tile(4, 10, 1),
                    new Tile(5, 10, 1), new Tile(6, 10, 1), new Tile(7, 10, 1), new Tile(8, 10, 1),
                    new Tile(9, 10, 1), new Tile(10, 10, 1), new Tile(11, 10, 1), new Tile(12, 10, 1),
                    new Tile(13, 10, 1), new Tile(14, 10, 1), new Tile(15, 10, 1), new Tile(16, 10, 1)},
            //row11
            {new Tile(1, 11, 1), new Tile(2, 11, 1), new Tile(3, 11, 1), new Tile(4, 11, 1),
                    new Tile(5, 11, 1), new Tile(6, 11, 1), new Tile(7, 11, 1), new Tile(8, 11, 1),
                    new Tile(9, 11, 1), new Tile(10, 11, 1), new Tile(11, 11, 1), new Tile(12, 11, 1),
                    new Tile(13, 11, 1), new Tile(14, 11, 1), new Tile(15, 11, 1), new Tile(16, 11, 1)},
            //row12
            {new Tile(1, 12, 1), new Tile(2, 12, 1), new Tile(3, 12, 1), new Tile(4, 12, 1),
                    new Tile(5, 12, 1), new Tile(6, 12, 1), new Tile(7, 12, 1), new Tile(8, 12, 1),
                    new Tile(9, 12, 1), new Tile(10, 12, 1), new Tile(11, 12, 1), new Tile(12, 12, 1),
                    new Tile(13, 12, 1), new Tile(14, 12, 1), new Tile(15, 12, 1), new Tile(16, 12, 1)},
            //row13
            {new Tile(1, 13, 1), new Tile(2, 13, 1), new Tile(3, 13, 1), new Tile(4, 13, 1),
                    new Tile(5, 13, 1), new Tile(6, 13, 1), new Tile(7, 13, 1), new Tile(8, 13, 1),
                    new Tile(9, 13, 1), new Tile(10, 13, 1), new Tile(11, 13, 1), new Tile(12, 13, 1),
                    new Tile(13, 13, 1), new Tile(14, 13, 1), new Tile(15, 13, 1), new Tile(16, 13, 1)},
            //row14
            {new Tile(1, 14, 1), new Tile(2, 14, 1), new Tile(3, 14, 1), new Tile(4, 14, 1),
                    new Tile(5, 14, 1), new Tile(6, 14, 1), new Tile(7, 14, 1), new Tile(8, 14, 1),
                    new Tile(9, 14, 1), new Tile(10, 14, 1), new Tile(11, 14, 1), new Tile(12, 14, 1),
                    new Tile(13, 14, 1), new Tile(14, 14, 1), new Tile(15, 14, 1), new Tile(16, 14, 1)},
            //row15
            {new Tile(1, 15, 1), new Tile(2, 15, 1), new Tile(3, 15, 1), new Tile(4, 15, 1),
                    new Tile(5, 15, 1), new Tile(6, 15, 1), new Tile(7, 15, 1), new Tile(8, 15, 1),
                    new Tile(9, 15, 1), new Tile(10, 15, 1), new Tile(11, 15, 1), new Tile(12, 15, 1),
                    new Tile(13, 15, 1), new Tile(14, 15, 1), new Tile(15, 15, 1), new Tile(16, 15, 1)},
            //row16
            {new Tile(1, 16, 1), new Tile(2, 16, 1), new Tile(3, 16, 1), new Tile(4, 16, 1),
                    new Tile(5, 16, 1), new Tile(6, 16, 1), new Tile(7, 16, 1), new Tile(8, 16, 1),
                    new Tile(9, 16, 1), new Tile(10, 16, 1), new Tile(11, 16, 1), new Tile(12, 16, 1),
                    new Tile(13, 16, 1), new Tile(14, 16, 1), new Tile(15, 16, 1), new Tile(16, 16, 1)},
        };
        map3 = new Tile[][] {
            //row1
            {new Tile(1, 1, 1), new Tile(2, 1, 1), new Tile(3, 1, 1), new Tile(4, 1, 1),
                    new Tile(5, 1, 1), new Tile(6, 1, 1), new Tile(7, 1, 1), new Tile(8, 1, 1),
                    new Tile(9, 1, 1), new Tile(10, 1, 1), new Tile(11, 1, 1), new Tile(12, 1, 1),
                    new Tile(13, 1, 1), new Tile(14, 1, 1), new Tile(15, 1, 1), new Tile(16, 1, 1)},
            //row2
            {new Tile(1, 2, 1), new Tile(2, 2, 1), new Tile(3, 2, 1), new Tile(4, 2, 1),
                    new Tile(5, 2, 1), new Tile(6, 2, 1), new Tile(7, 2, 1), new Tile(8, 2, 1),
                    new Tile(9, 2, 1), new Tile(10, 2, 1), new Tile(11, 2, 1), new Tile(12, 2, 1),
                    new Tile(13, 2, 1), new Tile(14, 2, 1), new Tile(15, 2, 1), new Tile(16, 2, 1)},
            //row3
            {new Tile(1, 3, 1), new Tile(2, 3, 1), new Tile(3, 3, 1), new Tile(4, 3, 1),
                    new Tile(5, 3, 1), new Tile(6, 3, 1), new Tile(7, 3, 1), new Tile(8, 3, 1),
                    new Tile(9, 3, 1), new Tile(10, 3, 1), new Tile(11, 3, 1), new Tile(12, 3, 1),
                    new Tile(13, 3, 1), new Tile(14, 3, 1), new Tile(15, 3, 1), new Tile(16, 3, 1)},
            //row4
            {new Tile(1, 4, 1), new Tile(2, 4, 1), new Tile(3, 4, 1), new Tile(4, 4, 1),
                    new Tile(5, 4, 1), new Tile(6, 4, 1), new Tile(7, 4, 1), new Tile(8, 4, 1),
                    new Tile(9, 4, 1), new Tile(10, 4, 1), new Tile(11, 4, 1), new Tile(12, 4, 1),
                    new Tile(13, 4, 1), new Tile(14, 4, 1), new Tile(15, 4, 1), new Tile(16, 4, 1)},
            //row5
            {new Tile(1, 5, 1), new Tile(2, 5, 1), new Tile(3, 5, 1), new Tile(4, 5, 1),
                    new Tile(5, 5, 1), new Tile(6, 5, 1), new Tile(7, 5, 1), new Tile(8, 5, 1),
                    new Tile(9, 5, 1), new Tile(10, 5, 1), new Tile(11, 5, 1), new Tile(12, 5, 1),
                    new Tile(13, 5, 1), new Tile(14, 5, 1), new Tile(15, 5, 1), new Tile(16, 5, 1)},
            //row6
            {new Tile(1, 6, 1), new Tile(2, 6, 1), new Tile(3, 6, 1), new Tile(4, 6, 1),
                    new Tile(5, 6, 1), new Tile(6, 6, 1), new Tile(7, 6, 1), new Tile(8, 6, 1),
                    new Tile(9, 6, 1), new Tile(10, 6, 1), new Tile(11, 6, 1), new Tile(12, 6, 1),
                    new Tile(13, 6, 1), new Tile(14, 6, 1), new Tile(15, 6, 1), new Tile(16, 6, 1)},
            //row7
            {new Tile(1, 7, 1), new Tile(2, 7, 1), new Tile(3, 7, 1), new Tile(4, 7, 1),
                    new Tile(5, 7, 1), new Tile(6, 7, 1), new Tile(7, 7, 1), new Tile(8, 7, 1),
                    new Tile(9, 7, 1), new Tile(10, 7, 1), new Tile(11, 7, 1), new Tile(12, 7, 1),
                    new Tile(13, 7, 1), new Tile(14, 7, 1), new Tile(15, 7, 1), new Tile(16, 7, 1)},
            //row8
            {new Tile(1, 8, 1), new Tile(2, 8, 1), new Tile(3, 8, 1), new Tile(4, 8, 1),
                    new Tile(5, 8, 1), new Tile(6, 8, 1), new Tile(7, 8, 1), new Tile(8, 8, 1),
                    new Tile(9, 8, 1), new Tile(10, 8, 1), new Tile(11, 8, 1), new Tile(12, 8, 1),
                    new Tile(13, 8, 1), new Tile(14, 8, 1), new Tile(15, 8, 1), new Tile(16, 8, 1)},
            //row9
            {new Tile(1, 9, 1), new Tile(2, 9, 1), new Tile(3, 9, 1), new Tile(4, 9, 1),
                    new Tile(5, 9, 1), new Tile(6, 9, 1), new Tile(7, 9, 1), new Tile(8, 9, 1),
                    new Tile(9, 9, 1), new Tile(10, 9, 1), new Tile(11, 9, 1), new Tile(12, 9, 1),
                    new Tile(13, 9, 1), new Tile(14, 9, 1), new Tile(15, 9, 1), new Tile(16, 9, 1)},
            //row10
            {new Tile(1, 10, 1), new Tile(2, 10, 1), new Tile(3, 10, 1), new Tile(4, 10, 1),
                    new Tile(5, 10, 1), new Tile(6, 10, 1), new Tile(7, 10, 1), new Tile(8, 10, 1),
                    new Tile(9, 10, 1), new Tile(10, 10, 1), new Tile(11, 10, 1), new Tile(12, 10, 1),
                    new Tile(13, 10, 1), new Tile(14, 10, 1), new Tile(15, 10, 1), new Tile(16, 10, 1)},
            //row11
            {new Tile(1, 11, 1), new Tile(2, 11, 1), new Tile(3, 11, 1), new Tile(4, 11, 1),
                    new Tile(5, 11, 1), new Tile(6, 11, 1), new Tile(7, 11, 1), new Tile(8, 11, 1),
                    new Tile(9, 11, 1), new Tile(10, 11, 1), new Tile(11, 11, 1), new Tile(12, 11, 1),
                    new Tile(13, 11, 1), new Tile(14, 11, 1), new Tile(15, 11, 1), new Tile(16, 11, 1)},
            //row12
            {new Tile(1, 12, 1), new Tile(2, 12, 1), new Tile(3, 12, 1), new Tile(4, 12, 1),
                    new Tile(5, 12, 1), new Tile(6, 12, 1), new Tile(7, 12, 1), new Tile(8, 12, 1),
                    new Tile(9, 12, 1), new Tile(10, 12, 1), new Tile(11, 12, 1), new Tile(12, 12, 1),
                    new Tile(13, 12, 1), new Tile(14, 12, 1), new Tile(15, 12, 1), new Tile(16, 12, 1)},
            //row13
            {new Tile(1, 13, 1), new Tile(2, 13, 1), new Tile(3, 13, 1), new Tile(4, 13, 1),
                    new Tile(5, 13, 1), new Tile(6, 13, 1), new Tile(7, 13, 1), new Tile(8, 13, 1),
                    new Tile(9, 13, 1), new Tile(10, 13, 1), new Tile(11, 13, 1), new Tile(12, 13, 1),
                    new Tile(13, 13, 1), new Tile(14, 13, 1), new Tile(15, 13, 1), new Tile(16, 13, 1)},
            //row14
            {new Tile(1, 14, 1), new Tile(2, 14, 1), new Tile(3, 14, 1), new Tile(4, 14, 1),
                    new Tile(5, 14, 1), new Tile(6, 14, 1), new Tile(7, 14, 1), new Tile(8, 14, 1),
                    new Tile(9, 14, 1), new Tile(10, 14, 1), new Tile(11, 14, 1), new Tile(12, 14, 1),
                    new Tile(13, 14, 1), new Tile(14, 14, 1), new Tile(15, 14, 1), new Tile(16, 14, 1)},
            //row15
            {new Tile(1, 15, 1), new Tile(2, 15, 1), new Tile(3, 15, 1), new Tile(4, 15, 1),
                    new Tile(5, 15, 1), new Tile(6, 15, 1), new Tile(7, 15, 1), new Tile(8, 15, 1),
                    new Tile(9, 15, 1), new Tile(10, 15, 1), new Tile(11, 15, 1), new Tile(12, 15, 1),
                    new Tile(13, 15, 1), new Tile(14, 15, 1), new Tile(15, 15, 1), new Tile(16, 15, 1)},
            //row16
            {new Tile(1, 16, 1), new Tile(2, 16, 1), new Tile(3, 16, 1), new Tile(4, 16, 1),
                    new Tile(5, 16, 1), new Tile(6, 16, 1), new Tile(7, 16, 1), new Tile(8, 16, 1),
                    new Tile(9, 16, 1), new Tile(10, 16, 1), new Tile(11, 16, 1), new Tile(12, 16, 1),
                    new Tile(13, 16, 1), new Tile(14, 16, 1), new Tile(15, 16, 1), new Tile(16, 16, 1)},
        };
    }
}
