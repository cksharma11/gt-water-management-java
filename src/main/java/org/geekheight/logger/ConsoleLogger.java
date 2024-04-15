package org.geekheight.logger;

import org.geekheight.logger.boundary.Logger;

public class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        System.out.println(message);
    }
}
