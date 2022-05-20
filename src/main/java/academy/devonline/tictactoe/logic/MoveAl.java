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

import java.util.Random;

/**
 * @author Dnpypy
 * @link https://www.udemy.com/course/java-junior-developer/
 */

public class MoveAl {


    /**
     * Случайный ход компьютера и проверка на пустую ячейку
     * Если пустая ячейка, записываю в ячейку символ 'O'
     *
     * @param playingField объект игровое поле
     *                     Если игровое поле заполнено то выход из цикла
     */

    public void toMove(PlayingField playingField) {
        final Random random = new Random();

        while (true) {
            final int row = random.nextInt(3);
            final int col = random.nextInt(3);
            final CellTable randomCellTable = new CellTable(row, col);

            if (playingField.isCharWhitespace(randomCellTable)) {
                playingField.setTableSymbol(randomCellTable, 'O');
                return;
            }
        }
    }
}
