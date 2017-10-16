package com.example.enumtest;

/**
 * Created by du on 17/10/9.
 */

class ObjectTest {

    static int i;

    public static void main(String arguments[]) {
        Season[] seasons = Season.values();
        System.out.println(seasons[0]);

        Season winter = Season.valueOf("WINTER");
        System.out.println(winter.toString());
        System.out.println(winter.name());

        int ordinal = winter.ordinal();
        System.out.println(ordinal);

        int compareTo = winter.compareTo(Season.AUTOMN);
        System.out.println(compareTo);

        Class<Season> declaringClass = winter.getDeclaringClass();
        System.out.println(declaringClass);

        Class<? extends Season> winterClass = winter.getClass();
        System.out.println(winterClass);

        Class<?> superclass = winterClass.getSuperclass();
        System.out.println(superclass);

        Class<?> superclassSuperclass = superclass.getSuperclass();
        System.out.println(superclassSuperclass);

        EnumTest fri = EnumTest.FRI;
        System.out.println(fri.getValue());
        System.out.println(fri.name());
        System.out.println(fri.toString());
    }


    static enum Season {
        SPRING("spring"),
        SUMMER("summer"),
        AUTOMN("automn"),
        WINTER("winter");

        private String desc;


        Season() {
        }

        private Season(String desc) {
            this.desc = desc;
        }

        @Override
        public String toString() {
            return "Season{" + "desc='" + desc + '\'' + '}';
        }
    }

}
