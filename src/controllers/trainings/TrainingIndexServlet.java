package controllers.trainings;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Training;
import utils.DBUtil;

/**
 * Servlet implementation class TrainingIndexServlet
 */
@WebServlet("/trainings/index")
public class TrainingIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    EntityManager em = DBUtil.createEntityManager();

    int page;
    try{
        page = Integer.parseInt(request.getParameter("page"));
    }catch(Exception e){
        page = 1;
    }
    List<Training> trainings = em.createNamedQuery("getAllTrainings", Training.class)
                                  .setFirstResult(15 * (page - 1))
                                  .setMaxResults(15)
                                  .getResultList();

    long trainings_count = (long)em.createNamedQuery("getTrainingsCount", Long.class)
                                    .getSingleResult();

    em.close();

    request.setAttribute("trainings", trainings);
    request.setAttribute("trainings_count", trainings_count);
    request.setAttribute("page", page);
    if(request.getSession().getAttribute("flush") != null){
        request.setAttribute("flush", request.getSession().getAttribute("flush"));
        request.getSession().removeAttribute("flush");
    }

    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/trainings/index.jsp");
    rd.forward(request, response);

    }

}
