package cn.vector.girl.controller;

import cn.vector.girl.domain.Girl;
import cn.vector.girl.domain.Result;
import cn.vector.girl.repository.GirlRepository;
import cn.vector.girl.service.GirlService;
import cn.vector.girl.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-15 11:21
 */
@Slf4j
@RestController
public class GirlController {
     //private final static Logger log = LoggerFactory.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    private final GirlRepository girlRepository;
    private final GirlService girlService;

    @Autowired
    public GirlController(GirlRepository girlRepository, GirlService girlService) {
        this.girlRepository = girlRepository;
        this.girlService = girlService;
    }

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        log.info("do Method:{}:查询所有女生列表!",Thread.currentThread().getStackTrace()[1].getMethodName());
        return girlRepository.findAll();
    }

//    /**
//     * 添加一个女生
//     * @param cupSize
//     * @param age
//     * @return
//     */
//    @PostMapping(value = "/girls")
//    public Girl girlAdd(@RequestParam("cupSize") String cupSize,
//                          @RequestParam("age") Integer age){
//        Girl girl = new Girl();
//        girl.setCupSize(cupSize);
//        girl.setAge(age);
//        return girlRepository.save(girl);
//    }

    /**
     * 添加女生
     * @param girl
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bindingResult){
        log.info("do Method:{}:添加女生！the girl:age={},cupSize={}",Thread.currentThread().getStackTrace()[1].getMethodName(),girl.getAge(),girl.getCupSize());
//        Girl g = new Girl();
//        g.setAge(girl.getAge());
//        g.setCupSize(girl.getCupSize());
//        return girlRepository.save(g);
        if(bindingResult.hasErrors()){
            //log.info(bindingResult.getFieldError().getDefaultMessage());
            //return null;
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());
        return ResultUtil.success(girlRepository.save(girl));
    }
    /**
     * 查询一个女生
     * @param id
     * @return
     */
    @GetMapping(value = "/girls/{id}")
    public Girl girlGetOne(@PathVariable("id") Integer id){
        return girlRepository.getOne(id);
    }

    /**
     * 更新
     * @param cupSize
     * @param age
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                          @RequestParam("age") Integer age){
        Girl girl = new Girl();
        girl.setId(id);
        girl.setAge(age);
        girl.setCupSize(cupSize);
        return girlRepository.save(girl);
    }

    /**
     * 删除
     * @param id
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRepository.deleteById(id);
    }

    /**
     * 通过年龄查询女生列表
     * @param age
     * @return
     */
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age){
        return girlRepository.findByAge(age);
    }
    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }
    @GetMapping(value = "/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
//        Integer result = girlService.getAge(id);
//        if(result.equals(1)){
//
//        }else if(result.equals(2)){
//
//        }
    }

}
