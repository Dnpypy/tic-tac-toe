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

import academy.devonline.tictactoe.model_data.PlayerXO;
import academy.devonline.tictactoe.model_data.PlayingField;

import java.util.Random;

/**
 * @author Dnpypy
 */
public class TicTacToeGame {

    private final BoardPrint boardPrint;

    private final PlayerXO player1;
    private final PlayerXO player2;
    private final CheckWinner checkWinner;
    private final CellDraw cellDraw;

    private final boolean moveSecondPlayer;

    public TicTacToeGame(BoardPrint boardPrint, PlayerXO player1, PlayerXO player2, CheckWinner checkWinner, CellDraw cellDraw, boolean moveSecondPlayer) {
        this.boardPrint = boardPrint;
        this.player1 = player1;
        this.player2 = player2;
        this.checkWinner = checkWinner;
        this.cellDraw = cellDraw;
        this.moveSecondPlayer = moveSecondPlayer;
    }

    public void tictactoePlay() {
        boardPrint.infoNoticePrint("Use the following mapping table to specify a cell using numbers from 1 to 9:");
        boardPrint.showTablePrint();
        Random random = new Random();

        final PlayingField playingField = new PlayingField();

        if (moveSecondPlayer && random.nextBoolean()) {
            player2.makeToMove(playingField);
            boardPrint.currentStateField(playingField);
        }

        final PlayerXO[] playerXO = {player1, player2};
        while (true) {
            for (PlayerXO player : playerXO) {
                player.makeToMove(playingField);
                boardPrint.currentStateField(playingField);

                if (checkWinner.isWin(playingField, player)) {
                    boardPrint.infoNoticePrint(player + " WIN!");
                    gameOver();
                    return;

                }

                if (cellDraw.CellFilled(playingField)) {
                    boardPrint.infoNoticePrint("SORRY DRAW!");
                    gameOver();
                    return;
                }

            }
        }
    }

    public void gameOver() {
        boardPrint.infoNoticePrint("GAME OVER!");
    }
}
