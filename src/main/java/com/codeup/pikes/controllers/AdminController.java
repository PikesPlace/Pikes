package com.codeup.pikes.controllers;

import com.codeup.pikes.models.Business;
import com.codeup.pikes.models.Location;
import com.codeup.pikes.models.User;
import com.codeup.pikes.repositories.BusinessRepository;
import com.codeup.pikes.repositories.LocationRepository;
import com.codeup.pikes.repositories.TicketRepository;
import com.codeup.pikes.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {

    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final UserRepository userDao;
    private final TicketRepository ticketDao;


    public AdminController(BusinessRepository businessDao, LocationRepository locationDao, UserRepository userDao, TicketRepository ticketDao) {
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.userDao = userDao;
        this.ticketDao = ticketDao;
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("businesses", businessDao.findAll());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("users", userDao.findAll());
        model.addAttribute("tickets", ticketDao.findAll());
        return "admin";
    }

    @GetMapping("/adminAdd")
    public String adminAdd(Model model){
        model.addAttribute("newUser", new User());
        model.addAttribute("newBusiness", new Business());
        model.addAttribute("businesses", businessDao.findAll());
        model.addAttribute("newLocation", new Location());
        return "adminAdd";
    }

    @PostMapping("/adminAddUser")
    public String adminAddUser(@ModelAttribute User user, @RequestParam ("isAdmin") Boolean isAdmin, @RequestParam ("email") String email, @RequestParam ("pass") String pass, @RequestParam ("username") String username){
        user.setUsername(username);
        user.setPassword(pass);
        user.setEmail(email);
        user.setAdmin(isAdmin);
        userDao.save(user);
        return "reidrect:/admin";
    }


}
