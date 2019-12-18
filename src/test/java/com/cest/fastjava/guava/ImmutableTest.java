package com.cest.fastjava.guava;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 不可变集合
 */
public class ImmutableTest {

    /**
     * 可变集合
     * @return
     */
    public static List<String> getList1(){
        List<String> mutablelist = new ArrayList<>();
        mutablelist.add("111");
        mutablelist.add("222");
        mutablelist.add("333");
        mutablelist.add("444");

        return mutablelist;
    }

    /**
     * 不可变集合 -- jdk 实现
     * @return
     */
    public static List<String> getList2(){
        List<String> immutablelist = new ArrayList<>();
        immutablelist.add("111");
        immutablelist.add("222");
        immutablelist.add("333");
        immutablelist.add("444");

        immutablelist = Collections.unmodifiableList(immutablelist);

        return immutablelist;
    }

    /**
     * 不可变集合 -- guava实现 1
     * @return
     */
    public static List<String> getList3(){
        List<String> immutablelist = new ArrayList<>();
        immutablelist.add("111");
        immutablelist.add("222");
        immutablelist.add("333");
        immutablelist.add("444");

        //通过已存在的集合创建
        ImmutableList<String> strings1 = ImmutableList.copyOf(immutablelist);

        //通过初始值，直接创建不可变集合
        ImmutableList strings2 = ImmutableList.of(1, 2, 3);

        //以builder方式创建
        ImmutableList<Object> build = ImmutableList.builder()
                .add(1)
                .addAll(Sets.newHashSet(2, 3))
                .add(4)
                .build();

        return strings1;
    }

    public static void main(String[] args) {
        //可变集合可以删除
        getList1().remove(0);

        //不可变集合不可以删除
        //getList2().remove(0);

        //不可变集合不可以删除
        getList3().remove(0);
    }
}
