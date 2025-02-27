package org.etix.adapters.utils;

import java.io.File;

public class FileManager {

    private static String buildPath(String... parts) {
        return String.join(File.separator, parts);
    }

    boolean isWindowsOs() {
        return System.getProperty("os.name").contains("Win");
    }

    private String getBaseDir() {
        return this.isWindowsOs() ? buildPath(Constant.CHEMIN_BASE_DIR_WIN.split(",")) : buildPath(Constant.CHEMIN_BASE_DIR.split(","));
    }

    private File getFile(String filePath) {
        String path = buildPath(getBaseDir(), filePath);
        path = !this.isWindowsOs() ? path.replaceAll("\\\\", File.separator) : path.replaceAll("/", File.separator);
        return new File(path);
    }

}
