package cn.vector.girl.exception;

import cn.vector.girl.enums.ResultEnum;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-30 15:49
 */
public class GirlException extends RuntimeException{
    private Integer code;
    public GirlException(Integer code ,String message){
        super(message);
        this.code=code;
    }

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
