package com.mccraftaholics.warpportals.common.model.analytics.reports;

import com.mccraftaholics.warpportals.common.model.SimpleCoords;
import com.mccraftaholics.warpportals.common.model.analytics.objects.AnalyticsUsage;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AnalyticsReportUsage {
	/*
	 * key: Which GMT Hour, Long MS Unix time value
	 * 
	 * value: Number of WarpPortal uses in that hour
	 * 
	 *  {
	 *      "1": {
	 *          portalUses: {
	 *              "067e6162-3b6f-4ae2-a171-2470b63dff00": 87
	 *          },
	 *          portalsCreated: {
	 *              "067e6162-3b6f-4ae2-a171-2470b63dff00": {
	 *                  uuid: "067e6162-3b6f-4ae2-a171-2470b63dff00",
	 *                  name: "Portal1",
	 *                  blocks: [{x: 0, y: 0, z: 0}, {x: 0, y: 1, z:0}]
	 *              }
	 *          }
	 *      }
     *  }
	 */
	private Map<Long, AnalyticsUsage> perHour;

	/** Required JavaBeans blank constructor */
	public AnalyticsReportUsage() {
		perHour = new HashMap<Long, AnalyticsUsage>();
	}

	static final int MS_IN_HOUR = 1000 * 60 * 60;

    /**
     * Standardized method for calculating the hours since the UNIX Epoch.
     * @return Long value corresponding to the hours since the UNIX Epoch
     */
    private long getCurrentHour() {
        return (System.currentTimeMillis() / MS_IN_HOUR) + 1;
    }

    /**
     * Return the AnalyticsUsage object for this hour. Creates a new one in the perHour map if need be.
     * @param hour The Long hour that this AnalyticsUsage corresponds to
     * @return AnalyticsUsage
     */
    private AnalyticsUsage getAnalyticsUsageForHour(long hour) {
        if (!perHour.containsKey(hour)) {
            perHour.put(hour, new AnalyticsUsage());
        }
        return perHour.get(hour);
    }

    /**
     * Increment the count for number of times that portal UUID has been used this hour
     * @param uuid UUID of the portal being used
     */
	public void incrementPortalUsageThisHour(UUID uuid) {
        AnalyticsUsage hoursUsage = getAnalyticsUsageForHour(getCurrentHour());
		hoursUsage.incrementPortalUsage(uuid);
	}

    /**
     * Log the creation of a portal, storing its UUID, name, and relative block coords
     * @param uuid UUID of the portal. Should stay constant forevermore for this portal.
     * @param name Name of the portal
     * @param material Block material that makes up the portal
     * @param message Message displayed to user on teleportation
     * @param blocks List of basic {x, y, z}. Should be relative to a median block within the portal
     */
    public void addPortalCreatedThisHour(UUID uuid, String name, String material, String message, List<SimpleCoords> blocks) {
        AnalyticsUsage hoursUsage = getAnalyticsUsageForHour(getCurrentHour());
        hoursUsage.addPortalCreated(uuid, name, material, message, blocks);
    }

	// //////////////////
	// // --- YAML --- //
	// //////////////////
	/**
	 * Setter for perHoursMap
	 * 
	 * @return
	 */
	public Map<Long, AnalyticsUsage> getPerHour() {
		return perHour;
	}

	/**
	 * Getter for perHoursMap
	 * 
	 * @param perHourMap
	 */
	public void setPerHour(Map<Long, AnalyticsUsage> perHourMap) {
		this.perHour = perHourMap;
	}
}
