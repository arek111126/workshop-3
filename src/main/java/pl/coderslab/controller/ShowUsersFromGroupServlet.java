package pl.coderslab.controller;

import pl.coderslab.dao.UserDao;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/uzytkownicyGrupy")
public class ShowUsersFromGroupServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int groupId = Integer.parseInt(request.getParameter("id"));
        String groupName = request.getParameter("name");

        UserDao userDao = new UserDao();

        List<User> usersFromGroups = userDao.findAllByGroupId(groupId);

        request.setAttribute("usersFromGroups",usersFromGroups);
        request.setAttribute("groupName",groupName);

        getServletContext().getRequestDispatcher("/usersInGroups.jsp").forward(request,response);

    }
}
