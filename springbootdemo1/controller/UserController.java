package com.demo.springbootdemo.controller;

import com.demo.springbootdemo.entity.Users;
import com.demo.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("users")
class UsersController {
    @Resource
    private UserService usersService;
/*
    @GetMapping("/hello")
    public Map<String,Object> hello(){
        Map<String,Object> result = new HashMap<String,Object>();
        result.put("code",200);
        result.put("data","hello!");
        return result;
    }
*/
    @GetMapping("auth")
    public Map<String,Object> login(String identify, String password){
        Map<String,Object> result = new HashMap<String,Object>();
        Users loginUser =  usersService.login(identify,password);
        if(loginUser!=null){
            result.put("code",200);
            result.put("data",loginUser);
            result.put("msg","loginSuccess");
        }else{
            result.put("code",400);
            result.put("data",null);
            result.put("msg","loginFailure");
        }
        return result;
    }
    //如果是处理post请求，请求参数必须使用@RequestBody,这个参数仅仅只有一个。
    //本身接受的就是一个json对象。
    @PostMapping("/")
    public Map<String, Object> reg(@RequestBody Users user) {

        System.out.println("要注册的用户资料是：" + user);
        Map<String, Object> result = new HashMap<String, Object>();
        //先判断该手机号码是否已经被注册过。如果注册过返回失败。
        if(usersService.checkMobileIsExit(user.getMobile())){
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "该手机号码已经被注册！");
            return result;
        }

        Users regUser = usersService.reg(user);

        if (regUser != null) {
            result.put("code", 200);
            result.put("data", regUser);
            result.put("msg", "regSuccess");
        } else {
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "程序出现异常，注册失败！");
        }
        return result;
    }
    @GetMapping("/{id}")
    public Map<String,Object> queryUserById(@PathVariable("id")int id){
        Map<String,Object> result = new HashMap<String,Object>();
        Users user =   usersService.queryUserById(id);
        System.out.println(user);
        if(user!=null){
            result.put("code",200);
            result.put("data",user);
            result.put("msg","querySuccess");
        }else{
            result.put("code",400);
            result.put("data",null);
            result.put("msg","queryFailure");
        }
        return result;
    }
    @PutMapping("/{id}")
    public Map<String,Object> updateUserById(@PathVariable("id")int id,@RequestBody Users user){
            //String username,String mobile,String email,String password,String gender,String birthday,String pic) {
        Map<String,Object> result = new HashMap<String,Object>();
        //Users user =   usersService.queryUserById(id);
        user = usersService.updateUser(user);
        /*
        olduser.setUsername(username);
        olduser.setMobile(mobile);
        olduser.setEmail(email);
        olduser.setPassword(password);
        olduser.setGender(gender);
        olduser.setBirthday(birthday);
        olduser.setPic(pic);
        */
        if(user!=null){
            result.put("code",200);
            result.put("data",user);
            result.put("msg","updateSuccess");
        }else{
            result.put("code",400);
            result.put("data",null);
            result.put("msg","updateFailure");
        }
        return result;
    }
    @DeleteMapping("/{id}")
    public Map<String,Object> deleteUserById(@PathVariable("id")int id) {
        Map<String,Object> result = new HashMap<String,Object>();
        if(usersService.deleteUser(id)){
            result.put("code",200);
            result.put("data",null);
            result.put("msg","deleteSuccess");
        }else{
            result.put("code",400);
            result.put("data",null);
            result.put("msg","deleteFailure");
        }
        return result;
    }

    @GetMapping("/query")
    public Map<String, Object> queryAllUsers(){
        Map<String, Object> result = new HashMap<String, Object>();
        List<Users> usersList = usersService.queryAllUsers();
        if(usersList!=null){
            result.put("code", 200);
            result.put("data", usersList);
            result.put("msg", "querySuccess");
        }else{
            result.put("code", 400);
            result.put("data", null);
            result.put("msg", "queryFailure");
        }
        return result;
    }
    //@ApiOperation("上传头像")
    @PostMapping("/headImg")
    @ResponseBody
    public Object headImg(MultipartFile file) {
        // 将文件接收后，存放一个固定地方，然后将路径拿过来
        String name = file.getOriginalFilename();
        try {
            // 存放在D盘
            file.transferTo(new File("D:\\crowd-funding\\media\\"+name));
        }catch (IOException e){
            e.printStackTrace();
            return "error";
        }
        return "OK";
    }
}