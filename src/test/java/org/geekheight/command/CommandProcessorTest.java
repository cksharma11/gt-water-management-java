package org.geekheight.command;

import static org.junit.jupiter.api.Assertions.*;

import org.geekheight.command.executor.CommandExecutorBuilder;
import org.geekheight.config.Config;
import org.geekheight.exception.InvalidCommandException;
import org.geekheight.logger.ConsoleLogger;
import org.geekheight.logger.boundary.Logger;
import org.geekheight.parser.Command;
import org.geekheight.parser.InputParser;
import org.geekheight.water_bill.WaterBillService;
import org.geekheight.water_bill.boundary.WaterBillServiceBoundary;
import org.geekheight.water_bill.boundary.WaterRateCalculator;
import org.geekheight.water_bill.water_rate.FlatRateCalculator;
import org.geekheight.water_bill.water_rate.SlabRateCalculator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.*;

import static org.junit.jupiter.api.Assertions.*;

public class CommandProcessorTest {
    private CommandProcessor commandProcessor;

    @Test
    public void testWithTestFile1WithConsoleLogger() throws InvalidCommandException, FileNotFoundException {
        setUpForInput("test-input-1");
        String expectedOutput = "2400 5215";
        assertCommandProcessorOutput(expectedOutput);
    }

    @Test
    public void testWithTestFile2WithConsoleLogger() throws InvalidCommandException, FileNotFoundException {
        setUpForInput("test-input-2");
        String expectedOutput = "3000 5750";
        assertCommandProcessorOutput(expectedOutput);
    }

    @Test
    public void testWithTestFile3WithConsoleLogger() throws InvalidCommandException, FileNotFoundException {
        setUpForInput("test-input-3");
        String expectedOutput = "900 1200";
        assertCommandProcessorOutput(expectedOutput);
    }

    private void assertCommandProcessorOutput(String expectedOutput) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        PrintStream originalOut = System.out;
        System.setOut(printStream);

        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            Future<?> future = executor.submit(() -> {
                try {
                    commandProcessor.processCommands();
                } catch (InvalidCommandException e) {
                    throw new RuntimeException(e);
                }
            });
            future.get(5, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            fail("Timeout occurred: " + e.getMessage());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdownNow();
            System.setOut(originalOut);
        }

        String printedMessage = outputStream.toString().trim();
        assertEquals(expectedOutput, printedMessage);
    }

    private void setUpForInput(String inputFile) throws InvalidCommandException, FileNotFoundException {
        WaterRateCalculator corporateWaterRateCalculator = new FlatRateCalculator(Config.CORPORATE_WATER_RATE);
        WaterRateCalculator borewellWaterRateCalculator = new FlatRateCalculator(Config.BOREWELL_WATER_RATE);
        WaterRateCalculator tankerWaterRateCalculator = new SlabRateCalculator(Config.TANKER_WATER_SLAB_RATE);

        WaterBillServiceBoundary waterBillService = new WaterBillService(
                corporateWaterRateCalculator,
                borewellWaterRateCalculator,
                tankerWaterRateCalculator
        );

        Logger logger = new ConsoleLogger();
        CommandExecutorBuilder commandExecutor = new CommandExecutorBuilder(waterBillService);
        List<Command> commands = InputParser.parseInput(inputFile);
        commandProcessor = new CommandProcessor(commands, commandExecutor, logger);
    }
}
