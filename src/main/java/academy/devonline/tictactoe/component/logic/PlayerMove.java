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

package academy.devonline.tictactoe.component.logic;

import academy.devonline.tictactoe.model_data.CellTable;
import academy.devonline.tictactoe.model_data.PlayingField;
import academy.devonline.tictactoe.model_data.Transfers;

/**
 * @author Dnpypy
 */
public class PlayerMove implements MoveOn {

    private final InputReadUser inputReadUser;

    private final BoardPrint boardPrint;


    public PlayerMove(final InputReadUser inputReadUser,
                      final BoardPrint boardPrint) {
        this.inputReadUser = inputReadUser;
        this.boardPrint = boardPrint;
    }

    /**
     * выполняет ход пользователя
     * проверяет пустая ли ячейка, если пустая, то ставлю в нее кректик 'X'
     *
     * @param playingField игровое поле
     */
    @Override
    public void toMove(final PlayingField playingField, final Transfers transfers) {

        while (true) {
            //final CellTable cellSymbol = userInputFromKeyboard();
            final CellTable cellSymbol = inputReadUser.userInputFromKeyboard();
            if (playingField.isCharWhitespace(cellSymbol)) {
                playingField.setTableSymbol(cellSymbol, transfers);
                return;
            } else {
                boardPrint.errorNoticePrint("Can't make a move, because the cell is not free! Try again!");
            }
        }
    }
}
