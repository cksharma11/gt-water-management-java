package org.geekheight.parser;

import java.util.List;

public class Command {
    private final CommandType command;
    private final List<String> args;

    public Command(CommandType command, List<String> args) {
        this.command = command;
        this.args = args;
    }

    public CommandType getCommand() {
        return command;
    }

    public List<String> getArgs() {
        return args;
    }
}