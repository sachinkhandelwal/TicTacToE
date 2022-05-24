package com.sachin.models;

import com.sachin.exceptions.MultiBotsException;
import com.sachin.strategies.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private Board board;
    private List<Player> players;
    private List<GameWinningStrategy> gameWinningStrategies;
    private List<Move> moves;

    private Game(){

    }

    public static Builder create(){
        return new Builder();
    }

    public boolean makeMove(){
        int playerNum = players.size() % moves.size();
        Player player = players.get(playerNum);

        int x = -1;
        int y = -1;
        System.out.println("Player " + playerNum + "chance to play.");
        Scanner sc = new Scanner(System.in);
        do {
            x = sc.nextInt();
            y = sc.nextInt();
        } while (isValid(x, y));
        board.getCell(x, y).setSymbol(player.getSymbol());
        return true;
    }

    /*public boolean undo(){

    }*/

    private boolean isValid(int x, int y){
        if(x >= 0 && x < board.getBoard().size() && y >= 0 && y < board.getBoard().get(0).size()){
            return true;
        }
        System.out.println("Wrong move. Try again.");
        return false;
    }

    public static class Builder {
        private Board board;
        private List<Player> players;
        private List<GameWinningStrategy> gameWinningStrategies;

        public Builder(){
            players = new ArrayList<>();
            gameWinningStrategies = new ArrayList<>();
        }

        public Builder withBoard(Board board) {
            this.board = board;
            return this;
        }

        public Builder addPlayer(Player player) {
            players.add(player);
            return this;
        }

        public Builder addPlayers(List<Player> players) {
            this.players.addAll(players);
            return this;
        }

        public Builder addGameWinningStrategy(GameWinningStrategy gameWinningStrategy) {
            gameWinningStrategies.add(gameWinningStrategy);
            return this;
        }

        public Builder addGameWinningStrategies(List<GameWinningStrategy> gameWinningStrategies) {
            this.gameWinningStrategies.addAll(gameWinningStrategies);
            return this;
        }

        public boolean isOneBotPerGame(){
            int count = 0;
            for (Player player : players){
                if(player.getPlayerType().equals(PlayerType.BOT)){
                    count++;
                }
            }
            return count < 2;
        }

        public Game build() throws MultiBotsException{
            if(!isOneBotPerGame()){
                throw new MultiBotsException();
            }
            Game game = new Game();
            game.board = board;
            game.players = players;
            game.gameWinningStrategies = gameWinningStrategies;
            return game;
        }
    }
}
