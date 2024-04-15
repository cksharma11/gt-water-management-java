package org.geekheight.command.executor;

import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;

import java.util.List;

public class BillCommandExecutor implements CommandExecutor {
    private final WaterBillServiceBoundary waterBillService;

    public BillCommandExecutor(WaterBillServiceBoundary waterBillService) {
        this.waterBillService = waterBillService;
    }

    @Override
    public Object execute(List<String> args) {
        return waterBillService.bill();
    }
}

