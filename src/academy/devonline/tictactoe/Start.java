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

package academy.devonline.tictactoe;


import java.util.Random;

/**
 * @author Dnpypy
 * @link http://devonline.academy/java
 */
public class Start {
    public static void main(String[] args) {
        TicTacToeGame ticTacToeGame = new TicTacToeGame(
                new BoardPrint(),
                new MoveAl(),
                new PlayerMove(),
                new CheckWinner(),
                new CheckDraw());
        ticTacToeGame.tictactoePlay();

    }
}
