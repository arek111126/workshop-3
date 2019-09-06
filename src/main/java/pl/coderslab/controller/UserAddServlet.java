package pl.coderslab.controller;

import pl.coderslab.dao.GroupsDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userAdd")
public class UserAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        UserDao userDao = new UserDao();
        userDao.create(new User(userName,email,password,groupId));
        response.sendRedirect("/userShow");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupsDao groupsDao = new GroupsDao();
        List<Group> allGroups = groupsDao.findAll();
        request.setAttribute("allGroups",allGroups);
        getServletContext().getRequestDispatcher("/userAdd.jsp").forward(request,response);
    }
}
