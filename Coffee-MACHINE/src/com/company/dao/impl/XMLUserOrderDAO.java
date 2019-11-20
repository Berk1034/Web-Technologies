package com.company.dao.impl;

import com.company.beans.UserOrder;
import com.company.dao.UserOrderDAO;
import com.company.dao.comparator.userorder.UserOrderCoffeeAmountComparator;
import com.company.dao.comparator.userorder.UserOrderDateComparator;
import com.company.dao.comparator.userorder.UserOrderIDComparator;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLUserOrderDAO implements UserOrderDAO {

    private static String filepath = "UserOrders.xml";
    private List<UserOrder> userOrderList;

    public  XMLUserOrderDAO(){
        userOrderList = new ArrayList<UserOrder>();
        if(new File(filepath).exists()){
            try{
                LoadUserOrdersFromFile();
            }
            catch (Exception e){

            }
        }
    }

    private void LoadUserOrdersFromFile(){
        try{
            XMLDecoder in = new XMLDecoder(new BufferedInputStream(new FileInputStream(filepath)));
            userOrderList = (ArrayList<UserOrder>)in.readObject();
        }
        catch (IOException e) {

        }
    }

    private void SaveUserOrdersToFile(){
        try{
            File file = new File(filepath);
            if(!file.exists()){
                if(!file.createNewFile())
                    throw new IOException();
            }
            XMLEncoder out = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filepath)));
            out.writeObject(userOrderList);
            out.flush();
            out.close();
        }
        catch(IOException e){

        }
    }

    @Override
    public void AddUserOrder(UserOrder userOrder) {
        userOrderList.add(userOrder);
        SaveUserOrdersToFile();
    }

    @Override
    public void UpdateUserOrder(UserOrder userOrder){
        for(UserOrder order: userOrderList){
            if(order.getID() == userOrder.getID()){
                userOrderList.set(userOrderList.indexOf(order),userOrder);
            }
        }
        SaveUserOrdersToFile();
    }

    @Override
    public void DeleteUserOrder(int userOrderNumber) {
        for(UserOrder order: userOrderList){
            if(order.getID() == userOrderNumber){
                userOrderList.remove(order);
            }
        }
        SaveUserOrdersToFile();
    }

    @Override
    public int GetMaxID() {
        int maxID = 0;
        for(UserOrder userOrder: userOrderList){
            maxID = userOrder.getID()>maxID?userOrder.getID():maxID;
        }
        return maxID;
    }

    @Override
    public void SortByID() {
        userOrderList.sort(new UserOrderIDComparator());
    }

    @Override
    public void SortByCoffeeAmount() {
        userOrderList.sort(new UserOrderCoffeeAmountComparator());
    }

    @Override
    public void SortByDate() {
        userOrderList.sort(new UserOrderDateComparator());
    }

    @Override
    public List<UserOrder> ReadUserOrder() {
        return userOrderList;
    }
}
