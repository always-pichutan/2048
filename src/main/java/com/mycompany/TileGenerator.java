package com.mycompany;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generates random numbered tiles in empty cells of the 2048 board.
 *
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID need to insert student ID
 */
public class TileGenerator {

    public void generateTile(int board[][]) {

        ArrayList<int[]> emptyCells = new ArrayList<>();

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {

                if (board[row][col] == 0) {
                    emptyCells.add(new int[]{row, col});
                }
            }
        }

        if (emptyCells.isEmpty()) {
            return;
        }

        Random randomGenerator = new Random();
        int randomIndex = randomGenerator.nextInt(emptyCells.size());
        int[] selectedCell = emptyCells.get(randomIndex);
        int value;

        double probability = randomGenerator.nextDouble();
        if (probability <= 0.9) {
            value = 2;
        } else {
            value = 4;
        }

        board[selectedCell[0]][selectedCell[1]] = value;

    }
}