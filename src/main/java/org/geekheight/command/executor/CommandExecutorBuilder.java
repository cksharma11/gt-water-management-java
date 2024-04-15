package org.geekheight.command.executor;

import org.geekheight.parser.CommandType;
import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;

public class CommandExecutorBuilder {
    private final WaterBillServiceBoundary waterBillService;

    public CommandExecutorBuilder(WaterBillServiceBoundary waterBillService) {
        this.waterBillService = waterBillService;
    }

    public CommandExecutor build(CommandType commandName) {
        return switch (commandName) {
            case ALLOT_WATER -> new AllotWaterCommandExecutor(waterBillService);
            case ADD_GUESTS -> new AddGuestCommandExecutor(waterBillService);
            case BILL -> new BillCommandExecutor(waterBillService);
        };
    }
}

