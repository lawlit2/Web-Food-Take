package com.example.controller;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSON;
import com.example.common.Result;
import com.example.common.enums.ResultCodeEnum;
import com.example.entity.User;
import com.example.service.UserService;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户表前端操作接口
 **/
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody User user) {
        // 数据校验
        if (ObjectUtil.isEmpty(user.getUsername()) || ObjectUtil.isEmpty(user.getPassword())) {
            return Result.error(ResultCodeEnum.PARAM_LOST_ERROR);
        }
        userService.add(user);
        return Result.success();
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public Result deleteById(@PathVariable Integer id) {
        userService.deleteById(id);
        return Result.success();
    }

    /**
     * 批量删除
     */
    @DeleteMapping("/delete/batch")
    public Result deleteBatch(@RequestBody List<Integer> ids) {
        userService.deleteBatch(ids);
        return Result.success();
    }

    /**
     * 修改
     */
    @PutMapping("/update")
    public Result updateById(@RequestBody User user) {
        userService.updateById(user);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/selectById/{id}")
    public Result selectById(@PathVariable Integer id) {
        User user = userService.selectById(id);
        return Result.success(user);
    }

    /**
     * 查询所有
     */
    @GetMapping("/selectAll")
    public Result selectAll(User user ) {
        List<User> list = userService.selectAll(user);
        return Result.success(list);
    }

    /**
     * 分页查询
     */
    @GetMapping("/selectPage")
    public Result selectPage(User user,
                             @RequestParam(defaultValue = "1") Integer pageNum,
                             @RequestParam(defaultValue = "10") Integer pageSize) {
        PageInfo<User> page = userService.selectPage(user, pageNum, pageSize);
        return Result.success(page);
    }

    @PostMapping("/Integral/add")
    public String  AddIntegral(@RequestParam("id") int  id,
                               @RequestParam("integral") int integral){
        Map<String, Object> result = new HashMap<>();
        if(userService.AddIntegralById(id,integral)){
            result.put("message","积分修改/添加成功");
            result.put("success",true);
        }else{
            result.put("message","积分修改/添加失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }

    @PostMapping("/Integral/delete")
    public String DeleteIntegral(@RequestParam("id") int id){
        Map<String, Object> result = new HashMap<>();
        if(userService.DeleteIntegralById(id)){
            result.put("message","积分删除成功");
            result.put("success",true);
        }else{
            result.put("message","积分删除失败");
            result.put("success",false);
        }
        return JSON.toJSONString(result);
    }

    @PostMapping("/Integral/Select")
    public String SelectIntegral(@RequestBody Map<String, Object> payload) {
        int id = (int) payload.get("id");
        Map<String, Object> result = new HashMap<>();
        result.put("Integral", userService.SelectIntegralById(id));
        return JSON.toJSONString(result);
    }
}