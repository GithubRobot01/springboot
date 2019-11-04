package cn.itcast.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        //string字符串
        //redisTemplate.opsForValue().set("str","wqs");
        redisTemplate.boundValueOps("str").set("xle");
        System.out.println("string-"+redisTemplate.opsForValue().get("str"));
        //hash散列
        redisTemplate.boundHashOps("hash").put("name","wqs");
        redisTemplate.boundHashOps("hash").put("age","23");
        Set set = redisTemplate.boundHashOps("hash").keys();
        List list = redisTemplate.boundHashOps("hash").values();
        System.out.println("hash-key-"+set);
        System.out.println("hash-value-"+list);
        //list列表
        redisTemplate.boundListOps("list").leftPush("a");
        redisTemplate.boundListOps("list").leftPush("b");
        List list1 = redisTemplate.boundListOps("list").range(0, -1);
        System.out.println("list-"+list1);
        //set
        redisTemplate.boundSetOps("set").add("a","b","c");
        Set set1 = redisTemplate.boundSetOps("set").members();
        System.out.println("set-"+set1);
        //sorted set
        redisTemplate.boundZSetOps("zset").add("a",100);
        redisTemplate.boundZSetOps("zset").add("b",101);
        redisTemplate.boundZSetOps("zset").add("c",10);
        Set zset = redisTemplate.boundZSetOps("zset").range(0, -1);
        System.out.println("zset-"+zset);
    }
}
