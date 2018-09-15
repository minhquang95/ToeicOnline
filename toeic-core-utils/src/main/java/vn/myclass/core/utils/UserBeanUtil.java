package vn.myclass.core.utils;

import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistance.data.entity.UserEntity;


public class UserBeanUtil {
    public static UserEntity dto2Entity(UserDTO userDTO){
        UserEntity userEntity = new UserEntity();
        userEntity.setUserId(userDTO.getUserId());
        userEntity.setUsername(userDTO.getUsername());
        userEntity.setPassword(userDTO.getPassword());
        userEntity.setFullName(userDTO.getFullName());
        userEntity.setCreateDate(userDTO.getCreateDate());
        userEntity.setRoleEntity(RoleBeanUtil.dto2Entity(userDTO.getRoleDTO()));
        return  userEntity;
    }

    public static UserDTO entity2DTO(UserEntity userEntity) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserId(userEntity.getUserId());
        userDTO.setUsername(userEntity.getUsername());
        userDTO.setPassword(userEntity.getPassword());
        userDTO.setFullName(userEntity.getFullName());
        userDTO.setCreateDate(userEntity.getCreateDate());
        userDTO.setRoleDTO(RoleBeanUtil.entity2Dto(userEntity.getRoleEntity()));
        return userDTO;
    }
}