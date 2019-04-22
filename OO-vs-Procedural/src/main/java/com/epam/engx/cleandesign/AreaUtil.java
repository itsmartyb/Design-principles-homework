package com.epam.engx.cleandesign;

public class AreaUtil {

    public static double getApertureArea(Space s) {
        return s.getWidth() * s.getHeight();
    }
}
