package org.geekheight.command.executor;

import static org.junit.jupiter.api.Assertions.*;

import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.*;

public class BillCommandExecutorTest {
    @Test
    public void testBillCommand() {
        WaterBillServiceBoundary waterBillManagerMock = Mockito.mock(WaterBillServiceBoundary.class);
        BillCommandExecutor billCommandExecutor = new BillCommandExecutor(waterBillManagerMock);

        when(waterBillManagerMock.bill()).thenReturn("2000 40000");
        String bill = billCommandExecutor.execute(List.of()).toString();

        assertEquals("2000 40000", bill);
    }
}
