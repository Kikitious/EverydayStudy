package com.katherine.du.everydaystudy.up20171221.factorymodel;

import com.katherine.du.everydaystudy.up20171221.factorymodel.factory.BmwFactory;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.IBicycle;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.ICar;

/**
 * Created by du on 17/12/21.
 */

public class Client {

    public static void main(String[] args) {
        BmwFactory bmwFactory = new BmwFactory();
        ICar bmwCar = bmwFactory.createCar();
        bmwCar.show();
        IBicycle bmwBicycle = bmwFactory.createBicycle();
        bmwBicycle.show();
    }
}

