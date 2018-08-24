package cn.vector.girl.service;

import cn.vector.girl.domain.Girl;
import cn.vector.girl.enums.ResultEnum;
import cn.vector.girl.exception.GirlException;
import cn.vector.girl.repository.GirlRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-23 11:13
 */
@Service("girlService")
public class GirlService {
     private Logger log = LoggerFactory.getLogger(this.getClass().getName());
     private final GirlRepository girlRepository;

    @Autowired
    public GirlService(GirlRepository girlRepository) {
        this.girlRepository = girlRepository;
    }

    /**
     * 插入2个值，事务方式，测试事务
     */
    @Transactional
    public void insertTwo(){
        log.debug("run insertTwo");
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(15);
        girlRepository.save(girlA);
        Girl girlB = new Girl();
        girlB.setCupSize("Fccccc");
        girlB.setAge(19);
        girlRepository.save(girlB);

    }
    public void getAge(Integer id) throws Exception{
        Girl girl = girlRepository.getOne(id);
        Integer age = girl.getAge();
        if(age <= 10 ){
            //返回“你还在上小学吧”
            //return 1;
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        }else if (age > 10 && age <= 16){
            //返回“你可能在上初中”
            //return 2;
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果>16岁，加钱
        //..
        //return 0;
    }

    /**
     * 通过查询Id查询一个女生的信息
     * @param id
     * @return
     */
    public Girl findOne(Integer id){
        return girlRepository.getOne(id);
    }
}
