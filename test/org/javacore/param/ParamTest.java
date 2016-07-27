package org.javacore.param;

import java.util.Date;

/**
 * Created by bysocket on 16/7/18.
 */
public class ParamTest {

    public static void main(String[] args) {
        ParamService p = new ParamService();

        Date start = new Date();
        for (int i = 1 ; i < 1000000; i++) {
            p.test02(1,"2","3",4,5);
        }
        Date end = new Date();
        System.out.println("ParamService.test02() : " + (end.getTime() - start.getTime()) );
        Date start2 = new Date();
        for (int i = 1 ; i < 100000; i++) {
            Param param = new Param();
            param.setId(1);
            param.setAge(2);
            param.setIsBeautiful(1);
            param.setName("2");
            param.setSex("2");
            p.test01(param);
        }
        Date end2 = new Date();
        System.out.println("ParamService.test01() : " + (end2.getTime() - start2.getTime()) );
    }
}
