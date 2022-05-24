package com.sachin.models;

public abstract class Player {
    private Symbol symbol;
    private PlayerType playerType;

    public Player(PlayerType playerType, Symbol symbol){
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
