package com.mccraftaholics.warpportals.common.model.analytics.objects;

import com.mccraftaholics.warpportals.common.model.SimpleCoords;
import com.mccraftaholics.warpportals.common.model.SimplePortal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class AnalyticsUsage {
    public Map<UUID, Integer> portalUses;
    public Map<UUID, SimplePortal> portalsCreated;

    public AnalyticsUsage() {
    }

    public static AnalyticsUsage createNew() {
        AnalyticsUsage analyticsUsage = new AnalyticsUsage();
        analyticsUsage.portalUses = new HashMap<UUID, Integer>();
        analyticsUsage.portalsCreated = new HashMap<UUID, SimplePortal>();
        return analyticsUsage;
    }

    /**
     * Increment the count for number of times that portal UUID has been used
     * @param uuid UUID of the portal being used
     */
    public void incrementPortalUsage(UUID uuid) {
        int current = 0;
        if (portalUses.containsKey(uuid)) {
            current = portalUses.get(uuid);
        }
        current++;
        portalUses.put(uuid, current);
    }

    /**
     * Log the creation of a portal, storing its UUID, name, and relative block coords
     * @param uuid UUID of the portal. Should stay constant forevermore for this portal.
     * @param name Name of the portal
     * @param material Block material that makes up the portal
     * @param message Message displayed to user on teleportation
     * @param blocks List of basic {x, y, z}. Should be relative to a median block within the portal
     */
    public void addPortalCreated(UUID uuid, String name, String material, String message, List<SimpleCoords> blocks) {
        portalsCreated.put(uuid, new SimplePortal(uuid, name, material, message, blocks));
    }

}
