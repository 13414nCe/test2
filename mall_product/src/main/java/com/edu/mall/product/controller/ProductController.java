package com.edu.mall.product.controller;

import com.edu.mall.product.bean.Product;
import com.edu.mall.product.mapper.ProductMapper;
import com.edu.mall.product.web.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author box
 * @date 2019/5/11 - 12:21
 *
 * product rest 服务
 */
@RestController
public class ProductController {

    @Resource
    private ProductMapper productMapper;

    @PostMapping("/soa/product/add")
    public Object add(Product product){

        Integer res = productMapper.add(product);
        return res==1 ? new Response("200","OK") : new Response("500","Fail");
    }

    @GetMapping("/soa/product/{id}")
    public Object get(@PathVariable Integer id){
        Product product = productMapper.getById(id);
        return new Response("200","OK",product);
    }

    @GetMapping("/soa/products")
    public Object list(){
        return new Response("200","OK",productMapper.queryByList());
    }

    @DeleteMapping("/soa/product/{id}")
    public Object delete(@PathVariable Integer id){

       Integer res = productMapper.delete(id);
       return res==1 ? new Response("200","OK") : new Response("500","Fail");
    }

    @PutMapping("/soa/product/update")
    public Object update(Product product){

        Integer res = productMapper.update(product);
        return res==1 ? new Response("200","OK") : new Response("500","Fail");
    }

}
