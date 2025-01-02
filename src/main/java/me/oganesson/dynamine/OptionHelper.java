package me.oganesson.dynamine;

import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;

import java.util.Scanner;

public class OptionHelper {

    private static final Options OPTIONS = new Options();
    private static final Scanner SCANNER = new Scanner(System.in);

    public static Options options() {
        return OPTIONS;
    }

    public static void help() {
        new HelpFormatter().printHelp("dynamine", OPTIONS);
    }

    public static void version() {
        Main.LOGGER.info("%s-%s".formatted(Tags.NAME, Tags.VERSION));
    }

    public static void init(boolean hasArgs) {
        if (hasArgs) {

        } else {
            Main.LOGGER.info("Initializing modpack...");
            var name = askWithDefault("Enter the name of the modpack:", Main.ROOT_FILE.getName());
            
        }
    }

    private static String ask(String question) {
        Main.LOGGER.info(question);
        return SCANNER.nextLine();
    }

    private static String askWithDefault(String question, String defaultValue) {
        var answer = ask(question + "(Default: %s)".formatted(Main.ROOT_FILE.getName()));
        return answer.isEmpty() ? defaultValue : answer;
    }

    static {
        Option help = new Option("help", "print this message");
        Option version = new Option("version", "print the version information and exit");
        Option init = new Option("init", "modpack init");

        OPTIONS.addOption(help);
        OPTIONS.addOption(version);
        OPTIONS.addOption(init);
    }

}
