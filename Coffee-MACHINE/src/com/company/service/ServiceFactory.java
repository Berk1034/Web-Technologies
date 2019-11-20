package com.company.service;

import com.company.service.impl.UserProfileServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final UserProfileService userProfileService = new UserProfileServiceImpl();

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        return instance;
    }

    public UserProfileService getUserProfileService() {
        return userProfileService;
    }
}
