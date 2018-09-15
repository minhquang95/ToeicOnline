package vn.myclass.controller.login;

import org.apache.log4j.Logger;
import vn.myclass.command.UserCommand;
import vn.myclass.core.dto.CheckLoginDTO;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.service.dao.UserService;
import vn.myclass.core.service.daoimpl.UserServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

@WebServlet(urlPatterns ={"/login.html","/registerLogin.html"} )
public class LoginController extends HttpServlet {
    private final Logger log = Logger.getLogger(this.getClass());
    ResourceBundle bundle = ResourceBundle.getBundle("ResourcesBundle");
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action.equals(WebConstant.LOGIN)) {
            RequestDispatcher rd = request.getRequestDispatcher("/views/web/login.jsp");
            rd.forward(request, response);
        }
//        } else if(action.equals(WebConstant.LOGOUT)) {
//            SessionUtil.getInstance().remove(request, WebConstant.LOGIN_NAME);
//            response.sendRedirect("/home.html");
//        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserCommand userCommand = FormUtil.populate(UserCommand.class,request);
        UserDTO userDTO = userCommand.getPojo();
        UserService userService = new UserServiceImpl();
        if(userCommand != null && userCommand.getUrlType().equals("url_loginRegister")){
            boolean flag = userService.saveUser(userDTO);
            if(flag ){
                request.setAttribute("Đăng Kí Thành Công", userCommand.getMessageResponse());
            }
        } else if (userCommand != null && userCommand.getUrlType().equals("url_Login")){
            CheckLoginDTO checkLoginDTO = userService.checkLogin(userDTO.getUsername(),userDTO.getPassword());
            if(checkLoginDTO.getRoleName().equals(WebConstant.ROLE_ADMIN)){
                response.sendRedirect("/admin-home.html");
            } else if (checkLoginDTO.getRoleName().equals(WebConstant.ROLE_USER)){
                response.sendRedirect("/home.html");
            }
        }

    }
}