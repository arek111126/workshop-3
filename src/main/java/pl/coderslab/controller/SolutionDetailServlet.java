package pl.coderslab.controller;

import pl.coderslab.dao.SolutionDao;
import pl.coderslab.dao.UserDao;
import pl.coderslab.model.Solution;
import pl.coderslab.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/solutionDetail")
public class SolutionDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SolutionDao solutionDao = new SolutionDao();
        int solutionId = Integer.parseInt(request.getParameter("id"));
        Solution solution = solutionDao.read(solutionId);
        request.setAttribute("solution",solution);
        getServletContext().getRequestDispatcher("/solutionDetail.jsp").forward(request,response);
    }
}
