package com.src.controller;

import com.src.properties.GirlProperties;
import com.src.service.GirlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Gaara_Xu on 2017/9/4.
 */
@RestController
public class HellowController {
/*    @Value("${cupSize}")
    private String cupSize;
    @Value("${age}")
    private  Integer age;
    @Value("${content}")
    private String content;*/
    @Autowired
    private GirlProperties girlProperties;
    @Autowired
    private GirlService girlService;

    @GetMapping(value = "/hello")
    public String say(){
         /*System.out.println(cupSize);
        System.out.println(age);
        System.out.println(content);*/
        System.out.println(girlProperties.getCupSize()+"   "+girlProperties.getSex()+"   "+girlProperties.getAge());
         return "hello Spring Boot !";

    }

    @RequestMapping(value = "/ha/{id}",method = RequestMethod.GET)
    public String sayme(@PathVariable("id") Integer id) {
        return "id="+id;
    }
    @RequestMapping(value = "/he",method = RequestMethod.GET)
    public String saymes(@RequestParam("id") Integer idssssss) {
        return "id="+idssssss;
    }
    @RequestMapping(value = "/he2",method = RequestMethod.GET)
    public String saymesss(@RequestParam(value = "id",required = false,defaultValue = "74110") Integer idssssss) {
        return "id="+idssssss;
    }

    @GetMapping(value = "he3")
    public String ghasdsgf(){

        return "";
    }

    @GetMapping(value = "/he4")
    public void thistwo(){
        girlService.insertTwo();
    }
}
