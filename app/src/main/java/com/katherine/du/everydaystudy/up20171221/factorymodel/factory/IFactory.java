package com.katherine.du.everydaystudy.up20171221.factorymodel.factory;

import com.katherine.du.everydaystudy.up20171221.factorymodel.product.IBicycle;
import com.katherine.du.everydaystudy.up20171221.factorymodel.product.ICar;

/**
 * Created by du on 17/12/21.
 */

public interface IFactory {

    ICar createCar();

    IBicycle createBicycle();
}
