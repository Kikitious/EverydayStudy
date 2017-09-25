package com.katherine.du.everydaystudy.up20170920;

/**
 * Created by du on 17/9/20.
 */

//Eager initialization
/*public class Singleton {

    private static final Singleton INSTANCE = new Singleton();

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}*/


//Lazy initialization
/*public class Singleton {

    private static volatile Singleton INSTANCE = null;

    private Singleton() {
    }

    public static synchronized Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }
}*/


//Static block initialization
/*public class Singleton {

    private static final Singleton INSTANCE;

    static {
        try {
            INSTANCE = new Singleton();
        } catch (Exception e) {
            throw new RuntimeException("", e);
        }
    }

    private Singleton() {
    }

    public static Singleton getInstance() {
        return INSTANCE;
    }
}*/


//SingletonHolder类会在需要时才会被初始化，且不影响Singleton类的其他的static成员变量的使用
public class Singleton {

    private Singleton() {
    }

    private static class SingletonHolder {
        public static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}


/*
public enum Singleton {

    INSTANCE;

    public void execute(String arg) {

    }
}*/


