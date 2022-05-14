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

import academy.devonline.tictactoe.model_data.PlayingField;

import java.util.Random;

/**
 * @author Dnpypy
 * @link http://devonline.academy/java
 */
public class TicTacToeGame {

    private final BoardPrint boardPrint;
    private final MoveAl moveAl;
    private final PlayerMove playerMove;
    private final CheckWinner checkWinner;
    private final CheckDraw checkDraw;

    public TicTacToeGame(final BoardPrint boardPrint,
                         final MoveAl moveAl,
                         final PlayerMove playerMove,
                         final CheckWinner checkWinner,
                         final CheckDraw checkDraw) {
        this.boardPrint = boardPrint;
        this.moveAl = moveAl;
        this.playerMove = playerMove;
        this.checkWinner = checkWinner;
        this.checkDraw = checkDraw;
    }


    public void tictactoePlay() {

        System.out.println("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        boardPrint.showTablePrint();
        Random random = new Random();

        final PlayingField playingField = new PlayingField();

        if (random.nextBoolean()) { // если первым ходит компьютер
            moveAl.toMove(playingField);
            boardPrint.currentStateField(playingField);
        }

        while (true) {
            playerMove.toMove(playingField);
            boardPrint.currentStateField(playingField);

            if (checkWinner.isUserWin(playingField)) {
                System.out.println("YOU WIN!");
                break;
            }

            if (checkDraw.isItDraw(playingField)) {
                System.out.println("SORRY DRAW!");
                break;
            }

            moveAl.toMove(playingField);
            boardPrint.currentStateField(playingField);

            if (checkWinner.isAlWin(playingField)) {
                System.out.println("COMPUTER WIN!");
                break;
            }

            if (checkDraw.isItDraw(playingField)) {
                System.out.println("SORRY DRAW!");
                break;
            }
        }
        System.out.println("GAME OVER!");


    }
}
