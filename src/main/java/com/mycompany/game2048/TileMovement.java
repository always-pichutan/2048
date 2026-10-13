package com.mycompany.game2048;

public class TileMovement {
    private final int[][] board;
    
    public Game2048() {
        board = new int[4][4];
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
    
    // TODO: Check whether any legal moves remain without changing the board.
    
    /**
     * Moves all tiles to the left, merging adjacent equal non-zero tiles.
     * Slides the tiles before and after merging to remove empty spaces.
     * Each tile can merge only once per move.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveLeft() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;
        
        firstSlideChanged = slideLeft();
        mergeChanged = mergeLeft();
        secondSlideChanged = slideLeft();
        
        return firstSlideChanged || mergeChanged || secondSlideChanged;
    }
    
    private boolean slideLeft() {
        boolean changed; // points out if the move is valid
        
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
     * Moves all tiles to the right, merging adjacent equal non-zero tiles.
     * Slides the tiles before and after merging to remove empty spaces.
     * Each tile can merge only once per move.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveRight() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;

        firstSlideChanged = slideRight();
        mergeChanged = mergeRight();
        secondSlideChanged = slideRight();

        return firstSlideChanged || mergeChanged || secondSlideChanged;
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
     * Moves all tiles upwards, merging adjacent equal non-zero tiles.
     * Slides the tiles before and after merging to remove empty spaces.
     * Each tile can merge only once per move.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveUp() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;

        firstSlideChanged = slideUp();
        mergeChanged = mergeUp();
        secondSlideChanged = slideUp();

        return firstSlideChanged || mergeChanged || secondSlideChanged;
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
     * Moves all tiles downward, merging adjacent equal non-zero tiles.
     * Slides the tiles before and after merging to remove empty spaces.
     * Each tile can merge only once per move.
     * 
     * @return true if the board changed, false otherwise
     */
    public boolean moveDown() {
        boolean firstSlideChanged;
        boolean mergeChanged;
        boolean secondSlideChanged;

        firstSlideChanged = slideDown();
        mergeChanged = mergeDown();
        secondSlideChanged = slideDown();

        return firstSlideChanged || mergeChanged || secondSlideChanged;
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
