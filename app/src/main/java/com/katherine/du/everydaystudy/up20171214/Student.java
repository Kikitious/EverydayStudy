package com.katherine.du.everydaystudy.up20171214;

import java.io.Serializable;

/**
 * Created by du on 17/12/14.
 */

public class Student implements Serializable {

    //serialVersionUID，用来保证正常反序列化
    private static final long serialVersionUID = -6396556582748912833L;

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
