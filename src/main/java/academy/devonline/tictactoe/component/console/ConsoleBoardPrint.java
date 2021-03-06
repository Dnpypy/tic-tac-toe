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
import academy.devonline.tictactoe.model_data.CellTable;
import academy.devonline.tictactoe.model_data.PlayingField;

/**
 * @author Dnpypy
 */
public class ConsoleBoardPrint implements BoardPrint {


    private final ConverterCell converterCell;

    public ConsoleBoardPrint(ConverterCell converterCell) {
        this.converterCell = converterCell;
    }

    @Override
    public void infoNoticePrint(String message) {
        System.out.println(message);
    }

    @Override
    public void errorNoticePrint(String message) {
        System.err.println(message);
    }

    @Override
    public void showTablePrint() {
        show((i, j) -> String.valueOf(converterCell.cellToNumb(new CellTable(i, j))));
    }

    @Override
    public void currentStateField(PlayingField playingField) {
        show((i, j) -> String.valueOf(playingField.checkGetSymbol(new CellTable(i, j))));
    }

    private void show(final Lambda lambda) {
        for (int i = 0; i < 3; i++) {
            System.out.println("-------------");
            for (int j = 0; j < 3; j++) {
                System.out.print("| " + lambda.getValue(i, j) + " ");
            }
            System.out.println("|");
        }
        System.out.println("-------------");
    }

    @FunctionalInterface
    private interface Lambda {
        String getValue(int i, int j);
    }
}
