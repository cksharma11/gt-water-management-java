package org.geekheight.command.executor;

import org.geekheight.exception.InvalidCommandException;

import java.util.List;

public interface CommandExecutor {
    Object execute(List<String> args) throws InvalidCommandException;
}

