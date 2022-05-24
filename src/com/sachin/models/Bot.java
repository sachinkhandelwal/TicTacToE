package com.sachin.models;

import com.sachin.strategies.BotPlayingStrategy;

public class Bot extends Player{
    public Bot(Symbol symbol){
        super(PlayerType.BOT, new Symbol());
    }

    BotPlayingStrategy botPlayingStrategy;
}
