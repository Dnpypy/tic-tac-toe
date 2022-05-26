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

package academy.devonline.tictactoe.logic.keypad;

import academy.devonline.tictactoe.logic.ConverterCell;
import academy.devonline.tictactoe.model_data.CellTable;

/**
 * @author Dnpypy
 */
public class CellNumKeyTerminal implements ConverterCell {

    /**
     * вспомогательное поле
     */
    private final char[][] auxiliaryField = {
            {'1', '2', '3'},
            {'4', '5', '6'},
            {'7', '8', '9'}
    };

    /**
     * Преобразовывает число в ячейку
     *
     * @param numb число
     * @return null или ячейку
     */
    @Override
    public CellTable numbTocell(final char numb) {
        final int val = numb - '0' - 1;
        return new CellTable(val / 3, val % 3);
    }

    /**
     * Преобразования ячейку в число
     *
     * @param cellTable ячейка
     *                  return число
     */
    @Override
    public char cellToNumb(final CellTable cellTable) {
        return (char) ('0' + (cellTable.getRow() * 3 + cellTable.getCol() + 1));
    }
}
