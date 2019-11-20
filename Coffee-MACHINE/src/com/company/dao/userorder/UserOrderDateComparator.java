package com.company.dao.userorder;

import com.company.beans.UserOrder;

import java.util.Comparator;

public class UserOrderDateComparator implements Comparator<UserOrder> {
    @Override
    public int compare(UserOrder userOrder1, UserOrder userOrder2) {
        return userOrder1.getDate().compareTo(userOrder2.getDate());
    }
}
