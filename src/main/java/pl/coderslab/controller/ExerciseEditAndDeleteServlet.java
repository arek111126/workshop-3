package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.dao.SolutionDao;
import pl.coderslab.model.Exercise;
import pl.coderslab.model.Solution;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/exerciseEdit")
public class ExerciseEditAndDeleteServlet extends HttpServlet {
    ExerciseDao exerciseDao = new ExerciseDao();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        Exercise exercise = new Exercise(title,description);
        exercise.setId(id);
        exerciseDao.update(exercise);
        response.sendRedirect("/ExercisesShow");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        SolutionDao solutionDao = new SolutionDao();
        int id = Integer.parseInt(request.getParameter("id"));
        if (action.equals("delete")){
            Exercise exercise = new Exercise();
            exercise.setId(id);

            List<Solution> allByExerciseId = solutionDao.findAllByExerciseId(id);
        for (Solution item : allByExerciseId){
            solutionDao.delete(item);
        }
            exerciseDao.delete(exercise);
            response.sendRedirect("/ExercisesShow");
        }else if (action.equals("edit")){

            request.setAttribute("id",id);

            getServletContext().getRequestDispatcher("/exerciseEdit.jsp").forward(request,response);
        }


    }
}
