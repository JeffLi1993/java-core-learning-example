package org.javacore.colgoogle;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by 子木 on 2016/2/20.
 */
public class MapMakerT0 {
    public static void main(String[] args) {
        /**
         * expiration(3, TimeUnit.SECONDS)设置超时时间为3秒
         */
        ConcurrentMap<String , String> map = new MapMaker().concurrencyLevel(32).softKeys().weakValues()
                .expiration(3, TimeUnit.SECONDS).makeComputingMap(
                        /**
                         * 提供当Map里面不包含所get的项，可以自动加入到Map的功能
                         * 可以将这里的返回值放到对应的key的value中
                         */
                        new Function<String, String>() {
                            public String apply(String s) {
                                return "creating " + s + " -> Object";
                            }
                        }
                );

        map.put("a","testa");
        map.put("b","testb");

        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));

        try {
            // 4秒后，大于超时时间，缓存失效。
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(map.get("a"));
        System.out.println(map.get("b"));
        System.out.println(map.get("c"));
    }
}
