package cn.vector.girl.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Proxy;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import java.io.Serializable;
import java.util.Objects;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-15 11:06
 */
@Entity
@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})
@Proxy(lazy = false)
public class Girl implements Serializable{
    private static final long serialVersionUID = -3872091415363703212L;

    @Id
    @GeneratedValue
    private Integer id;

    private String cupSize;

    @Min(value = 18, message = "未成年少女禁止入内！")
    private Integer age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Girl() {
    }

    public Girl(String cupSize, Integer age) {
        this.cupSize = cupSize;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Girl)) return false;
        Girl girl = (Girl) o;
        return Objects.equals(getId(), girl.getId()) &&
                Objects.equals(getCupSize(), girl.getCupSize()) &&
                Objects.equals(getAge(), girl.getAge());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getId(), getCupSize(), getAge());
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
