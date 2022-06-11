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

package academy.devonline.tictactoe.model_data;

import academy.devonline.tictactoe.component.logic.MoveOn;

/**
 * @author Dnpypy
 */
public final class PlayerXO {

    /**
     * Назначения класса PlayerXorO объединить два параметра
     * transfers символ, который будет использоваться
     * moveOn пользователь или компьютер(алгоритм хода)
     */
    private final Transfers transfers;

    private final MoveOn moveOn;

    public PlayerXO(final Transfers transfers,
                    final MoveOn moveOn) {
        this.transfers = transfers;
        this.moveOn = moveOn;
    }

    public Transfers getTransfers() {
        return transfers;
    }

    public void makeToMove(final PlayingField playingField) {
        moveOn.toMove(playingField, transfers);
    }

    @Override
    public String toString() {
        return "'" + transfers + "'";
    }


}
