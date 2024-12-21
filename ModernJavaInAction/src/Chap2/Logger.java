package Chap2;

import java.util.function.Consumer;

public class Logger {
    private LogLevel currentLevel = LogLevel.INFO;

    public void setLogLevel(LogLevel level) {
        currentLevel = level;
    }

    public void log(LogLevel level, String message) {
        if (shouldLog(level)) {
            Consumer<String> logActionConsumer = getLogAction(level);
            logActionConsumer.accept(formatMessage(level, message));
        }
    }

    private boolean shouldLog(LogLevel level) {
        return level.ordinal() >= currentLevel.ordinal();
    }

    private Consumer<String> getLogAction(LogLevel level) {
        switch (level) {
            case ERROR:
            case FATAL:
                return System.err::println;
            case INFO:
            case WARN:
            default:
                return System.out::println;
        }
    }

    // Format the log message
    private String formatMessage(LogLevel level, String message) {
        return String.format("[%s] %s", level, message);
    }
}
