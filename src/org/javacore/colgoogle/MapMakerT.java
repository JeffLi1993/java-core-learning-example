package org.javacore.colgoogle;

import com.google.common.base.Function;
import com.google.common.collect.MapMaker;

import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.TimeUnit;

/**
 * Created by 子木 on 2016/2/20.
 */
public class MapMakerT {
    // 使用案例:存储验证码
    // <String, String> == <用户唯一，验证码>
    // expiration(15, TimeUnit.MINUTES) 有效期15分钟
    ConcurrentMap<String,String> capthcaMap = new MapMaker().expiration(15, TimeUnit.MINUTES).makeMap();

    // 设置ConcurrentMap的concurrencyLevel参数 ，例如ConcurrentHashMap是用来控制其Segment数组的大小
    ConcurrentMap<String,Object> map1 = new MapMaker().concurrencyLevel(8).makeMap();

    // 构造各种不同reference作为key和value的map
    ConcurrentMap<String,Object> map2 = new MapMaker().softKeys().weakValues().makeMap();

    // 提供当Map里面不包含所get的项，可以自动加入到Map的功能
    ConcurrentMap<String,Integer> map3 = new MapMaker()
            .makeComputingMap(
                    new Function<String, Integer>() {
                        public Integer apply(String key) {
                            return 1;
                        }
                    }
            );
}
