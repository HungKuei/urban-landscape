package com.urban.utils;

import java.util.Collection;

public class EmptyUtil {

    /**
     * 判断字符串是否为空
     * PS:
     * 为空的条件：
     * 1. String对象为空
     * 2. 没有任何字符的字符串
     *
     * @param str 需要判断的字符串
     * @return 为空(true), 非空(false)
     */
    public static boolean isEmpty(String str) {
        return null == str || "".equals(str);
    }

    /**
     * 判断对象是否为空
     *
     * @param obj 需要进行判断的对象
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(Object obj) {
        return null == obj || "".equals(obj);
    }

    /**
     * 判断集合是否为空
     * PS：
     * 集合为空的条件：
     * 1. 集合对象为null
     * 2. 集合中没有元素
     *
     * @param collection 需要进行判断的集合
     * @return 为空(true), 不为空(false)
     */
    public static boolean isEmpty(Collection<?> collection) {
        return null == collection || collection.size() == 0;
    }
}
