package org.geekheight.parser;

import java.util.List;

public record Command(CommandType command, List<String> args) {}

