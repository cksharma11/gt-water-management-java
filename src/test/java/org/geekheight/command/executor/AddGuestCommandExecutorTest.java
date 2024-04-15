package org.geekheight.command.executor;

import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class AddGuestCommandExecutorTest {
    @Test
    public void testAddGuestCommand() {
        WaterBillServiceBoundary waterBillManagerMock = Mockito.mock(WaterBillServiceBoundary.class);
        AddGuestCommandExecutor addGuestCommandExecutor = new AddGuestCommandExecutor(waterBillManagerMock);

        when(waterBillManagerMock.addGuest(anyInt())).thenReturn(new Object());
        addGuestCommandExecutor.execute(List.of("5"));

        Mockito.verify(waterBillManagerMock).addGuest(5);
    }
}