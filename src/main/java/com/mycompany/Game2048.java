package com.mycompany;

/**
 * Represents the logic of a 2048 game on a 4-by-4 board.
 * Handles tile movement, merging, tile generation, game-over
 * detection and restoring previous board states.
 * 
 * @author Zara Tasnim
 * @studentID 2450607
 * @author Selena Sirbu
 * @studentID 2472007
 */
public class Game2048 {
    private final int[][] board;
    private final TileGenerator tileGenerator;
    private final GameHistory history;
    
    public Game2048() {
        board = new int[4][4];
        tileGenerator = new TileGenerator();
        history = new GameHistory();
        
        spawnTile();
        spawnTile();
    }
    
    private void spawnTile() {
        tileGenerator.generateTile(board);
    }
    
    private void saveCurrentBoard() {
        history.savedBoard(board);
    }
    
    /**
     * Restores the board to its state before the most recent valid move.
     * Leaves the board unchanged if no previous state is available.
     */
    public void undoMove() {
        int[][] previousBoard = history.undo();
        
        if (previousBoard == null) {
            return;
        }
        
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                board[row][col] = previousBoard[row][col];
            }
        }
    }
    
    /**
     * Returns the value stored at the specified board position.
     * 
     * @param row the row index of the cell
     * @param column the column index of the cell
     * @return the value stored in the cell
     */
    public int getCell(int row, int column) {
        return board[row][column];
    }
    
    private boolean hasEmptyCell() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (board[row][col] == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean canMergeRight(int row, int col) {
        return col < 3 && board[row][col] == board[row][col + 1];
    }
    
    private boolean hasHorizontalMerge() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (canMergeRight(row, col)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean canMergeDown(int row, int col) {
        return row < 3 && board[row][col] == board[row + 1][col];
    }
    
    private boolean hasVerticalMerge() {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (canMergeDown(row, col)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Checks whether the game has ended.
     * A game is over when there are no empty cells and no adjacent
     * tiles with equal values that can merge.
     * Does not modify the board.
     * 
     * @return true if no legal moves remain, false otherwise
     */
    public boolean isGameOver() {
        if (hasEmptyCell()) {
            return false;
        }

        if (hasHorizontalMerge()) {
            return false;
        }

        if (hasVerticalMerge()) {
            return false;
        }

        return true;
    }
    
    /**
     * Moves all tiles to the left, merging adjacent equal tiles once per move.
     * Generates a new tile only of the board changes.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveLeft() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;
        boolean changed;
        
        saveCurrentBoard();
        firstSlideChanged = slideLeft();
        mergeChanged = mergeLeft();
        secondSlideChanged = slideLeft();
        changed = firstSlideChanged || mergeChanged || secondSlideChanged;
        
        if (changed) {
            spawnTile();
        } else {
            history.discardLastSave();
        }
        
        return changed;
    }
    
    private boolean slideLeft() {
        boolean changed;
        
        changed = false;
                
        for (int row = 0; row < 4; row++) {
            // Tracks the next column where a non-zero tile should be placed.
            int writeIndex;
            
            writeIndex = 0;
            
            // Scans each column to find non-zero tiles that need to be moved.
            for (int readIndex = 0; readIndex < 4; readIndex++) {
                if (board[row][readIndex] != 0) {
                    board[row][writeIndex] = board[row][readIndex];
                    
                    if (readIndex != writeIndex) {
                        changed = true;
                    }
                    
                    writeIndex++;
                }
            }
            clearRemainingRightCells(row, writeIndex);
        }
    
        return changed;
    }
    
    private void clearRemainingRightCells(int row, int writeIndex) {
        for (int i = writeIndex; i < 4; i++) {
            board[row][i] = 0;
        }
    }
    
    private boolean mergeLeft() {
        boolean changed;
        
        changed = false;
        
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 3;) {
                if ((board[row][col] == board[row][col + 1])
                        && (board[row][col] != 0)) {
                    board[row][col] += board[row][col + 1];
                    board[row][col + 1] = 0;
                    changed = true;
                    col = col + 2;
                } else {
                    col++;
                }
            }
        }
        
        return changed;
    }
    
    /**
     * Moves all tiles to the right, merging adjacent equal tiles once per move.
     * Generates a new tile only of the board changes.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveRight() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;
        boolean changed;

        saveCurrentBoard();
        firstSlideChanged = slideRight();
        mergeChanged = mergeRight();
        secondSlideChanged = slideRight();
        changed = firstSlideChanged || mergeChanged || secondSlideChanged;

        if (changed) {
            spawnTile();
        } else {
            history.discardLastSave();
        }

        return changed;
    }
    
    private boolean slideRight() {
        boolean changed;
        
        changed = false;
                
        for (int row = 0; row < 4; row++) {
            // Tracks the next column where a non-zero tile should be placed.
            int writeIndex;
            
            writeIndex = 3;
            
            // Scans each column to find non-zero tiles that need to be moved.
            for (int readIndex = 3; readIndex >= 0; readIndex--) {
                if (board[row][readIndex] != 0) {
                    board[row][writeIndex] = board[row][readIndex];
                    
                    if (readIndex != writeIndex) {
                        changed = true;
                    }
                    
                    writeIndex--;
                }
            }
            clearRemainingLeftCells(row, writeIndex);
        }        
    
        return changed;
    }
    
    private void clearRemainingLeftCells(int row, int writeIndex) {
        for (int i = writeIndex; i >= 0; i--) {
            board[row][i] = 0;
        }
    }
    
    private boolean mergeRight() {
        boolean changed;
        
        changed = false;
        
        for (int row = 0; row < 4; row++) {
            for (int col = 3; col >= 1;) {
                if ((board[row][col] == board[row][col - 1])
                        && (board[row][col] != 0)) {
                    board[row][col] += board[row][col - 1];
                    board[row][col - 1] = 0;
                    changed = true;
                    col = col - 2;
                } else {
                    col--;
                }
            }
        }
        
        return changed;
    }
        
    /**
     * Moves all tiles upward, merging adjacent equal tiles once per move.
     * Generates a new tile only if the board changes.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveUp() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;
        boolean changed;

        saveCurrentBoard();
        firstSlideChanged = slideUp();
        mergeChanged = mergeUp();
        secondSlideChanged = slideUp();
        changed = firstSlideChanged || mergeChanged || secondSlideChanged;

        if (changed) {
            spawnTile();
        } else {
            history.discardLastSave();
        }

        return changed;
    }
    
    private boolean slideUp() {
        boolean changed;

        changed = false;

        for (int col = 0; col < 4; col++) {
            // Tracks the next row where a non-zero tile should be placed.
            int writeIndex;

            writeIndex = 0;

            // Scans each row to find non-zero tiles that need to be moved.
            for (int readIndex = 0; readIndex < 4; readIndex++) {
                if (board[readIndex][col] != 0) {
                    board[writeIndex][col] = board[readIndex][col];

                    if (readIndex != writeIndex) {
                        changed = true;
                    }

                    writeIndex++;
                }
            }
            clearRemainingDownCells(col, writeIndex);
        }

        return changed;
    }
    
    private void clearRemainingDownCells(int col, int writeIndex) {
        for (int i = writeIndex; i < 4; i++) {
            board[i][col] = 0;
        }
    }
    
    private boolean mergeUp() {
        boolean changed;

        changed = false;

        for (int col = 0; col < 4; col++) {
            for (int row = 0; row < 3;) {
                if ((board[row][col] == board[row + 1][col])
                        && (board[row][col] != 0)) {
                    board[row][col] += board[row + 1][col];
                    board[row + 1][col] = 0;
                    changed = true;
                    row = row + 2;
                } else {
                    row++;
                }
            }
        }

        return changed;
    }
    
    /**
     * Moves all tiles downward, merging adjacent equal tiles once per move.
     * Generates a new tile only if the board changes.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveDown() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;
        boolean changed;

        saveCurrentBoard();
        firstSlideChanged = slideDown();
        mergeChanged = mergeDown();
        secondSlideChanged = slideDown();
        changed = firstSlideChanged || mergeChanged || secondSlideChanged;

        if (changed) {
            spawnTile();
        } else {
            history.discardLastSave();
        }

        return changed;
    }
    
    private boolean slideDown() {
        boolean changed;

        changed = false;

        for (int col = 0; col < 4; col++) {
            // Tracks the next row where a non-zero tile should be placed.
            int writeIndex;

            writeIndex = 3;

            // Scans each row to find non-zero tiles that need to be moved.
            for (int readIndex = 3; readIndex >= 0; readIndex--) {
                if (board[readIndex][col] != 0) {
                    board[writeIndex][col] = board[readIndex][col];

                    if (readIndex != writeIndex) {
                        changed = true;
                    }

                    writeIndex--;
                }
            }
            clearRemainingUpCells(col, writeIndex);
        }

        return changed;
    }
    
    private void clearRemainingUpCells(int col, int writeIndex) {
        for (int i = writeIndex; i >= 0; i--) {
            board[i][col] = 0;
        }
    }
    
    private boolean mergeDown() {
        boolean changed;

        changed = false;

        for (int col = 0; col < 4; col++) {
            for (int row = 3; row >= 1;) {
                if ((board[row][col] == board[row - 1][col])
                        && (board[row][col] != 0)) {
                    board[row][col] += board[row - 1][col];
                    board[row - 1][col] = 0;
                    changed = true;
                    row = row - 2;
                } else {
                    row--;
                }
            }
        }

        return changed;
    }
}