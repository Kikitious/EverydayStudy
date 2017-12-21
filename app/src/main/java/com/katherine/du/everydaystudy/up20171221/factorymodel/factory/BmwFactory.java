package com.katherine.du.everydaystudy.up20171221.factorymodel.factory;

import com.katherine.du.everydaystudy.up20171221.factorymodel.product.BmwCar;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.Engine;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.ICar;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.Underpan;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.Wheel;

/**
 * Created by du on 17/12/21.
 */

public class BmwFactory implements IFactory {

    @Override
    public ICar createCar() {
        Engine engine = new Engine();
        Wheel wheel = new Wheel();
        Underpan underpan = new Underpan();
        ICar car = new BmwCar(engine, wheel, underpan);
        return car;
    }
}
