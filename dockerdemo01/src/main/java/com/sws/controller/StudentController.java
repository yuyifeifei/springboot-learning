package com.sws.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.sws.mapper.StudentMapper;
import com.sws.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/15
 */
@RestController
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @RequestMapping(value = "/student/{id}",method = RequestMethod.GET)
    public Student  showStudent(@PathVariable(value = "id") Long id){
        Student student = studentMapper.selectByPrimaryKey(id);
        System.out.println(student);
        return student;
    }

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String  showStudent(){
        System.out.println("showindex");
        System.out.println("index");
        return "index";
    }
}
