package cn.vector.girl.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-31 16:33
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class GirlControllerTest {
    @Autowired
    private MockMvc mvc;
    @Test
    public void girlList() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().string("abc"))
        ;
    }
}