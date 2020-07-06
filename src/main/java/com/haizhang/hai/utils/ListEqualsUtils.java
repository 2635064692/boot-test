package com.haizhang.hai.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author zhanghai by 2019/8/29
 */
public class ListEqualsUtils {
    public static boolean equalLists(List one, List two) {
        if (one == null && two == null) {
            return true;
        }

        if ((one == null && two != null)
                || one != null && two == null
                || one.size() != two.size()) {
            return false;
        }

        //to avoid messing the order of the lists we will use a copy
        //as noted in comments by A. R. S.
        one = new ArrayList<>(one);
        two = new ArrayList<>(two);

        Collections.sort(one);
        Collections.sort(two);
        return one.equals(two);
    }

    //定义的是比较器,所以这个需要传入进去的是两个参数
    public class GenericComparator<T> implements Comparator<T> {

        //设置返回的值0代表相等,>0大于<0小于
        @Override
        public int compare(T o1, T o2) {
            if (o1.equals(o2)) {
                return 0;
            }
            //把参数强制转换为Comparable类型再比较,这样的好处
            //在于,如果你使用的是这个比较器,并且你在调用的时候
            //传入的参数是实现了Comparable接口的类型的话,那么
            //在传入比较器的时候,它就会自动的去调用被比较的类型
            //里面所定义的compareTo方法
            return ((Comparable<T>) o1).compareTo(o2) * -1;
        }
    }
}
