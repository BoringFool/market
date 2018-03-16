package com.zm.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="t_course")
public class Course
{
    private int id;
    private String name;
    private Set<Teacher> teachers;
    
    public Course()
    {
        teachers = new HashSet<Teacher>();
    }
    public void addTeacher(Teacher teacher)
    {
        teachers.add(teacher);
    }
    @ManyToMany//　ManyToMany指定多对多的关联关系
    //因为多对多之间会通过一张中间表来维护两表直接的关系，所以通过 JoinTable 这个注解来声明，name就是
    //指定了中间表的名字，JoinColumns是一个 @JoinColumn类型的数组，表示的是我这方在对方中的外键名称，我
    //方是Course，所以在对方外键的名称就是 rid，inverseJoinColumns也是一个 @JoinColumn类型的数组，表示的
    //是对方在我这放中的外键名称，对方是Teacher，所以在我方外键的名称就是 tid
    @JoinTable(name="t_teacher_course", joinColumns={ @JoinColumn(name="cid")}, 
    inverseJoinColumns={ @JoinColumn(name = "tid") })
    public Set<Teacher> getTeachers()
    {
        return teachers;
    }

    public void setTeachers(Set<Teacher> teachers)
    {
        this.teachers = teachers;
    }

    @Id
    @GeneratedValue
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

}
