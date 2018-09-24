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

var conn;

function connect() {
    conn = new WebSocket("wss://localhost:8443/dfap-printer/echo");
    conn.onmessage = (msg) => {
        let cValue = document.getElementById("out").value;
        document.getElementById("out").value = cValue + msg.data + "\n";
    }
    document.getElementById("connect").setAttribute("disabled", "disabled");
    document.getElementById("disconnect").removeAttribute("disabled");
}

function disconnect() {
    conn.close();
    document.getElementById("out").value = "";
    document.getElementById("disconnect").setAttribute("disabled", "disabled");
    document.getElementById("connect").removeAttribute("disabled");
}

function sendMessage() {
    conn.send(document.getElementById("msg").value);
}