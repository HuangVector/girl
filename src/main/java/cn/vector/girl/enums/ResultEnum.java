package cn.vector.girl.enums;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-30 16:04
 */
public enum ResultEnum {
    UNKNOW_ERROR(-1, "未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(100,"我猜你可能还在小学"),
    MIDDLE_SCHOOL(101,"我猜你可能在上初中")
    ;
    private Integer code;
    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static String getMsgByCode(Integer code){
        for (ResultEnum resultEnum:ResultEnum.values()) {
            if(resultEnum.getCode() == code){
                return resultEnum.getMsg();
            }
        }
        return null;
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
