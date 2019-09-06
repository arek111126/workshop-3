package pl.coderslab.controller;

import pl.coderslab.dao.ExerciseDao;
import pl.coderslab.model.Exercise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exerciseAdd")
public class ExerciseAddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        ExerciseDao exerciseDao = new ExerciseDao();

        exerciseDao.create(new Exercise(title,description));
        response.sendRedirect("/ExercisesShow");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/exerciseAdd.jsp").forward(request,response);
    }
}
