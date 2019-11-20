package com.company.service;

import com.company.beans.UserOrder;

import java.util.List;

public interface UserOrderService {
    void AddUserOrder(UserOrder userOrder);
    void UpdateUserOrder(UserOrder userOrder);
    void DeleteUserOrder(int userOrderNumber);
    int GetMaxID();
    void SortByCoffeeAmount();
    void SortByDate();
    void SortByID();
    List<UserOrder> ReadUserOrder();
}
