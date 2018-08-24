package cn.vector.girl.repository;

import cn.vector.girl.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @Author : Huang Vector ( hgw )
 * @Date : 2018-5-15 11:24
 */
public interface GirlRepository extends JpaRepository<Girl,Integer> {
    /**
     * 通过年龄查询女生列表
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);
}
