package com.company.dao;

import com.company.beans.UserOrder;
import com.company.dao.impl.XMLUserOrderDAO;
import com.company.dao.impl.XMLUserProfileDAO;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();
    private UserProfileDAO XMLUserProfileDaoImpl;
    private UserOrderDAO XMLUserOrderDaoImpl;

    private DAOFactory(){}

    public static DAOFactory getInstance(){
        return instance;
    }

    public UserProfileDAO getXMLUserProfileDao(){
        if(XMLUserProfileDaoImpl == null){
            XMLUserProfileDaoImpl = new XMLUserProfileDAO();
        }
        return  XMLUserProfileDaoImpl;
    }

    public UserOrderDAO getXMLUserOrderDao() {
        if(XMLUserOrderDaoImpl == null){
            XMLUserOrderDaoImpl = new XMLUserOrderDAO();
        }
        return XMLUserOrderDaoImpl;
    }
}
