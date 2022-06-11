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

package academy.devonline.tictactoe.component.console;

import academy.devonline.tictactoe.component.logic.BoardPrint;
import academy.devonline.tictactoe.component.logic.ConverterCell;
import academy.devonline.tictactoe.component.logic.InputReadUser;
import academy.devonline.tictactoe.model_data.CellTable;

import java.util.Scanner;

/**
 * @author Dnpypy
 */
public class ConsoleInputReadUser implements InputReadUser {

    private final ConverterCell converterCell;

    private final BoardPrint boardPrint;

    public ConsoleInputReadUser(final ConverterCell converterCell,
                                final BoardPrint boardPrint) {
        this.converterCell = converterCell;
        this.boardPrint = boardPrint;
    }

    @Override
    public CellTable userInputFromKeyboard() {
        while (true) {
            boardPrint.infoNoticePrint("Please type number between 1 and 9:");
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            if (s.length() == 1) {
                char ch = s.charAt(0);
                if (checkCharacter(ch)) {
                    return converterCell.numbTocell(ch);
                }
            }
        }
    }

    /**
     * проверка символа на диапазон с 0 до 9
     *
     * @param character символ
     * @return истину если символ входит в диапазон
     */
    public static boolean checkCharacter(char character) {
        char c = '0';
        while (c <= '9') {
            if (c == character) {
                return true;
            }
            c++;
        }
        return false;
    }
}
