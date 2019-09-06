package pl.coderslab.controller;

import pl.coderslab.dao.GroupsDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showGroupsServlet")
public class GroupShowServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        GroupsDao groupsDao = new GroupsDao();
        List<Group> allGroups = groupsDao.findAll();

        request.setAttribute("allGroups",allGroups);
        getServletContext().getRequestDispatcher("/groupsShow.jsp").forward(request,response);
    }
}
