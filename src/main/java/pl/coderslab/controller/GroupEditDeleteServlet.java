package pl.coderslab.controller;

import pl.coderslab.dao.GroupsDao;
import pl.coderslab.model.Group;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.util.List;

@WebServlet("/editGroupsServlet")
public class GroupEditDeleteServlet extends HttpServlet {
    GroupsDao groupsDao = new GroupsDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        int id = Integer.parseInt(request.getParameter("id"));
        Group group = new Group(title);
        group.setId(id);
        groupsDao.update(group);
        response.sendRedirect("/showGroupsServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));
        if (action.equals("delete")){

            Group group = new Group();
            group.setId(id);
            groupsDao.delete(group);
            response.sendRedirect("/showGroupsServlet");


        }else if (action.equals("edit")){
            request.setAttribute("id",id);
            getServletContext().getRequestDispatcher("/editGroup.jsp").forward(request,response);
        }
    }
}
