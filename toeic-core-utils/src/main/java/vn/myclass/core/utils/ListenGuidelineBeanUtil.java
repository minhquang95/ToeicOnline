package vn.myclass.core.utils;

import vn.myclass.core.dto.ListenGuidelineDTO;
import vn.myclass.core.persistance.data.entity.ListenGuidelineEntity;

public class ListenGuidelineBeanUtil {
    public static ListenGuidelineDTO entity2DTO (ListenGuidelineEntity listenGuidelineEntity){
        ListenGuidelineDTO listenGuidelineDTO = new ListenGuidelineDTO();
        listenGuidelineDTO.setListenGuidelineId(listenGuidelineEntity.getListenGuidelineId());
        listenGuidelineDTO.setTitle(listenGuidelineEntity.getTitle());
        listenGuidelineDTO.setImage(listenGuidelineEntity.getImage());
        listenGuidelineDTO.setContent(listenGuidelineEntity.getContent());
        listenGuidelineDTO.setCreatedDate(listenGuidelineEntity.getCreatedDate());
        listenGuidelineDTO.setModifiedDate(listenGuidelineEntity.getModifiedDate());
        return  listenGuidelineDTO;
    }

    public static ListenGuidelineEntity dto2Entity (ListenGuidelineDTO listenGuidelineDTO){
        ListenGuidelineEntity listenGuidelineEntity = new ListenGuidelineEntity();
        listenGuidelineEntity.setListenGuidelineId(listenGuidelineDTO.getListenGuidelineId());
        listenGuidelineEntity.setTitle(listenGuidelineDTO.getTitle());
        listenGuidelineEntity.setImage(listenGuidelineDTO.getImage());
        listenGuidelineEntity.setContent(listenGuidelineDTO.getContent());
        listenGuidelineEntity.setCreatedDate(listenGuidelineDTO.getCreatedDate());
        listenGuidelineEntity.setModifiedDate(listenGuidelineDTO.getModifiedDate());
        return  listenGuidelineEntity;
    }
}