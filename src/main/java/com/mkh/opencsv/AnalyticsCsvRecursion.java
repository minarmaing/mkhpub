package com.mkh.opencsv;

import com.mkh.opencsv.domain.Dimensions;
import com.mkh.opencsv.domain.Metrics;
import com.opencsv.bean.CsvRecurse;

public class AnalyticsCsvRecursion {

    @CsvRecurse
    private Dimensions dimensions;
    @CsvRecurse
    private Metrics metrics;

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
        this.dimensions = dimensions;
    }

    public Metrics getMetrics() {
        return metrics;
    }

    public void setMetrics(Metrics metrics) {
        this.metrics = metrics;
    }
}
