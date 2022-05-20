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

import academy.devonline.tictactoe.model_data.CellTable;
import academy.devonline.tictactoe.model_data.PlayingField;

/**
 * @author Dnpypy
 * @link https://www.udemy.com/course/java-junior-developer/
 */
public class CheckWinner {
    public boolean isUserWin(PlayingField playingField) {
        return isWin(playingField, 'X');
    }

    public boolean isAlWin(PlayingField playingField) {
        return isWin(playingField, 'O');
    }

    // checkingStatus
    private static boolean isWin(PlayingField playingField, char character) {
        if (isWinRow(playingField, character)) return true;
        if (isWinColumn(playingField, character)) return true;
        if (isWinMainDiagonal(playingField, character)) return true;
        return isWinSecondDiagonal(playingField, character);
    }

    private static boolean isWinMainDiagonal(PlayingField playingField, char character) {

        return playingField.checkGetSymbol(new CellTable(0, 0)) == playingField.checkGetSymbol(new CellTable(1, 1))
                && playingField.checkGetSymbol(new CellTable(1, 1)) == playingField.checkGetSymbol(new CellTable(2, 2))
                && playingField.checkGetSymbol(new CellTable(2, 2)) == character;
    }

    private static boolean isWinSecondDiagonal(PlayingField playingField, char character) {

        return playingField.checkGetSymbol(new CellTable(2, 0)) == playingField.checkGetSymbol(new CellTable(1, 1))
                && playingField.checkGetSymbol(new CellTable(1, 1)) == playingField.checkGetSymbol(new CellTable(0, 2))
                && playingField.checkGetSymbol(new CellTable(0, 2)) == character;
    }

    private static boolean isWinColumn(PlayingField playingField, char character) {
        for (int i = 0; i < 3; i++) {
            if (playingField.checkGetSymbol(new CellTable(0, i)) == playingField.checkGetSymbol(new CellTable(1, i))
                    && playingField.checkGetSymbol(new CellTable(1, i)) == playingField.checkGetSymbol(new CellTable(2, i))
                    && playingField.checkGetSymbol(new CellTable(2, i)) == character) {
                return true;
            }

        }
        return false;
    }


    private static boolean isWinRow(PlayingField playingField, char character) {
        for (int i = 0; i < 3; i++) {
            if (playingField.checkGetSymbol(new CellTable(i, 0)) == playingField.checkGetSymbol(new CellTable(i, 1))
                    && playingField.checkGetSymbol(new CellTable(i, 1)) == playingField.checkGetSymbol(new CellTable(i, 2))
                    && playingField.checkGetSymbol(new CellTable(i, 2)) == character) {
                return true;
            }

        }
        return false;
    }
}
