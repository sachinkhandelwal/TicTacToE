package com.sachin;

import com.sachin.controllers.GameController;
import com.sachin.models.*;
import com.sachin.strategies.GameWinningStrategy;
import com.sachin.strategies.NormalWinningStrategy;

import java.util.List;

public class Application {
    private static GameController gameController = new GameController();
    public static void main(String[] args) {
        List<Player> players = List.of(new Human(new Symbol()),
                new Bot(new Symbol()));
        List<GameWinningStrategy> gameWinningStrategies = List.of(new NormalWinningStrategy());
        Game game = gameController.createGame(4, players, gameWinningStrategies);
    }
}
