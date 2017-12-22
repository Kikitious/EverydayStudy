package com.katherine.du.everydaystudy.up20171222.teacher;

import com.katherine.du.everydaystudy.up20171222.teacher.observable.Teacher;
import com.katherine.du.everydaystudy.up20171222.teacher.observer.Student;

/**
 * Created by du on 17/12/22.
 */

public class OOTest {

    public static void main(String[] args) {
        Teacher teacher = new Teacher();

        new Student("Katherine", "101", teacher);
        new Student("Bob", "102", teacher);
        new Student("Tom", "103", teacher);

        teacher.publishHomeWork("数学课本第5页习题");
        teacher.publishHomeWork("数学课本第7页习题");
        teacher.publishHomeWork("数学课本第9页习题");

    }
}
