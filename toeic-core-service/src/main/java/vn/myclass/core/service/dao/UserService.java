package vn.myclass.core.service.dao;

import vn.myclass.core.dto.CheckLoginDTO;
import vn.myclass.core.dto.UserDTO;

import java.util.List;
import java.util.Map;

/**
 * Created by Admin on 9/7/2017.
 */
public interface UserService {
    boolean saveUser(UserDTO userDTO);
    CheckLoginDTO checkLogin(String username, String password);
}

