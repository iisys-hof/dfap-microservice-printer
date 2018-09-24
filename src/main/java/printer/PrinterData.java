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

import java.util.Date;

public class PrinterData {
    private Date time;
    private LiquidLevel liquidLevel;
    private Integer prints;
    private String ledState;
    private String stateInfo;
    private String state;

    public PrinterData(Date time, LiquidLevel liquidLevel, Integer prints, String ledState, String stateInfo, String state) {
        this.time = time;
        this.liquidLevel = liquidLevel;
        this.prints = prints;
        this.ledState = ledState;
        this.stateInfo = stateInfo;
        this.state = state;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public LiquidLevel getLiquidLevel() {
        return liquidLevel;
    }

    public void setLiquidLevel(LiquidLevel liquidLevel) {
        this.liquidLevel = liquidLevel;
    }

    public Integer getPrints() {
        return prints;
    }

    public void setPrints(Integer prints) {
        this.prints = prints;
    }

    public String getLedState() {
        return ledState;
    }

    public void setLedState(String ledState) {
        this.ledState = ledState;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "PrinterData{" +
                "time=" + time +
                ", liquidLevel=" + liquidLevel +
                ", prints=" + prints +
                ", ledState='" + ledState + '\'' +
                ", stateInfo='" + stateInfo + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

