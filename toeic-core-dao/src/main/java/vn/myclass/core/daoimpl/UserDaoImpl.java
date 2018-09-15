package vn.myclass.core.daoimpl;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vn.myclass.core.common.utils.HibernateUtil;
import vn.myclass.core.dao.UserDao;
import vn.myclass.core.data.daoimpl.AbstractDao;
import vn.myclass.core.persistance.data.entity.UserEntity;

import javax.persistence.Entity;

public class UserDaoImpl extends AbstractDao<Integer,UserEntity> implements UserDao {
    public Object[] CheckLogin(String userName, String password) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        boolean isUserExist = false;
        String roleName = null;
        try{
            StringBuilder sql = new StringBuilder(" FROM UserEntity ue WHERE ue.username= :username AND ue.password= :password");
            Query query = session.createQuery(sql.toString());
            query.setParameter("username", userName);
            query.setParameter("password", password);
            if(query.list().size() > 0){
                isUserExist = true;
                UserEntity userEntity = (UserEntity) query.uniqueResult();
                roleName = userEntity.getRoleEntity().getName();
            }
        }catch(HibernateException e){
            transaction.rollback();
            throw e;
        }finally {
            session.close();
        }

        return new Object[]{isUserExist, roleName};
    }
}