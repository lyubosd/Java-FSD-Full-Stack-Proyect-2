package com.simplilearn.admin;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.simplilearn.models.Student;
import com.simplilearn.models.Subject;
import com.simplilearn.models.Teacher;
import com.simplilearn.models.Class;

public class DbRetrieve {

  private DataSource dataSource;

  public DbRetrieve(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public List < Student > getStudents() {

    List < Student > students = new ArrayList < > ();

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM student";
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        String name = myRs.getString("name");
        String surname = myRs.getString("surname");
        int age = myRs.getInt("age");
        int class_id = myRs.getInt("class");

        Student tempStudent = new Student(id, name, surname, age, class_id);

        students.add(tempStudent);

      }

    } catch (Exception e) {} finally {
      close(myConn, myStmt, myRs);
    }
    return students;

  }

  public List < Teacher > getTeachers() {

    List < Teacher > teachers = new ArrayList < > ();

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM teacher";
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        String firstName = myRs.getString("name");
        String lastName = myRs.getString("surname");
        int age = myRs.getInt("age");

        Teacher temp = new Teacher(id, firstName, lastName, age);

        teachers.add(temp);

      }

    } catch (Exception e) {

    } finally {

      close(myConn, myStmt, myRs);
    }
    return teachers;

  }

  public List < Subject > getSubjects() {

    List < Subject > subjects = new ArrayList < > ();

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM subject";
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        String name = myRs.getString("name");
        String description = myRs.getString("description");

        Subject temp = new Subject(id, name, description);

        subjects.add(temp);

      }

    } catch (Exception e) {

    } finally {

      close(myConn, myStmt, myRs);
    }
    return subjects;

  }

  public List < Class > getClasses() {

    List < Class > classes = new ArrayList < > ();

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM class";
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        int section = myRs.getInt("section");
        int subject = myRs.getInt("subject");
        int teacher = myRs.getInt("teacher");

        Teacher tempTeacher = loadTeacher(teacher);
        Subject tempSubject = loadSubject(subject);

        String teacher_name = tempTeacher.getName() + " " + tempTeacher.getName();

        Class temp = new Class(id, section, teacher_name, tempSubject.getName());

        classes.add(temp);

      }

    } catch (Exception e) {

    } finally {

      close(myConn, myStmt, myRs);
    }
    return classes;

  }

  public Teacher loadTeacher(int teacherId) {

    Teacher theTeacher = null;

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM teacher WHERE id = " + teacherId;
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        String name = myRs.getString("name");
        String surname = myRs.getString("surname");
        int age = myRs.getInt("age");
        theTeacher = new Teacher(id, name, surname, age);

      }

    } catch (Exception e) {

    } finally {

      close(myConn, myStmt, myRs);
    }
    return theTeacher;

  }

  public Subject loadSubject(int subjectId) {

    Subject theSubject = null;

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM subject WHERE id = " + subjectId;
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        String name = myRs.getString("name");
        String description = myRs.getString("description");

        theSubject = new Subject(id, name, description);

      }

    } catch (Exception e) {

    } finally {

      close(myConn, myStmt, myRs);
    }
    return theSubject;

  }

  public Class loadClass(int classId) {

    Class theClass = null;

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM clas WHERE id = " + classId;
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        int section = myRs.getInt("section");
        int subject = myRs.getInt("subject");
        int teacher = myRs.getInt("teacher");

        Teacher tempTeacher = loadTeacher(teacher);
        Subject tempSubject = loadSubject(subject);

        String teacher_name = tempTeacher.getName() + " " + tempTeacher.getSurname();

      }

    } catch (Exception e) {

    } finally {

      close(myConn, myStmt, myRs);
    }
    return theClass;

  }

  public List < Student > loadClassStudents(int classId) {

    List < Student > students = new ArrayList < > ();

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    try {

      myConn = dataSource.getConnection();

      String sql = "SELECT * FROM student WHERE class = " + classId;
      myStmt = myConn.createStatement();

      myRs = myStmt.executeQuery(sql);

      while (myRs.next()) {

        int id = myRs.getInt("id");
        String name = myRs.getString("name");
        String surname = myRs.getString("surname");
        int age = myRs.getInt("age");
        int aclass = myRs.getInt("class");

        Student tempStudent = new Student(id, name, surname, age, aclass);
        students.add(tempStudent);

      }

    } catch (Exception e) {

    } finally {

      close(myConn, myStmt, myRs);
    }
    return students;

  }

  private void close(Connection myConn, Statement myStmt, ResultSet myRs) {

    try {
      if (myRs != null) {
        myRs.close();
      }
      if (myStmt != null) {
        myStmt.close();
      }
      if (myConn != null) {
        myConn.close();
      }

    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}