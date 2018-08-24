package cn.vector.girl.controller;

import cn.vector.girl.properties.GirlProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-11 14:17
 */
@RestController
public class HelloController {
    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private Integer age;
    @Value("${content}")
    private String content;

    private final GirlProperties girlProperties;

    //一般建议使用构造器注入的方法，这样可以明确成员变量的加载顺序。
    // https://www.cnblogs.com/acm-bingzi/p/springAutowired.html
    @Autowired
    public HelloController(GirlProperties girlProperties) {
        this.girlProperties = girlProperties;
    }

    //@RequestMapping(value = "/hello" , method = RequestMethod.GET)
    //@RequestMapping(value = "/say/{id}",method = RequestMethod.GET)
    //@RequestMapping(value = "/say" , method = RequestMethod.GET)
    @GetMapping(value = "/say")
    //public String say(@PathVariable("id") Integer id){
    //public String say(@RequestParam("id") Integer id){
    public String say(@RequestParam(value = "id",required = false ,defaultValue = "0") Integer id){
        //return girlProperties.getCupSize();//cupSize+" | "+age+" | "+content;//"Hello Spring Boot!";
        return "id:"+id;
    }

}
