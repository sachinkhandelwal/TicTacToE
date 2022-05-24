package com.sachin.models;

import java.util.List;

public class Board {

    public Board(int dimension){
        this.dimension = dimension;
    }

    int dimension;
    List<List<Cell>> board;

    public Cell getCell(int x, int y){
        return board.get(x).get(y);
    }
    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public List<List<Cell>> getBoard() {
        return board;
    }

    public void setBoard(List<List<Cell>> board) {
        this.board = board;
    }
}
