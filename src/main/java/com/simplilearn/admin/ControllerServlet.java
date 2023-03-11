package com.simplilearn.admin;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.simplilearn.models.Student;
import com.simplilearn.models.Subject;
import com.simplilearn.models.Teacher;
import com.simplilearn.models.Class;

@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
  private static final long serialVersionUID = 1 ;

  private DbRetrieve dbRetrieve;

  @Resource(name = "jdbc_database")
  private DataSource db;

  @Override
  public void init() throws ServletException {

    super.init();

    try {
      dbRetrieve = new DbRetrieve(db);

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

  public ControllerServlet() {
    super();

  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    doGet(req, resp);
  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {

    try {

      String destination = request.getParameter("destination");

      if (destination == null) {
        destination = "CLASSES";
      }

      if (!getCookies(request, response) && (!destination.equals("LOGIN"))) {

        response.sendRedirect("/Administrative-Portal/login.jsp");
      } else {

        switch (destination) {

        case "STUDENTS":
          studentsList(request, response);
          break;

        case "TEACHERS":
          teachersList(request, response);
          break;

        case "SUBJECTS":
          subjectList(request, response);
          break;

        case "CLASSES":
          classestList(request, response);
          break;

        case "STUDENTS_LIST":
          classStudentsList(request, response);
          break;

        case "LOGIN":
          login(request, response);
          break;

        default:
          classestList(request, response);

        }
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

  private void studentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List < Student > students = dbRetrieve.getStudents();

    request.setAttribute("STUDENT_LIST", students);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/students.jsp");
    dispatcher.forward(request, response);

  }

  private void teachersList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List < Teacher > teachers = dbRetrieve.getTeachers();

    request.setAttribute("TEACHER_LIST", teachers);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/teachers.jsp");
    dispatcher.forward(request, response);

  }

  private void subjectList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List < Subject > subjects = dbRetrieve.getSubjects();

    request.setAttribute("SUBJECT_LIST", subjects);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/subjects.jsp");
    dispatcher.forward(request, response);

  }

  private void classestList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    List < Class > classes = dbRetrieve.getClasses();

    request.setAttribute("CLASS_LIST", classes);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/classes.jsp");
    dispatcher.forward(request, response);

  }

  private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
    String username = request.getParameter("username");
    String password = request.getParameter("password");

    if (username.toLowerCase().equals("admin") && password.toLowerCase().equals("admin")) {

      Cookie cookie = new Cookie(username, password);

      cookie.setMaxAge(100400);

      response.addCookie(cookie);
      classestList(request, response);
    } else {
      RequestDispatcher dispatcher = request.getRequestDispatcher("/login.jsp");
      dispatcher.forward(request, response);
    }

  }

  private void classStudentsList(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int classId = Integer.parseInt(request.getParameter("classId"));
    String section = request.getParameter("section");
    String subject = request.getParameter("subject");

    List < Student > students = dbRetrieve.loadClassStudents(classId);

    request.setAttribute("STUDENT_LIST", students);
    request.setAttribute("SECTION", section);
    request.setAttribute("SUBJECT", subject);

    RequestDispatcher dispatcher = request.getRequestDispatcher("/classStudents.jsp");
    dispatcher.forward(request, response);

  }

  private boolean getCookies(HttpServletRequest request, HttpServletResponse response) throws Exception {

    boolean check = false;
    Cookie[] cookies = request.getCookies();

    for (Cookie cookie: cookies) {

      if (cookie.getName().equals("admin") && cookie.getValue().equals("admin")) {
        check = true;
        break;
      }

    }
    return check;
  }
}