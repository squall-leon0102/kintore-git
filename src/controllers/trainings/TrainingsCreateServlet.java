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
import models.User;
import models.validators.TrainingValidator;
import utils.DBUtil;

/**
 * Servlet implementation class TrainingsCreateServlet
 */
@WebServlet("/trainings/create")
public class TrainingsCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrainingsCreateServlet() {
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

            Training t = new Training();

            t.setUser((User)request.getSession().getAttribute("login_user"));

            Date training_date = new Date(System.currentTimeMillis());
            String rd_str = request.getParameter("training_date");
            if(rd_str != null && !rd_str.equals("")) {
                training_date = Date.valueOf(request.getParameter("training_date"));
            }
            t.setTraining_date(training_date);

            t.setTitle(request.getParameter("title"));
            t.setPushup(Integer.parseInt(request.getParameter("pushup")));
            t.setKensui(Integer.parseInt(request.getParameter("kensui")));
            t.setSideraise(Integer.parseInt(request.getParameter("sideraise")));
            t.setAbs(Integer.parseInt(request.getParameter("abs")));
            t.setSquat(Integer.parseInt(request.getParameter("squat")));

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            t.setCreated_at(currentTime);
            t.setUpdated_at(currentTime);

            List<String> errors = TrainingValidator.validate(t);
            if(errors.size() > 0) {
                em.close();

                request.setAttribute("_token", request.getSession().getId());
                request.setAttribute("training", t);
                request.setAttribute("errors", errors);

                RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/trainings/new.jsp");
                rd.forward(request, response);
            } else {
                em.getTransaction().begin();
                em.persist(t);
                em.getTransaction().commit();
                em.close();
                request.getSession().setAttribute("flush", "登録が完了しました。");

                response.sendRedirect(request.getContextPath() + "/trainings/index");
            }
        }
    }

}