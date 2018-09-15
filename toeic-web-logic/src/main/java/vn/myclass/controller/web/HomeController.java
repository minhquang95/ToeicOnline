package vn.myclass.controller.web;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Ki Thuat 88 on 9/7/2018.
 */
@WebServlet("/home.html")
public class HomeController extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
        rd.forward(request,response);
    }
}
