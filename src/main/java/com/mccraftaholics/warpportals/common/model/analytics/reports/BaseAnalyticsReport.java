package com.mccraftaholics.warpportals.common.model.analytics.reports;

import java.util.List;

public class BaseAnalyticsReport {
	public String serverId;
	public String timestamp;
    public int reportNumber;

    public String warpPortalsVersion;

    public List<String> installedPlugins;
    public int maxPlayers;
    public String bukkitVersion;
    public int numWorlds;
}
