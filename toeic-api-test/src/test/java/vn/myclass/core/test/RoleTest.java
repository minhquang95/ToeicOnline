package vn.myclass.core.test;

import org.apache.commons.collections.map.HashedMap;
import org.testng.annotations.Test;
import vn.myclass.core.dao.RoleDao;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.daoimpl.RoleDaoImpl;
import vn.myclass.core.daoimpl.UserDaoImpl;
import vn.myclass.core.persistance.data.entity.RoleEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RoleTest {
    @Test
    public void checkFindAll(){
        RoleDao roleDao = new RoleDaoImpl();
        List<RoleEntity> list = roleDao.findAll();
    }

    @Test
    public void checkUpdate(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(1);
        roleEntity.setName("USER");
        RoleDao roleDao = new RoleDaoImpl();

        RoleEntity roleEntity1 = roleDao.update(roleEntity);
        roleEntity1.getName();

    }

    @Test
    public void checkSave(){
        RoleEntity roleEntity = new RoleEntity();
        roleEntity.setRoleId(3);
        roleEntity.setName("USER");
        RoleDao roleDao = new RoleDaoImpl();
    }

    @Test
    public void checkFindID(){
        RoleDao roleDao = new RoleDaoImpl();
        RoleEntity check = roleDao.findById(1);
        System.out.println(check);
    }

    @Test
    public void checkFindByProperty(){
        UserDao userDao = new UserDaoImpl();
        Map<String,Object> map = new HashedMap();
        map.put("username", null);
        Object [] objects =  userDao.findByProperty(map,null,null,0,4);
    }

    @Test
    public void delete(){
        Integer count = 0;
        RoleEntity roleEntity  = new RoleEntity();
        RoleDao roleDao = new RoleDaoImpl();
        List<Integer> list = new ArrayList<Integer>();
        list.add(4);
        count = roleDao.delete(list);
    }
}