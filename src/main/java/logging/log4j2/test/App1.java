package logging.log4j2.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App1 {

    private static Logger logger = LogManager.getLogger(App1.class);

    public static void main(String[] args) {
        logger.debug("Debug log message");
        logger.info("Info log message");
        logger.error("Error log message");

    }
}
