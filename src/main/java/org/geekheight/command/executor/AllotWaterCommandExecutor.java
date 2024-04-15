package org.geekheight.command.executor;

import org.geekheight.apartment.ApartmentType;
import org.geekheight.exception.InvalidCommandException;
import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;
import org.geekheight.water_bill.dto.WaterRatio;

import java.util.List;

public class AllotWaterCommandExecutor implements CommandExecutor {
    private final WaterBillServiceBoundary waterBillService;

    public AllotWaterCommandExecutor(WaterBillServiceBoundary waterBillService) {
        this.waterBillService = waterBillService;
    }

    @Override
    public Object execute(List<String> args) throws InvalidCommandException {
        int apartmentTypeInput = Integer.parseInt(args.get(0));
        String[] ratioSplit = args.get(1).split(":");
        int corporateWaterRatio = Integer.parseInt(ratioSplit[0]);
        int borewellWaterRatio = Integer.parseInt(ratioSplit[1]);

        ApartmentType apartmentType;

        switch (apartmentTypeInput) {
            case 2:
                apartmentType = ApartmentType.TWO_BHK;
                break;
            case 3:
                apartmentType = ApartmentType.THREE_BHK;
                break;
            default:
                throw new InvalidCommandException("Apartment type is invalid");
        }

        WaterRatio ratio = new WaterRatio(corporateWaterRatio, borewellWaterRatio);
        return waterBillService.allotWater(apartmentType, ratio);
    }
}

