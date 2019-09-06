package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;
import pl.coderslab.model.UserDetail;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/userInfo")
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserDao userDao = new UserDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        User user = userDao.read(userId);
        SolutionDao solutionDao = new SolutionDao();
        List<Solution> allByUserId = solutionDao.findAllByUserId(userId);

        List<UserDetail> userDetailList = new ArrayList<>();

        for(Solution item : allByUserId){
            UserDetail userDetail = new UserDetail();
            userDetail.setCreate(item.getCreated());
            userDetail.setExerciseTitle(exerciseDao.read(item.getUserId()).getTitle());
            userDetail.setSolutionId(item.getId());
            userDetailList.add(userDetail);
        }


        request.setAttribute("userDetailList",userDetailList);

        getServletContext().getRequestDispatcher("/userDetails.jsp").forward(request,response);

    }
}
