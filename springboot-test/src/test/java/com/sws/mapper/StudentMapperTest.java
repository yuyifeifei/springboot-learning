package com.sws.mapper;

import com.sws.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @Description
 * @Author 夜羽 <416282949@qq.com>
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2018/9/16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentMapperTest {
    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void deleteByPrimaryKey() {
    }

    @Test
    public void insert() {
        Student student = new Student();
        student.setBirthday(new Date().toString());
        student.setName("范冰冰");
        student.setAge(37);
        int insert = studentMapper.insert(student);
        System.out.println(insert);

    }

    @Test
    public void insertSelective() {
    }

    @Test
    public void selectByPrimaryKey() {
        Student student = studentMapper.selectByPrimaryKey(1L);
        System.out.println(student.toString());

    }

    @Test
    public void updateByPrimaryKeySelective() {
    }

    @Test
    public void updateByPrimaryKey() {
    }
}