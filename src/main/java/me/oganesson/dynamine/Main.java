package me.oganesson.dynamine;

import me.oganesson.dynamine.modpack.PackInfo;
import org.apache.commons.cli.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;

public class Main {

    public static final Logger LOGGER = LogManager.getLogger("Dynamine");

    public static final File ROOT_FILE = new File(System.getProperty("user.dir"));
    public static final File RUN_DIR = new File(ROOT_FILE, "run");

    private static final Options OPTIONS = OptionHelper.options();

    public static PackInfo info;

    public static void main(String[] args) {
        if (!RUN_DIR.exists()) RUN_DIR.mkdirs();
        if (args.length == 0) {
            OptionHelper.help();
        }

        LOGGER.info("Starting Dynamine...");
        var packInfo = PackInfo.check(ROOT_FILE);
        if (packInfo != null) {
            LOGGER.info("Pack info detected");
            info = packInfo;
        }

        try {
            CommandLine cmd = new DefaultParser().parse(OPTIONS, args);

            if (cmd.hasOption("help")) {
                OptionHelper.help();
            }
            if (cmd.hasOption("version")) {
                OptionHelper.version();
                return;
            }
            if (cmd.hasOption("init")) {
            }
        } catch (ParseException e) {
            LOGGER.warn("Failed to parse command line arguments: ", e);
        }
    }
}
