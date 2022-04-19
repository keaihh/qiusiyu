package com.fc.controller;

import com.fc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("annotation")
public class AnnotationController {
    @RequestMapping("testRequestParam")
    public String testRequestParam(@RequestParam(value = "userid",required = false,defaultValue = "1") String id){
        System.out.println("从前端获取的请求参数"+id);
        return "/success.jsp";
    }

    @RequestMapping("page")
    public String page(@RequestParam(value = "pageNo",defaultValue = "1") Integer pageNo,@RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize){
//        PageHelper.startPage(pageNo,pageSize);
        System.out.println("当前页"+pageNo+"每页多少条数据"+pageSize);
        return "/success.jsp";
    }
    //    @RequestMapping(value = "user/{id}",produces = "test/html;charset=UTF-8",method = RequestMethod.GET)
    @GetMapping(value = "user/{id}",produces = "test/html;charset=UTF-8")
    @ResponseBody
    public String getUser(@PathVariable("id") String id){
        System.out.println("查询id为"+id+"学生");
        return "查询id为"+id+"学生";
    }
    //    @RequestMapping(value = "user/{id}",produces = "test/html;charset=UTF-8",method = RequestMethod.DELETE)
    @DeleteMapping(value = "user/{id}",produces = "test/html;charset=UTF-8")
    @ResponseBody
    public String deleteUser(@PathVariable("id") String id){
        System.out.println("删除id为"+id+"学生");

        return "删除id为"+id+"学生";

    }
//    @RequestMapping(value = "user/{id}",produces = "test/html;charset=UTF-8",method = RequestMethod.PUT)
    @PutMapping(value = "user/{id}",produces = "test/html;charset=UTF-8")
    @ResponseBody
    public String putUser(@PathVariable("id") String id){
        System.out.println("修改id为"+id+"学生");

        return "修改id为"+id+"学生";

    }
//    @RequestMapping(value = "user/{id}",produces = "test/html;charset=UTF-8",method = RequestMethod.POST)
    @PostMapping(value = "user/{id}",produces = "test/html;charset=UTF-8")
    @ResponseBody
    public String postUser(@PathVariable("id") String id){
        System.out.println("插入id为"+id+"学生");

        return "插入id为"+id+"学生";

    }

    @RequestMapping("testJsonString")
    @ResponseBody
    public String testJsonString(@RequestBody String json){
        System.out.println(json);
        return json;

    }
    @RequestMapping(value = "testJsonObject",consumes = "application/json;charset=UTF-8")
    @ResponseBody
    public void testJsonObject(@RequestBody User user){
        System.out.println(user);

    }
}
