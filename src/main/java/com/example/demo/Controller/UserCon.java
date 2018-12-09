package com.example.demo.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.example.demo.dao.UserDao;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 1 on 2018/12/9.
 */
@RestController
public class UserCon {

    @Autowired
    UserDao userDao;


    @ApiOperation(value=" 获取一条线路上下行预测发车时间和行驶时间的关系", notes="根据时间和线路id来获取用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "yearMonthDay", value = "时间", required = true, dataType = "String"),
            @ApiImplicitParam(name = "lineId", value = "线路id", required = true, dataType = "Integer")
    })
    @GetMapping("/getUser")
    String getUser(String yearMonthDay, Integer lineId){
        return JSON.toJSONString(userDao.getUser(), SerializerFeature.WriteMapNullValue);
    }

    @ApiOperation(value=" 获取一条线路根据id", notes="根据线路id查询信息")
    @ApiImplicitParam(name = "id", value = "线路id", required = true, dataType = "Integer")
    @GetMapping("/getUserById")
    String getUserById(Integer id){
        return userDao.getUser().toString();
    }
}
