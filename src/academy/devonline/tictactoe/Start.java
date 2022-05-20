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

package academy.devonline.tictactoe;


import academy.devonline.tictactoe.logic.BoardPrint;
import academy.devonline.tictactoe.logic.*;

/**
 * @author Dnpypy
 * @link https://www.udemy.com/course/java-junior-developer/
 */
public class Start {
    public static void main(String[] args) {
        final ConverterCell converterCell = new ConverterCell();

        TicTacToeGame ticTacToeGame = new TicTacToeGame(
                new BoardPrint(converterCell),
                new MoveAl(),
                new PlayerMove(converterCell),
                new CheckWinner(),
                new CellDraw());
        ticTacToeGame.tictactoePlay();

    }
}
