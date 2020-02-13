package controllers.trainings;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Training;
import models.validators.TrainingValidator;
import utils.DBUtil;

/**
 * Servlet implementation class TrainingUpdateServlet
 */
@WebServlet("/trainings/update")
public class TrainingUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = (String)request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            Training t = em.find(Training.class, (Integer)(request.getSession().getAttribute("training_id")));

            t.setTraining_date(Date.valueOf(request.getParameter("training_date")));

            t.setTitle(request.getParameter("title"));
            t.setPushup(Integer.parseInt(request.getParameter("pushup")));
            t.setKensui(Integer.parseInt(request.getParameter("kensui")));
            t.setSideraise(Integer.parseInt(request.getParameter("sideraise")));
            t.setAbs(Integer.parseInt(request.getParameter("abs")));
            t.setSquat(Integer.parseInt(request.getParameter("squat")));

            t.setUpdated_at(new Timestamp(System.currentTimeMillis()));

            List<String> errors = TrainingValidator.validate(t);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("training", t);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/trainings/edit.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "更新が完了しました。");

                request.getSession().removeAttribute("training_id");

                response.sendRedirect(request.getContextPath() + "/trainings/index");
            }
        }

    }

}
