package com.katherine.du.everydaystudy.up20171221.factorymodel.product;

/**
 * Created by du on 17/12/21.
 */

public class BmwCar implements ICar {

    private Engine engine;
    private Wheel wheel;
    private Underpan underpan;

    public BmwCar(Engine engine, Wheel wheel, Underpan underpan) {
        this.engine = engine;
        this.wheel = wheel;
        this.underpan = underpan;
    }

    @Override
    public void show() {
        System.out.println("This is your BNW car");
    }
}



