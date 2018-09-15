package vn.myclass.core.data.daoimpl;

import org.apache.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.hibernate.*;
import vn.myclass.core.common.constant.CoreConstant;
import vn.myclass.core.common.utils.HibernateUtil;
import vn.myclass.core.data.dao.GenericDao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AbstractDao<ID extends Serializable, T> implements GenericDao<ID, T> {
    private final Logger log = Logger.getLogger(this.getClass());
    private Class<T> persistenceClass;

    public AbstractDao() {
        this.persistenceClass = (Class<T>) ((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public String getPersistenceClassName() {
        return persistenceClass.getSimpleName();
    }

    public List findAll() {
        List list = new ArrayList();
        Session sesssion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesssion.beginTransaction();
        try{
            StringBuilder stringBuilder = new StringBuilder("from ");
            stringBuilder.append(this.getPersistenceClassName());
            Query query = sesssion.createQuery(stringBuilder.toString());
            list = query.list();
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            log.error(e.getMessage(),e);
            throw e;
        } finally {
            sesssion.close();
        }
        return list;
    }

    public T update(T entity) {
        Session sesssion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesssion.beginTransaction();
        T result = null;
        try {
            Object object = sesssion.merge(entity);
            result = (T) object;
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            log.error(e.getMessage(),e);
            throw e;
        } finally {
            sesssion.close();
        }
        return (T) result;
    }

    public boolean save(T entity) {
        Session sesssion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesssion.beginTransaction();
        boolean flag = false;
        try {
            sesssion.persist(entity);
            transaction.commit();
            flag = true;
        } catch (HibernateException e){
            transaction.rollback();
            log.error(e.getMessage(),e);
            throw e;
        } finally {
            sesssion.close();
        }
        return flag;
    }

    public T findById(ID id) {
        T result = null;
        Session sesssion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesssion.beginTransaction();
        try {
            result = (T) sesssion.get(persistenceClass, id);
            if(result == null){
                throw new ObjectNotFoundException("Not found " +id, null);
            }
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            log.error(e.getMessage(),e);
            throw e;
        } finally {
            sesssion.close();
        }
        return result;
    }

    public Object[] findByProperty(Map<String,Object> property , String sortExpression , String sortDirection , Integer offset, Integer limit) {
        List<T> result = new ArrayList<T>();
        Object TotalItem;
        Session sesssion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesssion.beginTransaction();
        String [] params = new String [property.size()];
        Object [] values = new String [property.size()];
        int i =0;
        for(Map.Entry item: property.entrySet()){ // them gia tri va khoa cho truong yeu cau
            params[i] = (String) item.getKey();
            values [i] = (String) item.getValue();
            i++;
        }
        try {

            StringBuilder sql1 = new StringBuilder("from ");
            sql1.append(getPersistenceClassName());
            if(property.size() > 0){
                for(int i1 = 0; i1 < params.length ;i1++){
                    if(i1 == 0){
                        sql1.append(" where ").append(params[i1]).append("= :"+params[i1]+"");
                    }else{
                        sql1.append(" and ").append(params[i1]).append("= : "+params[i1]+"");
                    }
                }
            }

            if(sortExpression != null && sortDirection !=null ) {
                sql1.append(" " + (sortDirection.equals(CoreConstant.SORT_ASC)?"asc":"desc"));
            }


            Query query1 = sesssion.createQuery(sql1.toString());

            if(offset != null && offset >=0){
                query1.setFirstResult(offset);
            }

            if(limit != null && limit >0){
                query1.setMaxResults(limit);
            }

            if(property.size() > 0){
                for(int i1 = 0; i1 < params.length ;i1++){
                    query1.setParameter(params[i1],values[i1]);
                }
            }
            result = query1.list();

            StringBuilder sql = new StringBuilder("select count(*) from ").append(getPersistenceClassName());

            if(property.size() > 0){
                for(int i1 = 0; i1 < params.length ;i1++){
                    if(i1 == 0){
                        sql.append(" where ").append(params[i1]).append("= :"+params[i1]+"");
                    }else{
                        sql.append(" and ").append(params[i1]).append("= :"+params[i1]+"");
                    }
                }
            }
            Query query2 = sesssion.createQuery(sql.toString());
            if(property.size() > 0){
                for(int i1 = 0; i1 < params.length ;i1++){
                    query2.setParameter(params[i1],values[i1]);
                }
            }

            TotalItem = query2.list().get(0);
            transaction.commit();
        } catch (HibernateException e){
            transaction.rollback();
            log.error(e.getMessage(),e);
            throw e;}
//        } finally {
//            sesssion.close();
//        }
        return new Object[]{TotalItem,result};
    }

    public Integer delete(List<ID> ids) {
        Integer count = 0;
        Session sesssion = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = sesssion.beginTransaction();
        try {
            for(ID item : ids){
                T enity = (T) sesssion.get(persistenceClass,item);
                sesssion.delete(enity);
                count ++;
            }
            transaction.commit();
        }catch (HibernateException e){
            transaction.rollback();
            log.error(e.getMessage(),e);
            throw e;
        }finally {
            sesssion.close();
        }
        return count;
    }
}