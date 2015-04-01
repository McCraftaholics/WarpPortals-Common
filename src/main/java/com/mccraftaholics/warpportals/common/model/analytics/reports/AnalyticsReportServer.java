package com.mccraftaholics.warpportals.common.model.analytics.reports;

import java.util.List;
import java.util.UUID;

public class AnalyticsReportServer {
    public String serverName;
    public String timestamp;

    public String warpPortalsVersion;

    public List<InstalledPlugin> installedPlugins;
    public int maxPlayers;
    public String bukkitVersion;
    public int numWorlds;

    public List<UUID> activePortals;

    public static class InstalledPlugin {
        public String name;
        public String version;

        public InstalledPlugin(String name, String version) {
            this.name = name;
            this.version = version;
        }

        public InstalledPlugin() {

        }
    }
}
