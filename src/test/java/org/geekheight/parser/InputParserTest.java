package org.geekheight.parser;

import static org.geekheight.utils.TestUtils.getResourcePath;
import static org.junit.jupiter.api.Assertions.*;

import org.geekheight.exception.InvalidCommandException;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Objects;

public class InputParserTest {

    @Test
    public void testParseInputFile1() throws InvalidCommandException, FileNotFoundException {
        List<Command> commands = InputParser.parseInput(getResourcePath("test-input-1"));

        assertEquals(4, commands.size());
        assertEquals(CommandType.ALLOT_WATER, commands.get(0).getCommand());
        assertEquals(CommandType.ADD_GUESTS, commands.get(1).getCommand());
        assertEquals(CommandType.ADD_GUESTS, commands.get(2).getCommand());
        assertEquals(CommandType.BILL, commands.get(3).getCommand());
    }

    @Test
    public void testParseInputFile3() throws InvalidCommandException, FileNotFoundException {
        List<Command> commands = InputParser.parseInput(getResourcePath("test-input-3"));

        assertEquals(2, commands.size());
        assertEquals(CommandType.ALLOT_WATER, commands.get(0).getCommand());
        assertEquals(CommandType.BILL, commands.get(1).getCommand());
    }

    @Test
    public void testParseInputWithInvalidCommand() {
        assertThrows(InvalidCommandException.class, () -> InputParser.parseInput(getResourcePath("test-input-invalid-command")));
    }
}
