package com.company.dao;

import com.company.beans.UserOrder;

import java.util.List;

public interface UserOrderDAO {
    void AddUserOrder(UserOrder userOrder);
    void UpdateUserOrder(UserOrder userOrder);
    void DeleteUserOrder(int userOrderNumber);
    int GetMaxID();
    void SortByCoffeeAmount();
    void SortByDate();
    void SortByID();
    List<UserOrder> ReadUserOrder();
}
