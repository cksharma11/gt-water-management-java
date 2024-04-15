package org.geekheight.parser;

import org.geekheight.exception.InvalidCommandException;
import org.geekheight.io.FileOperation;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class InputParser {
    public static List<Command> parseInput(String inputFilePath) throws InvalidCommandException, FileNotFoundException {
        String inputString = FileOperation.readFileAsString(inputFilePath);
        String[] inputLines = Objects.requireNonNull(inputString).split("\n");
        List<Command> commands = new ArrayList<>();
        for (String line : inputLines) {
            if (!line.isEmpty()) {
                commands.add(mapInput(line));
            }
        }
        return commands;
    }

    private static Command mapInput(String input) throws InvalidCommandException {
        String[] split = input.split(" ");
        String command = split[0];
        List<String> args = new ArrayList<>(Arrays.asList(split).subList(1, split.length));

        return switch (command) {
            case "ALLOT_WATER" -> new Command(CommandType.ALLOT_WATER, args);
            case "ADD_GUESTS" -> new Command(CommandType.ADD_GUESTS, args);
            case "BILL" -> new Command(CommandType.BILL, args);
            default -> throw new InvalidCommandException("Invalid command " + command);
        };
    }
}

