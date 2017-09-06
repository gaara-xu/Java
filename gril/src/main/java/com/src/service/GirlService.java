package com.src.service;

import com.src.enums.ResultEnum;
import com.src.exception.GirlException;
import com.src.repository.GirlRepository;
import com.src.domain.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import static com.src.enums.ResultEnum.HAVENOGRILFRIEND;

/**
 * Created by Gaara_Xu on 2017/9/5.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo(){
        Gril grilA = new Gril();
        grilA.setAge(22);
        grilA.setCupSize("D");
        grilA.setSex("1");
        girlRepository.save(grilA);

        Gril grilb = new Gril();
        grilb.setAge(24);
        grilb.setCupSize("FF");
        grilb.setSex("1");
        girlRepository.save(grilb);
    }
    public void getage(Integer id)throws Exception{
        Gril gril = girlRepository.findOne(id);
        if (gril == null){
            throw new GirlException(ResultEnum.HAVENOGRILFRIEND);
        }
        Integer age = gril.getAge();
        if (age<10) {
            throw new GirlException(ResultEnum.TRUEERREY_1);
        }else if(age>10&&age<16){
            throw new GirlException(ResultEnum.TRUEERREY_2);
        }else{
            throw new GirlException(ResultEnum.TRUEERREY_3);
        }

    }
}
