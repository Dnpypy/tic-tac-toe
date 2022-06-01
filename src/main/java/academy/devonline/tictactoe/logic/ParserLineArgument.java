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

import academy.devonline.tictactoe.model_data.TypeStepPlayer;

import static academy.devonline.tictactoe.model_data.TypeStepPlayer.COMPUTER;
import static academy.devonline.tictactoe.model_data.TypeStepPlayer.USER;

/**
 * @author Dnpypy
 */

public class ParserLineArgument {

    private final String[] args;

    public ParserLineArgument(String[] args) {
        this.args = args;
    }

    /**
     * парсит аргументы args и возвращает два объекта класса TypePlayers
     */
    public TypePlayers parsing() {
        TypeStepPlayer playerType1 = null;
        TypeStepPlayer playerType2 = null;
        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = TypeStepPlayer.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = TypeStepPlayer.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            } else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }
        if (playerType1 == null) {
            return new TypePlayers(USER, COMPUTER);
        } else if (playerType2 == null) {
            return new TypePlayers(USER, playerType1);
        } else {
            return new TypePlayers(playerType1, playerType2);
        }
    }

    /**
     * класс нужен в момент вызове в конструкторе класса FactoryCreateGame
     */
    public static class TypePlayers {
        private final TypeStepPlayer playerType1;

        private final TypeStepPlayer playerType2;

        private TypePlayers(final TypeStepPlayer playerType1, final TypeStepPlayer playerType2) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
        }

        public TypeStepPlayer getPlayerType1() {
            return playerType1;
        }

        public TypeStepPlayer getPlayerType2() {
            return playerType2;
        }
    }
}
