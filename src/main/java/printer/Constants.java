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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Date;
import java.util.Random;

public class Constants {

    public static String s1 = "{\"time\":\"2018-06-14T08:48:43.6986503+02:00\",\"liquidLevel\":{\"inkLevel\":0,\"makeUpLevel\":0},\"prints\":100,\"ledState\":\"GREEN\",\"stateInfo\":\"JET_OFF_NO_ERROR\",\"state\":\"STATE_NO_ALERT\"}";


    public static String getPrinterInfos() {
        Random r = new Random();
        PrinterData d = new PrinterData(new Date(),new LiquidLevel(r.nextInt(100),r.nextInt(100)),r.nextInt(1000),"ledState","StateInfo", "State");

        ObjectMapper objectMapper = new ObjectMapper();
        String s = "";
        try {
            s = objectMapper.writeValueAsString(d);
            System.out.println(s);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return s;
    }

    public static String printers = "{\"result\":[{\"name\":\"Printer 1\",\"ip\":\"192.168.173.2\",\"port\":7000},{\"name\":\"Printer 2\",\"ip\":\"192.168.173.3\",\"port\":7000}],\"error\":\"\"}";
}