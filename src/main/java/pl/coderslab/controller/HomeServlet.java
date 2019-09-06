package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.MainViewData;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/")
public class HomeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        UserDao userDao= new UserDao();
        ExerciseDao exerciseDao = new ExerciseDao();
        int limitRows = Integer.parseInt(request.getServletContext().getInitParameter("number-solutions"));
        List<Solution> solutions = solutionDao.findRecent(limitRows);

        List<MainViewData> mainViewDataList = new ArrayList<>();
        for (int i=0; i< solutions.size();i++){

            int exerciseId = solutions.get(i).getExerciseId();
            int solutionId = solutions.get(i).getUserId();
            Exercise exercise = exerciseDao.read(exerciseId);
            User user = userDao.read(solutionId);
            if (exercise != null && user !=null ){
                mainViewDataList.add(new MainViewData(exercise.getTitle(),user.getUserName(),solutions.get(i).getCreated(),solutions.get(i).getId()));

            }
        }

        request.setAttribute("mainViewDataList",mainViewDataList);

        getServletContext().getRequestDispatcher("/first.jsp").forward(request,response);
    }
}
