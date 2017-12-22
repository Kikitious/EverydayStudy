package com.katherine.du.everydaystudy.up20171222.teacher.observer;

import com.katherine.du.everydaystudy.up20171222.teacher.observable.Teacher;

/**
 * Created by du on 17/12/22.
 */

public class Student implements Observer {

    private String name;
    private String studentId;
    private Teacher teacher;

    public Student(String name, String id, Teacher teacher) {
        this.name = name;
        this.studentId = id;
        this.teacher = teacher;
        teacher.addObserver(this);
    }


    @Override
    public void receiveHomework(String string) {
        System.out.println(name + "收到了作业：" + string);
    }


}
