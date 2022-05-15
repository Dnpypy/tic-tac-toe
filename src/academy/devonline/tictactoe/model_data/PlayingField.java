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

package academy.devonline.tictactoe.model_data;

import java.util.Arrays;

/**
 * @author Dnpypy
 * @link http://devonline.academy/java
 */
public class PlayingField {

    private final char[][] zeroCrossTable = {
            {' ', ' ', ' '},
            {' ', ' ', ' '},
            {' ', ' ', ' '}
    };

    /**
     * проверка символа на пустоту
     *
     * @param cellTable символ ячейки таблицы класса CellTable
     * @return результат true or false
     */
    public boolean isCharWhitespace(final CellTable cellTable) {
        return zeroCrossTable[cellTable.getRow()][cellTable.getCol()] == ' ';
    }

    /**
     * Определяет какой символ записан в ячейке
     *
     * @param cellTable символ ячейки таблицы класса CellTable
     *                  return символ таблицы cellTable
     */
    public char checkGetSymbol(final CellTable cellTable) {
        return zeroCrossTable[cellTable.getRow()][cellTable.getCol()];
    }

    /**
     * Обновление ячейки новым значением
     *
     * @param cellTable ячейка для записи
     * @param character символ для записи
     */
    public void setTableSymbol(final CellTable cellTable, final Character character) {
        zeroCrossTable[cellTable.getRow()][cellTable.getCol()] = character;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PlayingField{");
        for (int i = 0; i < zeroCrossTable.length; i++) {
            sb.append(Arrays.toString(zeroCrossTable[i]));
            if (i < zeroCrossTable.length - 1) {
                sb.append(";");
            }
        }
        sb.append('}');
        return sb.toString();
    }

}
