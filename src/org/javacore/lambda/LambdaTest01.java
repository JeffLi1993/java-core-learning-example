package org.javacore.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * List 比较器
 * <p/>
 * Created by bysocket on 16/7/12.
 */
public class LambdaTest01 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(1);
        list.add(3);
        list.add(6);

//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });

        /** Lambda表达式格式:
         * (Type1 param1, Type2 param2, ..., TypeN paramN) -> {
         *  statment1;
         *  statment2;
         *  ...
         *  return statmentM;
         * }
         */
//        list.sort(((o1, o2) -> {
//            return Integer.compare(o1, o2);
//        }));

        // 简写Lambda表达式
        list.sort((o1, o2) -> Integer.compare(o1, o2));

        System.out.println(list.toString());
    }
}
