package vn.myclass.core.utils;

import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.persistance.data.entity.RoleEntity;

public class RoleBeanUtil {
        public static RoleDTO entity2Dto(RoleEntity roleEntity) {
            RoleDTO roleDTO = new RoleDTO();
            roleDTO.setRoleId(roleEntity.getRoleId());
            roleDTO.setName(roleEntity.getName());
            return roleDTO;
        }
        public static RoleEntity dto2Entity(RoleDTO roleDTO) {
            RoleEntity roleEntity = new RoleEntity();
            roleEntity.setRoleId(roleDTO.getRoleId());
            roleEntity.setName(roleDTO.getName());
            return roleEntity;
        }
}