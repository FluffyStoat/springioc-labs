package com.luxoft.springioc.lab1.model;

/**
 * @author bochkarev
 * @version $
 */
public class Car {
    private Engine firstEngine;
    private Engine secondEngine;

    public Engine getFirstEngine() {
        return firstEngine;
    }

    public void setFirstEngine(Engine firstEngine) {
        this.firstEngine = firstEngine;
    }

    public Engine getSecondEngine() {
        return secondEngine;
    }

    public void setSecondEngine(Engine secondEngine) {
        this.secondEngine = secondEngine;
    }
}
