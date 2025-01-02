package me.oganesson.dynamine.modpack;

import me.oganesson.dynamine.modpack.platform.PlatformInfo;
import me.oganesson.dynamine.utils.TomlUtils;
import org.jetbrains.annotations.Nullable;

import java.io.File;

public record PackInfo(
        String name,
        String version,
        String authors,
        PlatformInfo platformInfo
) {

    @Nullable
    public static PackInfo check(File rootDir) {
        var config = new File(rootDir, "pack.toml");
        if (config.isFile()) {
            return PackInfo.load(config);
        } else {
            return null;
        }
    }

    public static PackInfo load(File file) {
        return TomlUtils.parseFile(file).to(PackInfo.class);
    }

}
