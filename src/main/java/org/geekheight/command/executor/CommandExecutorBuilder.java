package org.geekheight.command.executor;

import org.geekheight.exception.InvalidCommandException;
import org.geekheight.parser.CommandType;
import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;

public class CommandExecutorBuilder {
    private final WaterBillServiceBoundary waterBillService;

    public CommandExecutorBuilder(WaterBillServiceBoundary waterBillService) {
        this.waterBillService = waterBillService;
    }

    public CommandExecutor build(CommandType commandName) throws InvalidCommandException {
        switch (commandName) {
            case ALLOT_WATER:
                return new AllotWaterCommandExecutor(waterBillService);
            case ADD_GUESTS:
                return new AddGuestCommandExecutor(waterBillService);
            case BILL:
                return new BillCommandExecutor(waterBillService);
            default:
                throw new InvalidCommandException("Invalid command provided");
        }
    }
}

