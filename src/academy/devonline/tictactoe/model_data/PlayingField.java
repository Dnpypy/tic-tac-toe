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

/**
 * @author Dnpypy
 * @link http://devonline.academy/java
 */
public class PlayingField {

//    private final char EMPTY = ' ';
//    private final char ZERO = 'O';
//    private final char CROSS = 'X';

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
     * @param character для записи
     */
    public void setTableSymbol(final CellTable cellTable, final Character character) {
        zeroCrossTable[cellTable.getRow()][cellTable.getCol()] = character;
    }
}
