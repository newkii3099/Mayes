package com.newlab.mayes.launcher.util;

public final class RemoteConfigManager {
    private RemoteConfigManager() {}

    public static String getString(String key) {
        if ("discord".equalsIgnoreCase(key)) return Config.DISCORD_URL;
        if ("website".equalsIgnoreCase(key)) return Config.WEBSITE_URL;
        if ("youtube".equalsIgnoreCase(key)) return Config.YOUTUBE_URL;
        if ("players".equalsIgnoreCase(key)) return Config.PLAYERS_URL;
        return "";
    }
}
