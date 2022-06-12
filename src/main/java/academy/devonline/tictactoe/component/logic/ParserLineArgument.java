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

package academy.devonline.tictactoe.component.logic;

import academy.devonline.tictactoe.model_data.InterfUser;
import academy.devonline.tictactoe.model_data.TypeStepPlayer;

import static academy.devonline.tictactoe.model_data.InterfUser.CONSOLE;
import static academy.devonline.tictactoe.model_data.InterfUser.GUI;
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
    public CommandLineStepPLayer parsing() {
        TypeStepPlayer playerType1 = null;
        TypeStepPlayer playerType2 = null;
        InterfUser interfUser = null;

        for (String arg : args) {
            if (USER.name().equalsIgnoreCase(arg) || COMPUTER.name().equalsIgnoreCase(arg)) {
                if (playerType1 == null) {
                    playerType1 = TypeStepPlayer.valueOf(arg.toUpperCase());
                } else if (playerType2 == null) {
                    playerType2 = TypeStepPlayer.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            } else if (GUI.name().equalsIgnoreCase(arg) || CONSOLE.name().equalsIgnoreCase(arg)) {
                if (interfUser == null) {
                    interfUser = InterfUser.valueOf(arg.toUpperCase());
                } else {
                    System.err.println("Unsupported command line argument: '" + arg + "'");
                }
            }else {
                System.err.println("Unsupported command line argument: '" + arg + "'");
            }
        }

        if(interfUser == null) {
            interfUser = CONSOLE;
        }

        if (playerType1 == null) {
            return new CommandLineStepPLayer(USER, COMPUTER, interfUser);
        } else if (playerType2 == null) {
            return new CommandLineStepPLayer(USER, playerType1, interfUser);
        } else {
            return new CommandLineStepPLayer(playerType1, playerType2, interfUser);
        }
    }

    /**
     * класс нужен в момент вызове в конструкторе класса FactoryCreateGame
     */
    public static class CommandLineStepPLayer {
        private final TypeStepPlayer playerType1;

        private final TypeStepPlayer playerType2;

        private final InterfUser interfUser;

        private CommandLineStepPLayer(final TypeStepPlayer playerType1,
                                      final TypeStepPlayer playerType2,
                                      final InterfUser interfUser) {
            this.playerType1 = playerType1;
            this.playerType2 = playerType2;
            this.interfUser = interfUser;
        }

        public TypeStepPlayer getPlayerType1() {
            return playerType1;
        }

        public TypeStepPlayer getPlayerType2() {
            return playerType2;
        }

        public InterfUser getInterfUser() {
            return interfUser;
        }
    }
}
