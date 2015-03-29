package com.mccraftaholics.warpportals.common.model;

import java.util.*;

public class SimplePortal<T extends SimpleCoords> implements Comparable<SimplePortal> {
    public UUID uuid;
    public String name;
    public String material;
    public String message;
    public List<T> blocks = new ArrayList<T>();

    public SimplePortal() {

    }

    public SimplePortal(UUID uuid, String name, String material, String message, List<T> blocks) {
        this.uuid = uuid;
        this.name = name;
        this.material = material;
        this.message = message;
        this.blocks = blocks;
    }

    public SimplePortal(UUID uuid, String name, String material, String message) {
        this(uuid, name, material, message, new ArrayList<T>());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimplePortal)) return false;

        SimplePortal simplePortal = (SimplePortal) o;

        if (blocks.size() == simplePortal.blocks.size()) {
            Set<Object> s1 = new HashSet<Object>();
            s1.addAll(blocks);
            Set<Object> s2 = new HashSet<Object>();
            s2.addAll(simplePortal.blocks);
            if (!s1.equals(s2)) {
                return false;
            }
        }
        if (!name.equals(simplePortal.name)) return false;
        if (!uuid.equals(simplePortal.uuid)) return false;
        if (!material.equals(simplePortal.material)) return false;
        if (!message.equals(simplePortal.message)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = uuid != null ? uuid.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (material != null ? material.hashCode() : 0);
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (blocks != null ? blocks.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(SimplePortal that) {
        int i = uuid.compareTo(that.uuid);
        if (i != 0) return i;

        // Only compares name as well so that test code can use generic UUIDs and still have sort functionality thanks to unique names
        return name.compareTo(that.name);
    }
}
