package org.geekheight.command.executor;

import static org.junit.jupiter.api.Assertions.*;

import org.geekheight.apartment.ApartmentType;
import org.geekheight.exception.InvalidCommandException;
import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;
import org.geekheight.water_bill.dto.WaterRatio;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class AllotWaterCommandExecutorTest {
    @Test
    public void testAllotWaterCommand() throws InvalidCommandException {
        WaterBillServiceBoundary waterBillManagerMock = Mockito.mock(WaterBillServiceBoundary.class);
        AllotWaterCommandExecutor allotWaterCommandExecutor = new AllotWaterCommandExecutor(waterBillManagerMock);

        when(waterBillManagerMock.allotWater(ApartmentType.TWO_BHK, new WaterRatio(3, 7)))
                .thenReturn(new Object());
        allotWaterCommandExecutor.execute(List.of("2", "3:7"));

        verify(waterBillManagerMock).allotWater(ApartmentType.TWO_BHK, new WaterRatio(3, 7));
    }

    @Test
    public void testAllotWaterCommandInvalidApartmentType() {
        WaterBillServiceBoundary waterBillManagerMock = Mockito.mock(WaterBillServiceBoundary.class);
        AllotWaterCommandExecutor addGuestCommandExecutor = new AllotWaterCommandExecutor(waterBillManagerMock);

        assertThrows(InvalidCommandException.class, () -> addGuestCommandExecutor.execute(List.of("4", "3:7")));
    }
}
