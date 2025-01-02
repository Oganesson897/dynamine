package me.oganesson.dynamine.utils;

import com.moandjiezana.toml.Toml;
import com.moandjiezana.toml.TomlWriter;

import java.io.File;
import java.io.IOException;

public class TomlUtils {

    private static final Toml TOML = new Toml();
    private static final TomlWriter WRITER = new TomlWriter();

    public static Toml parseFile(File file) {
        return TOML.read(file);
    }

    public static void toFile(Object obj, File file) throws IOException {
        WRITER.write(obj, file);
    }

}
