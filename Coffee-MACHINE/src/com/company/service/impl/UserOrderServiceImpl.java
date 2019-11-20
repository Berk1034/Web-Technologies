package com.company.service.impl;

import com.company.beans.UserOrder;
import com.company.dao.DAOFactory;
import com.company.dao.UserOrderDAO;
import com.company.service.UserOrderService;

import java.util.List;

public class UserOrderServiceImpl implements UserOrderService {
    DAOFactory daoFactory = DAOFactory.getInstance();
    UserOrderDAO userOrderDAO = daoFactory.getXMLUserOrderDao();

    @Override
    public void AddUserOrder(UserOrder userOrder) {
        userOrderDAO.AddUserOrder(userOrder);
    }

    @Override
    public void UpdateUserOrder(UserOrder userOrder) {
        userOrderDAO.UpdateUserOrder(userOrder);
    }

    @Override
    public void DeleteUserOrder(int userOrderNumber) {
        userOrderDAO.DeleteUserOrder(userOrderNumber);
    }

    @Override
    public int GetMaxID() {
        return userOrderDAO.GetMaxID();
    }

    @Override
    public void SortByID() {
        userOrderDAO.SortByID();
    }

    @Override
    public void SortByCoffeeAmount() {
        userOrderDAO.SortByCoffeeAmount();
    }

    @Override
    public void SortByDate() {
        userOrderDAO.SortByDate();
    }

    @Override
    public List<UserOrder> ReadUserOrder() {
        return userOrderDAO.ReadUserOrder();
    }
}
