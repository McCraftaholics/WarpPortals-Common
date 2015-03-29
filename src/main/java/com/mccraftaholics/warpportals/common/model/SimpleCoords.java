package com.mccraftaholics.warpportals.common.model;

import java.io.Serializable;

public class SimpleCoords implements Cloneable, Comparable<SimpleCoords>, Serializable {
    public double x, y, z;

    public SimpleCoords() {

    }

    public SimpleCoords(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SimpleCoords)) return false;

        SimpleCoords that = (SimpleCoords) o;

        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.z, z) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public SimpleCoords clone() {
        return new SimpleCoords(x, y, z);
    }

    @Override
    public int compareTo(SimpleCoords that) {
        int i = Double.compare(x, that.x);
        if (i != 0) return i;

        i = Double.compare(y, that.y);
        if (i != 0) return i;

        return Double.compare(z, that.z);
    }

    /**
     * Determines if a de-serialized file is compatible with this class.
     *
     * Maintainers must change this value if and only if the new version
     * of this class is not compatible with old versions. See Sun docs
     * for <a href=http://java.sun.com/products/jdk/1.1/docs/guide
     * /serialization/spec/version.doc.html> details. </a>
     *
     * Not necessary to include in first version of the class, but
     * included here as a reminder of its importance.
     */
    private static final long serialVersionUID = 7526471155622386147L;

    @Override
    public String toString() {
        return "(" + x + "," + y + "," + z + ")";
    }
}
