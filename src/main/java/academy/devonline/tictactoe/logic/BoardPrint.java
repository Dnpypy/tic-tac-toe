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

import academy.devonline.tictactoe.model_data.PlayingField;

/**
 * @author Dnpypy
 */
public interface BoardPrint {

    /**
     * выводит информационное сообщение
     *
     * @param message хранит сообщение, которое нужно вывезти
     */
    void infoNoticePrint(String message);

    /**
     * Выводит сообщение об ошибке
     */
    void errorNoticePrint(String message);

    void showTablePrint();

    void currentStateField(final PlayingField playingField);
}
