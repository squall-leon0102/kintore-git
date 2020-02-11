package controllers.trainings;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Training;

/**
 * Servlet implementation class TrainingNewServlet
 */
@WebServlet("/trainings/new")
public class TrainingNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());

        Training t = new Training();
        t.setTraining_date(new Date(System.currentTimeMillis()));
        request.setAttribute("training", t);

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/trainings/new.jsp");
        rd.forward(request, response);
    }

}
