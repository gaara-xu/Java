package com.src.controller;

import com.src.domain.Result;
import com.src.repository.GirlRepository;
import com.src.domain.Gril;
import com.src.service.GirlService;
import com.src.utils.ResultUtil;
import com.sun.corba.se.spi.orbutil.fsm.Guard;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Gaara_Xu on 2017/9/4.
 */
@RestController
public class GirlController {
    @Autowired
    private GirlRepository girlRepository;
    @Autowired
    private GirlService girlService;

    @GetMapping(value = "getAllGirl")
    public List<Gril> girllist(){
        return girlRepository.findAll();
    }
    //增
    @GetMapping(value = "addGirlold")
    public void addGirlold(@RequestParam("cupSize") String cupSize,@RequestParam("age") Integer age){

    }
    @PostMapping(value = "addGirl")
    public Gril addGirl(@Valid Gril gril, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getDefaultMessage());
            return null;
        }
        gril.setCupSize(gril.getCupSize());
        gril.setAge(gril.getAge());
        gril.setSex("1");
        gril.setMoney(gril.getMoney());
        System.out.println(gril.getMoney()+"========");
        return girlRepository.save(gril);
    }
    //删
    @DeleteMapping(value = "deletegril")
    public void dele(@RequestParam(value = "id") Integer id ){
        girlRepository.delete(id);
    }
    //改
    @PutMapping(value = "update")
    public Gril update(@RequestParam(value = "id") Integer id ,@RequestParam(value = "sex") String sex){
        Gril gril = new Gril();
        gril.setSex(sex);
        return girlRepository.save(gril);
    }
    //查
    @GetMapping(value = "select")
    public Gril select(@RequestParam(value = "id")Integer id){
        return girlRepository.findOne(id);
    }
    //查询年龄
    @GetMapping(value = "selectbyage")
    public List<Gril> selectbyage(@RequestParam(value = "age")Integer age){
        return girlRepository.findByAge(age);
    }



    @PostMapping(value = "newg")
    public Result<Gril> girlll(@Valid Gril gril,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            Result result = new Result();
            result.setCode(1);
            result.setMsg(bindingResult.getFieldError().getDefaultMessage());
            result.setData(null);
            return result;
        }

        Result result = new Result();
        result.setCode(1);
        result.setMsg("成功");
        result.setData(null);
        return result;
    }

    @PostMapping(value = "testutil")
    public Result<Gril> testutil(@Valid Gril gril,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());
        }
        gril.setCupSize(gril.getCupSize());
        gril.setAge(gril.getAge());
        gril.setSex("1");
        gril.setMoney(gril.getMoney());
        return ResultUtil.success(girlRepository.save(gril));
    }

    @GetMapping(value = "getage/{id}")
    public void getage(@PathVariable("id")Integer id)throws Exception{
        girlService.getage(id);
    }

}
