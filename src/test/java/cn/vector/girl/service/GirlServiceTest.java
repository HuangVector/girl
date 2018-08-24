package cn.vector.girl.service;

import cn.vector.girl.domain.Girl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-31 16:16
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {
    @Autowired
    private GirlService girlService;

    @Test
    public void insertTwo() {
    }

    @Test
    public void getAge() {
    }

    @Test
    public void findOne() {
        Girl girl = girlService.findOne(12);//14, 7
        log.info("girl:{}", girl.getAge());
        Assert.assertEquals(new Integer(14), girl.getAge());
    }
}