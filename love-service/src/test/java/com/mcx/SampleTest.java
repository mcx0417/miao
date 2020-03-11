package com.mcx;

import com.mcx.mapper.LoveMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private LoveMapper loveMapper;

    @Test
    public void testSelect() {

    }
}
