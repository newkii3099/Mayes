package com.newlab.mayes.launcher.util;

import android.content.Context;
import java.io.File;

public final class GameStorage {
    private static final String PACKAGE_DIR = "com.newlab.mayes";
    private static final String SAMP_DIR = "SAMP";

    private GameStorage() {
    }

    public static File getGameBaseDirectory(Context context) {
        if (context != null) {
            File filesDir = context.getExternalFilesDir(null);
            if (filesDir != null) {
                if (!filesDir.exists()) {
                    filesDir.mkdirs();
                }
                return filesDir;
            }
        }
        File standardDir = new File("/storage/emulated/0/Android/data/" + PACKAGE_DIR + "/files");
        if (!standardDir.exists()) {
            standardDir.mkdirs();
        }
        return standardDir;
    }

    public static String getGameBasePath(Context context) {
        return withTrailingSlash(getGameBaseDirectory(context).getAbsolutePath());
    }

    public static File getSampDirectory(Context context) {
        File sampDir = new File(getGameBaseDirectory(context), SAMP_DIR);
        if (!sampDir.exists()) {
            sampDir.mkdirs();
        }
        return sampDir;
    }

    public static File getSettingsFile(Context context) {
        return new File(getSampDirectory(context), "settings.ini");
    }

    public static File getDownloadDirectory(Context context) {
        File downloadDir = new File(getGameBaseDirectory(context), "download");
        if (!downloadDir.exists()) {
            downloadDir.mkdirs();
        }
        return downloadDir;
    }

    private static String withTrailingSlash(String path) {
        return path.endsWith("/") ? path : path + "/";
    }
}
