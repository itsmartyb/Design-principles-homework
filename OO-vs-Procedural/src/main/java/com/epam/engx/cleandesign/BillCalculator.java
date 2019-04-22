package com.epam.engx.cleandesign;

import java.util.Map;

public class BillCalculator {
    private static final double MULTI_DAY_PRICE_FACTOR = 1.1;
    public static Map<String, Double> zoneTypeWorkPrice;
    private static final int ONE_DAY_MAX_AREA = 50;

    public static double getWorkPrice(double area, String type) {
        double price = area * zoneTypeWorkPrice.get(type);
        if (area < ONE_DAY_MAX_AREA)
            return price;
        return price * MULTI_DAY_PRICE_FACTOR;
    }
}
