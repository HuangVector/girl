package cn.vector.girl.handle;

import cn.vector.girl.domain.Result;
import cn.vector.girl.exception.GirlException;
import cn.vector.girl.utils.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-30 15:43
 */
@Slf4j
@ControllerAdvice
public class ExceptionHandle {
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result handle(Exception e){
        if(e instanceof GirlException){
            GirlException girlException = (GirlException) e;
            return ResultUtil.error(girlException.getCode(), girlException.getMessage());
        }else{
            log.error("【系统异常】{}",e);
            return ResultUtil.error(-1, "未知错误");
        }
        //return ResultUtil.error(100,e.getMessage());
    }
}
