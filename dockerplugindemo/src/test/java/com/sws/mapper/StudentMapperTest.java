package com.sws.mapper;

import com.sws.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/15
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testInsert(){
        Student student = new Student();
        student.setAge(21);
        student.setName("lisisi");
        student.setBirthday(new Date().toString());
        studentMapper.insert(student);
    }

    @Test
    public void testFindAll(){
        Student student = studentMapper.selectByPrimaryKey(1l);
        System.out.println(student.toString());
    }
}