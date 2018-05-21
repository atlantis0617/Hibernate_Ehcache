package org.hibernate.model;

import java.util.Date;

public class Student {
	private long id;// 学号
    private String name;// 姓名
    private Date birthday;// 生日
    private String sex;// 性别
    
    public Student() {
    
    }
 
    public Student(long id, String name, Date birthday, String sex) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

}
