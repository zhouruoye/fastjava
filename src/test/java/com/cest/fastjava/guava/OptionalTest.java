package com.cest.fastjava.guava;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
public class OptionalTest {

    @Test
    public void test() throws Throwable{
        /**
         * 三种创建optional对象方式
         */
        Optional.empty();

        //非null创建
        Optional.of("1111");

        //可以为null的创建
        Optional<String> op = Optional.ofNullable("22222");

        op.isPresent();

        /**
         * 当optional引用存在时执行
         * 类似的方法：map filter flapMap
         */
        op.ifPresent(System.out::println);

        /**
         * 当optional引用缺失时执行
         */
        op.orElse("引用缺失");
        op.orElseGet(() -> {
            //自定义引用缺失时的返回值
            return "自定义引用缺失";
        });
        op.orElseThrow(() -> {
            throw new RuntimeException("引用缺失异常");
        });
    }

    public static void stream(List<String> list){
//        list.stream()
//                .forEach(System.out::println);
        log.info("进入流");

        Optional.ofNullable(list)
                .map(List::stream)
                .orElseGet(Stream::empty)
                .forEach(System.out::println);

    }

    public static void main(String[] args) {
        stream(null);
    }
}
