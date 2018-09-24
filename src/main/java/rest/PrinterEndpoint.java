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

package rest;


import daos.machine.JPAMachineDao;
import entities.Machine;
import org.slf4j.Logger;
import printer.Constants;
import utils.XLogger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("")
@RequestScoped
public class PrinterEndpoint {

    @Inject
    @XLogger
    private Logger logger;

    @Inject
    JPAMachineDao machineDao;

    @Path("api/printers")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPrinters() {
        return Constants.printers;
    }

    @POST
    @Path("api/printers/{printerName}/labels/{labelSlot}")
    public void setActivePrinter(@PathParam("printerName") String printerName, @PathParam("labelSlot") String labelSlot) {
        System.out.println("PrinterEndpoint.setActivePrinter");
        System.out.println("printerName = [" + printerName + "], labelSlot = [" + labelSlot + "]");
    }

    @POST
    @Path("api/printers/{printerName}/remotebuffer")
    public void setRemoteBuffer(@PathParam("printerName") String printerName, String data) {
        System.out.println("PrinterEndpoint.setRemoteBuffer");
        System.out.println("printerName = [" + printerName + "], data = [" + data + "]");
    }

    @PUT
    @Path("machine/{machineId}")
    public void updatePrinterAtMachine(@PathParam("machineId") Long machineId, String ipAddress) {
        logger.debug("PrinterEndpoint.updatePrinterAtMachine");
        logger.debug("machineId = [" + machineId + "], ipAddress = [" + ipAddress + "]");

        if (ipAddress.length() == 0) {
            ipAddress = null;
        }
        Machine m = machineDao.findMachineForId(machineId);
        machineDao.update(m, ipAddress);
    }
}
