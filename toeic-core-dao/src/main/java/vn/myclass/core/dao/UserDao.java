package vn.myclass.core.dao;

import vn.myclass.core.data.dao.GenericDao;
import vn.myclass.core.persistance.data.entity.UserEntity;

import java.util.List;

/**
 * Created by Admin on 9/7/2017.
 */
public interface UserDao extends GenericDao<Integer, UserEntity> {
    Object [] CheckLogin(String userName, String password);
}
