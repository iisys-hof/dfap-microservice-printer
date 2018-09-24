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

package websocket;

import printer.Constants;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@ServerEndpoint("/ws")
public class PrinterEndpoint {

    private static Set<Session> userSessions = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());

    @OnOpen
    public void onOpen(Session userSession) {
        System.out.println("Neue Verbindung aufgebaut...");
        userSessions.add(userSession);

    }

    @OnClose
    public void onClose(Session userSession) {
        System.out.println("Verbindung getrennt...");
        userSessions.remove(userSession);

    }

    @OnMessage
    public void onMessage(String message, Session userSession) {
        broadcast(message);

    }

    public static void broadcast(String msg) {
        for (Session session : userSessions) {
            System.out.println("Re: " + msg);
            System.out.println();
            session.getAsyncRemote().sendText(Constants.getPrinterInfos());
        }

    }
}
