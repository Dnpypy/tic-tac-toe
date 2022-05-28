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
import academy.devonline.tictactoe.model_data.PlayerXO;
import academy.devonline.tictactoe.model_data.TypeStepPlayer;

import static academy.devonline.tictactoe.model_data.Transfers.O;
import static academy.devonline.tictactoe.model_data.Transfers.X;

/**
 * @author Dnpypy
 */
public class FactoryCreateGame {

    private TypeStepPlayer player1;

    private TypeStepPlayer player2;


    /**
     * конструктор считывает аргументы командной строки и
     * определяет, кто должен играть в качестве первого игрока пользователь или компьютер
     *
     * @param args аргументы командной строки
     */
    public FactoryCreateGame(final String[] args) {
//        for (String arg : args) {
//            if(arg.equals( TypeStepPlayer.USER)){
//                player1 = TypeStepPlayer.USER;
//            } else if(arg.equals(TypeStepPlayer.COMPUTER)){
//                player2 = TypeStepPlayer.COMPUTER;
//            }
//        }
    }

    /**
     * метод который создает игру
     */
    public TicTacToeGame gameCreate() {
        final ConverterCell converterCell = new NumKeyCellNumbConvertDesktop();

        return new TicTacToeGame(
                new BoardPrint(converterCell),
//                player1 != null ?  new PlayerXO(X, new PlayerMove(converterCell)) : new PlayerXO(O, new MoveAl());
                new PlayerXO(X, new PlayerMove(converterCell)),
                new PlayerXO(O, new MoveAl()),
                new CheckWinner(),
                new CellDraw(),
                true);

    }
}
