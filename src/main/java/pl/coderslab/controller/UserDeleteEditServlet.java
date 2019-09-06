package pl.coderslab.controller;

import pl.coderslab.dao.GroupsDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Group;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/userEditAndDelete")
public class UserDeleteEditServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String userName = request.getParameter("userName");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        int groupId = Integer.parseInt(request.getParameter("groupId"));
        UserDao userDao = new UserDao();
        userDao.update(new User(id,email,userName,password,groupId));
        response.sendRedirect("/userShow");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String action = request.getParameter("action");
        UserDao userDao = new UserDao();
        SolutionDao solutionDao = new SolutionDao();
        GroupsDao groupsDao = new GroupsDao();
        List<Group> allGroups = groupsDao.findAll();
        if (action.equals("delete")) {
            List<Solution> allByUserById = solutionDao.findAllByUserId(id);
            User user = new User();
            user.setId(id);
            for (Solution item : allByUserById) {
                solutionDao.delete(item);
            }
            userDao.delete(user);
            response.sendRedirect("/userShow");
        } else if (action.equals("edit")) {
            request.setAttribute("id", id);
            request.setAttribute("allGroups", allGroups);
            getServletContext().getRequestDispatcher("/userEdit.jsp").forward(request, response);

        }




    }
}
