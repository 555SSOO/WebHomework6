package webapp;

import beans.Grade;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "webapp.ServletForm", urlPatterns = {"/grade"})
public class ServletForm extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession();
        String assistant_name = request.getParameter("assistant_name");
        Double grade_double = 0.0;
        if(!assistant_name.equalsIgnoreCase("VUK")){
            grade_double = Double.valueOf(request.getParameter("grade"));
        }

        List<Grade> grade_list = (List<Grade>)session.getAttribute("gradeList");
        if(grade_list != null){
            // if the assistant is already in the list
            if(grade_list.stream().anyMatch(grade -> grade.getAssistant_name().equalsIgnoreCase(assistant_name))){
                Double finalGrade_double = grade_double;
                grade_list.stream().filter(grade -> grade.getAssistant_name().equalsIgnoreCase(assistant_name)).forEach(grade -> grade.setGrade((grade.getGrade()+ finalGrade_double)/2));
            }
            else {
                grade_list.add(new Grade(assistant_name, grade_double));
            }
        }
        else{
            grade_list = new ArrayList<>();
            grade_list.add(new Grade(assistant_name, grade_double));
        }
        session.setAttribute("gradeList", grade_list);

        RequestDispatcher disp = getServletContext()
                .getRequestDispatcher("/index.jsp");
        disp.forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RequestDispatcher disp = getServletContext()
                .getRequestDispatcher("/results.jsp");
        disp.forward(request, response);
    }


}
