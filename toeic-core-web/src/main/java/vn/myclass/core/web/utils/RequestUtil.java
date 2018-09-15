package vn.myclass.core.web.utils;

import org.apache.commons.lang.StringUtils;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;
import vn.myclass.core.web.command.AbstractCommand;

import javax.servlet.http.HttpServletRequest;

public class RequestUtil  {
    public static void initSearchBean(HttpServletRequest request, AbstractCommand bean){
        String sortExpression = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_SORT));
        String sortDirection = request.getParameter(new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_ORDER));
        String pageStr = request.getParameter((new ParamEncoder(bean.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE)));

        int page = 1;

        if(StringUtils.isNotBlank(pageStr)){
            page = Integer.valueOf(pageStr);
        }

        bean.setSortExpression(sortExpression);
        bean.setSortDirection(sortDirection);
        bean.setPage(page);
        bean.setFirstItem((bean.getPage() - 1) * bean.getMaxPageItems());
    }
}