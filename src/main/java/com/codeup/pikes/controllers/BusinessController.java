package com.codeup.pikes.controllers;


import com.codeup.pikes.repositories.BusinessRepository;
import com.codeup.pikes.repositories.LocationRepository;
import com.codeup.pikes.repositories.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class BusinessController {
    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final UserRepository userDao;

    public BusinessController(BusinessRepository businessDao, LocationRepository locationDao, UserRepository userDao){
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.userDao = userDao;
    }
}
