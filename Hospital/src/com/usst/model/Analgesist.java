package com.usst.model;

public class Analgesist {

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Analgesist( Integer id, String name, String gender, Integer age, String number,String password) {
        this.password = password;
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.number = number;
    }

    public Analgesist() {
    }

    private Integer id;

    private String name;

    private String gender;

    private Integer age;

    private String number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Analgesist(Integer id, String name, String gender, Integer age, String number) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.number = number;
    }
}