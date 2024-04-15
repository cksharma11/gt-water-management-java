package org.geekheight;

import org.geekheight.command.CommandProcessor;
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

import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InvalidCommandException, FileNotFoundException {
        String inputFile = args[0];
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
        CommandProcessor commandProcessor = new CommandProcessor(commands, commandExecutor, logger);

        commandProcessor.processCommands();
    }
}
