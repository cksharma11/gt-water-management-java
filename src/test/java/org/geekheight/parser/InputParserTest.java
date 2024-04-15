package org.geekheight.parser;

import static org.junit.jupiter.api.Assertions.*;

import org.geekheight.exception.InvalidCommandException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

public class InputParserTest {

    @Test
    public void testParseInputFile1() throws InvalidCommandException, FileNotFoundException {
        List<Command> commands = InputParser.parseInput("test-input-1");

        assertEquals(4, commands.size());
        assertEquals(CommandType.ALLOT_WATER, commands.get(0).command());
        assertEquals(CommandType.ADD_GUESTS, commands.get(1).command());
        assertEquals(CommandType.ADD_GUESTS, commands.get(2).command());
        assertEquals(CommandType.BILL, commands.get(3).command());
    }

    @Test
    public void testParseInputFile3() throws InvalidCommandException, FileNotFoundException {
        List<Command> commands = InputParser.parseInput("test-input-3");

        assertEquals(2, commands.size());
        assertEquals(CommandType.ALLOT_WATER, commands.get(0).command());
        assertEquals(CommandType.BILL, commands.get(1).command());
    }

    @Test
    public void testParseInputWithInvalidCommand() {
        assertThrows(InvalidCommandException.class, () -> InputParser.parseInput("test-input-invalid-command"));
    }

    @Test
    public void testParseInputInvalidCommand() {
        assertThrows(FileNotFoundException.class, () -> InputParser.parseInput("invalid-input-file"));
    }
}
