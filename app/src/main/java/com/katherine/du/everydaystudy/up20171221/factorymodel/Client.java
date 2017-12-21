package com.katherine.du.everydaystudy.up20171221.factorymodel;

import com.katherine.du.everydaystudy.up20171221.factorymodel.factory.Factory;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.ICar;

/**
 * Created by du on 17/12/21.
 */

public class Client {

    public static void main(String[] args) {
        ICar car = Factory.createCar();
        car.show();
    }
}

