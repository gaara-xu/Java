package com.src.repository;

import com.src.domain.Gril;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Gaara_Xu on 2017/9/4.
 */
public interface GirlRepository extends JpaRepository<Gril,Integer>{
    //根据年龄查询
    public List<Gril> findByAge(Integer age);
}
