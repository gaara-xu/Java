package com.src.service;

import com.src.repository.GirlRepository;
import com.src.domain.Gril;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

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
}
