package vn.myclass.controller.admin;

import org.apache.commons.lang.StringUtils;
import vn.myclass.command.ListenGuidelineCommand;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.service.dao.ListenGuidelineService;
import vn.myclass.core.service.daoimpl.ListenGuidelineServiceImpl;
import vn.myclass.core.web.common.WebConstant;
import vn.myclass.core.web.utils.FormUtil;
import vn.myclass.core.web.utils.RequestUtil;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = {"/admin-guideline-listen-list.html"})
public class ListenGuidelineController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ListenGuidelineCommand command = FormUtil.populate(ListenGuidelineCommand.class , request);
        ListenGuidelineService listenGuidelineService = new ListenGuidelineServiceImpl();

        List<ListenGuidelineDTO> listenGuidelineDTOS = listenGuidelineService.findall();
        command.setListResult(listenGuidelineDTOS);
        request.setAttribute(WebConstant.LIST_ITEMS,command);
        RequestDispatcher rd = request.getRequestDispatcher("/views/admin/listenguideline/list.jsp");
        rd.forward(request, response);
    }

}