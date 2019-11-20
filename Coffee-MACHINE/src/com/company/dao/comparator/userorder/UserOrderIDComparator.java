package com.company.dao.comparator.userorder;

import com.company.beans.UserOrder;

import java.util.Comparator;

public class UserOrderIDComparator implements Comparator<UserOrder> {
    @Override
    public int compare(UserOrder userOrder1, UserOrder userOrder2) {
        return userOrder1.getID() - userOrder2.getID();
    }
}
