package com.mcx;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mcx.mapper.CatMapper;
import com.mcx.pojo.Cat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MiaoApplicationTest {

    @Resource
    private CatMapper catMapper;

    @Test
    public void test(){
        List<Cat> cats = catMapper.selectList(null);
        cats.forEach(System.out::println);

    }

}
