package com.katherine.du.everydaystudy.up20171221.factorymodel.factory;

import com.katherine.du.everydaystudy.up20171221.factorymodel.product.BenzBicycle;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.BenzCar;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.Engine;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.IBicycle;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.ICar;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.Underpan;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.Wheel;

/**
 * Created by du on 17/12/21.
 */

public final class BenzFactory implements IFactory {

    @Override
    public ICar createCar() {
        Engine engine = new Engine();
        Wheel wheel = new Wheel();
        Underpan underpan = new Underpan();
        ICar car = new BenzCar(engine, wheel, underpan);
        return car;
    }

    @Override
    public IBicycle createBicycle() {
        return new BenzBicycle();
    }
}
