package com.epam.engx.cleandesign;

public abstract class Space {
    private double height;
    private double width;

    public Space(double height, double width) {
        this.height = height;
        this.width = width;
    }

    double getHeight() {
        return this.height;
    }

    double getWidth() {
        return this.width;
    }

}
