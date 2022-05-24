package com.sachin.models;

public class Human extends Player{

    public Human(Symbol symbol){
        super(PlayerType.HUMAN, symbol);
    }
    User user;
}
