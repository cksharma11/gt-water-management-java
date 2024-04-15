package org.geekheight.command;

import org.geekheight.command.executor.CommandExecutorBuilder;
import org.geekheight.exception.InvalidCommandException;
import org.geekheight.logger.boundary.Logger;
import org.geekheight.parser.Command;

import java.util.List;

public class CommandProcessor {
    private final List<Command> commands;
    private final CommandExecutorBuilder commandExecutor;
    private final Logger logger;

    public CommandProcessor(List<Command> commands, CommandExecutorBuilder commandExecutor, Logger logger) {
        this.commands = commands;
        this.commandExecutor = commandExecutor;
        this.logger = logger;
    }

    public void processCommands() throws InvalidCommandException {
        for (Command command : commands) {
            Object output = commandExecutor.build(command.getCommand()).execute(command.getArgs());
            if (output instanceof String) {
                logger.log((String) output);
            }
        }
    }
}

