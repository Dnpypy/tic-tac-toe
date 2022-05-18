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

import java.util.Scanner;

/**
 * @author Dnpypy
 * @link http://devonline.academy/java
 */
public class PlayerMove {

    /**
     * вспомогательное поле
     */
    private final char[][] auxiliaryField = {
            {'7', '8', '9'},
            {'4', '5', '6'},
            {'1', '2', '3'}
    };

    /**
     * выполняет ход пользователя
     * проверяет пустая ли ячейка, если пустая, то ставлю в нее кректик 'X'
     *
     * @param playingField игровое поле
     */
    public void toMove(PlayingField playingField) {

        while (true) {
            final CellTable cellSymbol = userInputFromKeyboard();
            if (playingField.isCharWhitespace(cellSymbol)) {
                playingField.setTableSymbol(cellSymbol, 'X');
                return;
            } else {
                System.out.println("Can't make a move, because the cell is not free! Try again!");
            }
        }
    }

    /**
     * проверка символа на диапазон с 0 до 9
     *
     * @param character символ
     * @return истину если символ входит в диапазон
     */
    public static boolean testCh(char character) {
        char c = '0';
        while (c <= '9') {
            if (c == character) {
                return true;
            }
            c++;
        }
        return false;
    }

    /**
     * пользователь вводит с клавиатуры цифру с 1 до 9
     * из строки беру 1 символ и проверяю на диапазон
     *
     * @return объект ячейки (символ char)
     */
    private CellTable userInputFromKeyboard() {
        while (true) {
            System.out.println("Please type number between 1 and 9:");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (s.length() == 1) {
                char ch = s.charAt(0);
                if (testCh(ch)) {
                    for (int i = 0; i < auxiliaryField.length; i++) {
                        for (int j = 0; j < auxiliaryField[0].length; j++) {
                            if (auxiliaryField[i][j] == ch) {
                                return new CellTable(i, j);
                            }
                        }
                    }
                }
            }
        }

    }

}