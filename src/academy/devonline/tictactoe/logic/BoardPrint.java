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

import academy.devonline.tictactoe.logic.keypad.NumKeyCellNumbConvertDesktop;
import academy.devonline.tictactoe.model_data.CellTable;
import academy.devonline.tictactoe.model_data.PlayingField;

/**
 * @author Dnpypy
 * @link https://www.udemy.com/course/java-junior-developer/
 */
public class BoardPrint {

    private final ConverterCell converterCell;

    public BoardPrint(ConverterCell converterCell) {
        this.converterCell = converterCell;
    }


    public void showTablePrint() {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + converterCell.cellToNumb(new CellTable(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    public void currentStateField(final PlayingField playingField) {

        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + playingField.checkGetSymbol(new CellTable(i, j)) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");

    }
}
