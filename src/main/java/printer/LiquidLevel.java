/*
 * Copyright 2018 Thomas Winkler
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package printer;

public class LiquidLevel {
    private Integer inkLevel;
    private Integer makeUpLevel;

    public LiquidLevel(Integer inkLevel, Integer makeUpLevel) {
        this.inkLevel = inkLevel;
        this.makeUpLevel = makeUpLevel;
    }

    public Integer getInkLevel() {
        return inkLevel;
    }

    public void setInkLevel(Integer inkLevel) {
        this.inkLevel = inkLevel;
    }

    public Integer getMakeUpLevel() {
        return makeUpLevel;
    }

    public void setMakeUpLevel(Integer makeUpLevel) {
        this.makeUpLevel = makeUpLevel;
    }

    @Override
    public String toString() {
        return "LiquidLevel{" +
                "inkLevel=" + inkLevel +
                ", makeUpLevel=" + makeUpLevel +
                '}';
    }
}