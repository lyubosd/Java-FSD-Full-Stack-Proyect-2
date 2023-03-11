package com.simplilearn.models;

public class Student {

  private int id;
  private String name;
  private String surname;
  private int age;
  private int aclass;

  public Student(int id, String fname, String lname, int age, int aclass) {
    super();
    this.id = id;
    this.name = fname;
    this.surname = lname;
    this.age = age;
    this.aclass = aclass;
  }

  public int getId() {
    return id;
  }
  public void setId(int id) {
    this.id = id;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public String getSurname() {
    return surname;
  }
  public void setSurname(String surname) {
    this.surname = surname;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public int getAclass() {
    return aclass;
  }
  public void setAclass(int aclass) {
    this.aclass = aclass;
  }

  @Override
  public String toString() {
    return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", age=" + age + ", aclass=" + aclass +
      "]";
  }

}