package vn.myclass.core.service.daoimpl;

import vn.myclass.core.dao.ListenGuidelineDao;
import vn.myclass.core.daoimpl.ListenGuidelineDaoImpl;
import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistance.data.entity.ListenGuidelineEntity;
import vn.myclass.core.service.dao.ListenGuidelineService;
import vn.myclass.core.utils.ListenGuidelineBeanUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListenGuidelineServiceImpl implements ListenGuidelineService {
    public Object[] findListenGuidelineByProperties(Map<String, Object> property, String sortExpression, String sortDirection, Integer offset, Integer limit) {
       List<ListenGuidelineDTO> list = new ArrayList<ListenGuidelineDTO>();
       ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
        Object [] objects = listenGuidelineDao.findByProperty(property, sortExpression, sortDirection, offset, limit);
        for(ListenGuidelineEntity item : (List<ListenGuidelineEntity>)objects[1]){
            ListenGuidelineDTO listenGuidelineDTO = ListenGuidelineBeanUtil.entity2DTO(item);
            list.add(listenGuidelineDTO);
        }
        objects[1] = list;
        return objects;
    }

    public List<ListenGuidelineDTO> findall() {
        List<ListenGuidelineDTO> list = new ArrayList<ListenGuidelineDTO>();
        ListenGuidelineDTO listenGuidelineDTO = new ListenGuidelineDTO();
        ListenGuidelineDao listenGuidelineDao = new ListenGuidelineDaoImpl();
        List<ListenGuidelineEntity> listen= listenGuidelineDao.findAll();
        for(ListenGuidelineEntity item : listen){
            listenGuidelineDTO = ListenGuidelineBeanUtil.entity2DTO(item);
            list.add(listenGuidelineDTO);
        }
        return list;
    }
}