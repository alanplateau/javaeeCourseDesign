package service;
import java.util.Map;

import org.hibernate.Transaction;

import com.opensymphony.xwork2.ActionContext;

import dao.BaseHibernateDAO;
import dao.AirplaneDAO;
import dao.IAirplaneDAO;
import po.Airplane;
public class UserService implements IUserService {
    private IAirplaneDAO AirplaneDAO = null;
    public UserService(){
    }
    public void setAirplaneDAO(IAirplaneDAO AirplaneDAO) {
        this.AirplaneDAO = AirplaneDAO;
    }
//    public void register() {
//        System.out.println("execute --register()-- method.");
//        AirplaneDAO.save(AirplaneDAO);
//	}
    public boolean register(Airplane transientInstance){
//        try {
//            this.AirplaneDAO.save(transientInstance);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
        this.AirplaneDAO.save(transientInstance);
        return true;
    }
}