package com.sky;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class SpringDataRedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void testRedisTemplate(){
        System.out.println(redisTemplate);
        redisTemplate.opsForValue().set("name","butt");
        String name = (String) redisTemplate.opsForValue().get("name");
        System.out.println(name);
        redisTemplate.opsForValue().set("secondtest",2120454,2, TimeUnit.MINUTES);
        Integer secondtest = (Integer) redisTemplate.opsForValue().get("secondtest");
        System.out.println(secondtest);
    }

    @Test
    public void testRedisHash(){
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("100","name","fakedick");
        hashOperations.put("100","age",100);
        hashOperations.put("100","virus","realdick");
        hashOperations.put("test","test2","test3");
        System.out.println(hashOperations.get("test","test2"));

        Set keys = hashOperations.keys("100");
        System.out.println(keys);
        List values = hashOperations.values("100");
        System.out.println(values);
        hashOperations.delete("100", "virus");
        System.out.println(values);
    }

    @Test
    public void listTest(){
        ListOperations listOperations = redisTemplate.opsForList();
        listOperations.rightPushAll("listTest","a","b","c","d","e","f","g");

        List listTest = listOperations.range("listTest", 0, -1);
        System.out.println(listTest);

        Long size = listOperations.size("listTest");
        System.out.println("size:" + size);

        listOperations.rightPop("listTest");
        System.out.println(listOperations.range("listTest", 0, -1));

        listOperations.leftPop("listTest");
        System.out.println(listOperations.range("listTest", 0, -1));
    }

    @Test
    public void setTest(){
        SetOperations setOperations = redisTemplate.opsForSet();
        setOperations.add("setTest","A","B","C","D");
        setOperations.add("setTest2","A","f","g","h");
        System.out.println(setOperations.members("setTest") +"||"+ setOperations.members("setTest2"));

        Set intersect = setOperations.intersect("setTest", "setTest2");
        System.out.println("intersect:" + intersect);

        Set union = setOperations.union("setTest", "setTest2");
        System.out.println("union" + union);

        setOperations.remove("setTest","B");

        Set keys = redisTemplate.keys("*t*");
        System.out.println(keys);
    }
}
