package com.epam.engx.cleandesign;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.epam.engx.cleandesign.CalculationUtil.summing;

public class Zone extends Space{
    private static final double MATERIAL_AREA_FACTOR = 10;
    private String type;
    private List<Aperture> apertures = new ArrayList<>();

    public Zone(String type, double height, double width) {
        super(height, width);
        this.type = type;
    }

    public double getZoneArea() {
        return getHeight() * getWidth() - summing(this.getApertures(), AreaUtil::getApertureArea);
    }

    public Double calculateZoneBillPrice() {
        validateZone();
        return getZoneBillPrice();
    }

    private Double getZoneBillPrice() {
        double area = this.getZoneArea();
        return getMaterialPrice(area) + BillCalculator.getWorkPrice(area, this.getType());
    }

    private void validateZone() {
        if (isNotContainsKey(BillCalculator.zoneTypeWorkPrice))
            throw new WrongZoneTypeException();
    }

    private boolean isNotContainsKey(Map<String, Double> zoneTypeWorkPrice) {
        return !zoneTypeWorkPrice.keySet().contains(this.getType());
    }

    private static double getMaterialPrice(double area) {
        return area * MATERIAL_AREA_FACTOR;
    }


    public void setApertures(List<Aperture> apertures) {
        this.apertures = apertures;
    }

    public List<Aperture> getApertures() {
        return apertures;
    }

    public String getType() {
        return type;
    }

}