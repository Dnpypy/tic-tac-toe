/*
 * Copyright (c) 2019.  https://www.udemy.com/course/java-junior-developer/
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package academy.devonline.tictactoe.logic;

import academy.devonline.tictactoe.logic.keypad.NumKeyCellNumbConvertDesktop;
import academy.devonline.tictactoe.model_data.PlayerXO;
import academy.devonline.tictactoe.model_data.TypeStepPlayer;

import static academy.devonline.tictactoe.model_data.Transfers.O;
import static academy.devonline.tictactoe.model_data.Transfers.X;
import static academy.devonline.tictactoe.model_data.TypeStepPlayer.COMPUTER;
import static academy.devonline.tictactoe.model_data.TypeStepPlayer.USER;

/**
 * @author Dnpypy
 */
public class FactoryCreateGame {

    private final TypeStepPlayer playerType1;

    private final TypeStepPlayer playerType2;


    /**
     * конструктор считывает аргументы командной строки и
     * определяет, кто должен играть в качестве первого игрока пользователь или компьютер
     *
     * @param args аргументы командной строки
     */
    public FactoryCreateGame(final String[] args) {
        TypeStepPlayer playerType1 = null;
        TypeStepPlayer playerType2 = null;
        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = TypeStepPlayer.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = TypeStepPlayer.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            } else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }
        if (playerType1 == null) {
            this.playerType1 = USER;
            this.playerType2 = COMPUTER;
        } else if (playerType2 == null) {
            this.playerType1 = USER;
            this.playerType2 = playerType1;
        } else {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
        }
    }

    /**
     * метод который создает игру
     */
    public TicTacToeGame gameCreate() {
        final ConverterCell converterCell = new NumKeyCellNumbConvertDesktop();
        final PlayerXO player1;
        if (playerType1 == USER) {
            player1 = new PlayerXO(X, new PlayerMove(converterCell));
        } else {
            player1 = new PlayerXO(X, new MoveAl());
        }

        final PlayerXO player2;
        if (playerType2 == USER) {
            player2 = new PlayerXO(O, new PlayerMove(converterCell));
        } else {
            player2 = new PlayerXO(O, new MoveAl());
        }
        final boolean moveSecondPlayer = playerType1 != playerType2;
        return new TicTacToeGame(
                new BoardPrint(converterCell),
                player1,
                player2,
                new CheckWinner(),
                new CellDraw(),
                moveSecondPlayer
        );

    }
}
