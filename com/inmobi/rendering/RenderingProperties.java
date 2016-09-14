package com.inmobi.rendering;

public class RenderingProperties {
    private PlacementType f1793a;

    public enum PlacementType {
        FULL_SCREEN,
        INLINE
    }

    public RenderingProperties(PlacementType placementType) {
        this.f1793a = placementType;
    }

    public PlacementType m1989a() {
        return this.f1793a;
    }
}
