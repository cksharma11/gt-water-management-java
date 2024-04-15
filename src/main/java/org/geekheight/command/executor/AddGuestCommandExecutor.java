package org.geekheight.command.executor;

import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;

import java.util.List;

public class AddGuestCommandExecutor implements CommandExecutor {
    private final WaterBillServiceBoundary waterBillService;

    public AddGuestCommandExecutor(WaterBillServiceBoundary waterBillService) {
        this.waterBillService = waterBillService;
    }

    @Override
    public Object execute(List<String> args) {
        int guestCount = Integer.parseInt(args.get(0));
        return waterBillService.addGuest(guestCount);
    }
}

