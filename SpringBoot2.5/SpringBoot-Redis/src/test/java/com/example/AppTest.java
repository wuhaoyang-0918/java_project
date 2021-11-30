package com.example;

import com.example.pojo.User;
import com.example.redistest.RedisTemplateUtils;
import com.example.redistest.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.support.collections.RedisCollectionFactoryBean;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * The type App test.
 *
 * @author why
 * @date 2021 /10/27 15:58
 * @PackageName com.example
 * @description
 */
@SpringBootTest
public class AppTest {
    /**
     * The Redis template 1.
     */
    @Autowired
    StringRedisTemplate redisTemplate1;
    /**
     * The Redis connection factory.
     */
    @Autowired
    RedisConnectionFactory redisConnectionFactory;
    /**
     * The Redis utils.
     */
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * Sho.
     */
    @Test
    public void sho() {
        ValueOperations<String, String> stringStringValueOperations = redisTemplate1.opsForValue();
        stringStringValueOperations.set("age", "11");
        System.out.println(stringStringValueOperations.get("age"));
        System.out.println(redisConnectionFactory.getClass());
    }

    /**
     * Tj.
     */
    @Test
    public void tj() {
        //统计访问测试
        redisTemplate.opsForValue().increment("name1");  //默认递增+1
        redisTemplate.opsForValue().increment("name1", 2L);//递增+2

    }

    /**
     * Sets string.
     */
    @Test
    void setString() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1001);
        dataMap.put("name", "张三");
        redisTemplate.opsForHash().putAll("user_map", dataMap);
         Map<Object, Object> user_map = redisTemplate.opsForHash().entries("user_map");
        Map<Object , Object> resultmap1=redisTemplate.boundHashOps("user_map").entries();
        System.out.println(resultmap1);

    }

    /**
     * 操作String
     */
    @Test
    void testString(){
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("name","张三");
        Object name = opsForValue.get("name");
        System.out.println(name);
        Map<String, Object> map = new HashMap<>();
        map.put("addr", "shanghai");
        map.put("age", "18");
        opsForValue.multiSet(map);
        //取值，多条
        List<String> list = new ArrayList<>();
        list.add("addr");
        list.add("age");
        List<Object> objects = opsForValue.multiGet(list);
        objects.forEach(System.out::println);
        //层级目录
        opsForValue.set("user:01:cart:item01", "iphone");
        redisTemplate1.delete("age");
    }


    /**
     * Test user string.
     */
    @Test
    void testUserString(){
        ValueOperations<String, Object> opsForValue = redisTemplate.opsForValue();
        opsForValue.set("user01",new User(1L,"张三"));
    }


    /**
     * 操作 hash.
     */
    @Test
    public void testHash(){
        HashOperations<String, Object, Object> hashOperations = redisTemplate.opsForHash();
        //设值，单条.
        hashOperations.put("user","name","赘婿");
        //取值，单条
        System.out.println(hashOperations.get("user", "name")+"----"+hashOperations.entries("user").get("name"));
        //设值，多条
        Map<Object, Object> map = new HashMap<>();
        map.put("say", "三年之期已到");
        map.put("男二", "你是龙王！");
        hashOperations.putAll("user",map);
        //取值，多条
        List<Object> list = new ArrayList<>();
        list.add("say");
        list.add("男二");
        List<Object> user = hashOperations.multiGet("user", list);
        user.forEach(System.out::println);
        //获取整个hash对象
        Map<Object, Object> user1 = hashOperations.entries("user");
        user1.forEach((k, v) -> System.out.println(k + "--->" + v));
        //删除
        hashOperations.delete("user","男二");

    }

    /**
     * Test list.
     */
    @Test
    public void testList() {
        ListOperations<String, Object> listOperations = redisTemplate.opsForList();
       listOperations.leftPushAll("students","赘婿","浩哥","昊哥");//左添加

       listOperations.leftPushAll("students",Arrays.asList("赘婿","浩哥","昊哥"));//左添加
        /**
         * 根据指定成员添加(zs)，如果指定成员不存在，添加不成功
         */
         listOperations.leftPush("students","zs","ls");
//        listOperations.rightPush("students","满意");//右添加
//
//        System.out.println("记录数"+listOperations.size("students"));   //记录数
//        List<Object> students1 = listOperations.range("students", 0, -1);/获取数据
//        students1.forEach(System.out::println);
          //删除一个昊哥
//        listOperations.remove("students",1,"昊哥");
        //弹出
       // System.out.println(listOperations.leftPop("students"));
       // 根据索引查询数据
      //  System.out.println(listOperations.index("students", 0));
    }

    /**
     * 操作Set
     */
    @Test
    public void testSet(){
        SetOperations<String, Object> setOperations = redisTemplate.opsForSet();
        //添加数据
        String[] strings = {"aaa", "bbb", "ccc", "ddd"};
        setOperations.add("letters",strings);
        //获取长度
        Long size = setOperations.size("letters");
        Set<Object> letters = setOperations.members("letters");
        letters.forEach(System.out::println);
        setOperations.remove("letters","aaa");

    }

    /**
     * 操作SortedSet
     */
    @Test
    public void testSortedSet(){
        //添加数据
        ZSetOperations<String, Object> zSetOperations = redisTemplate.opsForZSet();
        ZSetOperations.TypedTuple<Object> t1 = new DefaultTypedTuple<>("阿Giao",10D);
        ZSetOperations.TypedTuple<Object> t2 = new DefaultTypedTuple<>("药水哥",12D);
        ZSetOperations.TypedTuple<Object> t3 = new DefaultTypedTuple<>("暴扣哥",11D);
        ZSetOperations.TypedTuple<Object> t4 = new DefaultTypedTuple<>("Gai",100D);
        Set<ZSetOperations.TypedTuple<Object>> set = new HashSet<>();
        set.add(t1);
        set.add(t2);
        set.add(t3);
        set.add(t4);
        zSetOperations.add("score",set);
        zSetOperations.add("score","hangman",95D);
        //获取数据
        Set<Object> score = zSetOperations.range("score", 0, 5);
        score.forEach(System.out::println);
        //获取大小
        Long size = zSetOperations.size("score");
        System.out.println(size);
        //删除数据
       // zSetOperations.remove("score","Gai");
    }

    /**
     * 查询所有key
     */
    @Test
    public void testKeys(){
        Set<String> keys = redisTemplate.keys("*");
        keys.forEach(System.out::println);
    }

    /**
     * 操作失效时间
     */
    @Test
    public void testExpire(){
        //设值的时候设置失效时间
        ValueOperations<String, Object> valueOperations = redisTemplate.opsForValue();
      //   valueOperations.set("code","test",20, TimeUnit.SECONDS);
        //给已存在的key设置失效时间
      //  redisTemplate.expire("addr",10, TimeUnit.SECONDS);
        //查询失效时间
      //   Long code = redisTemplate.getExpire("code");
       //  System.out.println(code);

        //XX
        // valueOperations.setIfPresent();
        //NX
        Boolean aBoolean = valueOperations.setIfAbsent("name", "zs");
        System.out.println(aBoolean);
    }
}
