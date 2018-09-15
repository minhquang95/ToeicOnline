package vn.myclass.core.service.daoimpl;

import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.dto.CheckLoginDTO;
import vn.myclass.core.dto.RoleDTO;
import vn.myclass.core.dto.UserDTO;
import vn.myclass.core.persistance.data.entity.UserEntity;
import vn.myclass.core.service.dao.UserService;
import vn.myclass.core.utils.UserBeanUtil;

import java.sql.Timestamp;

public class UserServiceImpl implements UserService {
    public boolean saveUser(UserDTO userDTO) {
        Timestamp createDate = new Timestamp(System.currentTimeMillis());
        userDTO.setCreateDate(createDate);
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName("USER");
        roleDTO.setRoleId(2);
        userDTO.setRoleDTO(roleDTO);
        UserEntity userEntity = UserBeanUtil.dto2Entity(userDTO);
        UserDao userDao = new UserDaoImpl();
        boolean flag = userDao.save(userEntity);
        return flag;
    }

    public CheckLoginDTO checkLogin(String username, String password) {
        CheckLoginDTO checkLoginDTO = new CheckLoginDTO();
        UserDao userDao = new UserDaoImpl();
        Object [] checkLogin = userDao.CheckLogin(username,password);
        checkLoginDTO.setUserExist((Boolean) checkLogin[0]);
        if(checkLoginDTO.isUserExist()){
            checkLoginDTO.setRoleName((String) checkLogin[1]);
        }
        return checkLoginDTO;
    }
}