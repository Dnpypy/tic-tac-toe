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


import academy.devonline.tictactoe.logic.*;
import academy.devonline.tictactoe.logic.keypad.NumKeyCellNumbConvertDesktop;
import academy.devonline.tictactoe.model_data.PlayerXO;

import static academy.devonline.tictactoe.model_data.Transfers.O;
import static academy.devonline.tictactoe.model_data.Transfers.X;

/**
 * @author Dnpypy
 */
public class Start {
    public static void main(String[] args) {
        final ConverterCell converterCell = new NumKeyCellNumbConvertDesktop();

        TicTacToeGame ticTacToeGame = new TicTacToeGame(
                new BoardPrint(converterCell),
                new PlayerXO(X, new PlayerMove(converterCell)),
                new PlayerXO(O, new MoveAl()),
                new CheckWinner(),
                new CellDraw(),
                false);
        ticTacToeGame.tictactoePlay();

    }
}
