package com.cest.fastjava.guava;

import com.google.common.collect.HashMultiset;
import com.google.common.primitives.Chars;
import org.junit.jupiter.api.Test;

/**
 * Multiset 是一个没有元素顺序限制的ArrayList
 * 实现：使用Multiset统计一首古诗的文字出现频率
 */
public class MultisetTest {

    private static final String text =
            "《南陵别儿童入京》" +
                    "白酒新熟山中归，黄鸡啄黍秋正肥。\n" +
                    "呼童烹鸡酌白酒，儿女嬉笑牵人衣。\n" +
                    "高歌取醉欲自慰，起舞落日争光辉。\n" +
                    "游说万乘苦不早，著鞭跨马涉远道。\n" +
                    "会稽愚妇轻买臣，余亦辞家西入秦。\n" +
                    "仰天大笑出门去，我辈岂是蓬蒿人。";

    @Test
    public void test(){
        //String转换成char数组
        char[] chars = text.toCharArray();
        
        //创建multset
        HashMultiset<Character> characters = HashMultiset.create();

        //遍历数组
        Chars.asList(chars)
                .stream().forEach(n -> characters.add(n));

        Chars.asList(chars)
                .stream()
                .filter(item -> item.equals("中"))
                .forEach(item -> characters.remove(item));

        System.out.println("size : " + characters.size());

        System.out.println("count : " + characters.count('中'));

        System.out.println("count : " + characters.count('童'));

    }
}
