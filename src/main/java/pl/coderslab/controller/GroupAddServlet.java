package pl.coderslab.controller;

import pl.coderslab.dao.GroupsDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addNewGroup")
public class GroupAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupsDao groupsDao = new GroupsDao();
        String title = request.getParameter("title");
        groupsDao.create(new Group(title));
        response.sendRedirect("/showGroupsServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/addGroup.jsp").forward(request,response);
    }
}
