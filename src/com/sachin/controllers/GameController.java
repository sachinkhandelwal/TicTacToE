package com.sachin.controllers;

import com.sachin.models.*;
import com.sachin.strategies.GameWinningStrategy;
import com.sachin.strategies.NormalWinningStrategy;

import java.util.List;

public class GameController {

    public Game createGame(int dimension,
                           List<Player> players,
                           List<GameWinningStrategy> gameWinningStrategies){
        Game game = null;
                try {
                    game = Game.create()
                            .withBoard(new Board(dimension))
                            .addPlayers(players)
                            .addGameWinningStrategies(gameWinningStrategies)
                            .build();
                } catch (Exception exception){
                    System.out.println("There is some problem while creating game");
                }
        return game;
    }

    public boolean makeMove(Game game, Player player){
        return game.makeMove();
    }

    /*public Game currentGameStatus(Game game){

    }

    public boolean undo(Game game){
        return game.undo();
    }

    public Player getWinner(Game game){

    }*/
}
