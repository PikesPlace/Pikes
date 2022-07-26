package com.codeup.pikes.controllers;

import com.codeup.pikes.models.Business;
import com.codeup.pikes.models.Location;
import com.codeup.pikes.models.User;
import com.codeup.pikes.repositories.BusinessRepository;
import com.codeup.pikes.repositories.LocationRepository;
import com.codeup.pikes.repositories.TicketRepository;
import com.codeup.pikes.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
        return "redirect:/admin";
    }

    @PostMapping("/adminAddBusiness")
    public String adminAddBusiness (@ModelAttribute Business business, @RequestParam ("name") String name){
        business.setName(name);
        businessDao.save(business);
        return "redirect:/admin";
    }

    @PostMapping("/adminAddLocation")
    public String adminAddLocation (@ModelAttribute Location location, @RequestParam ("name") String name, @RequestParam ("email") String email, @RequestParam ("phone") String phone, @RequestParam ("poc") String poc, @RequestParam ("street") String street, @RequestParam ("city") String city, @RequestParam ("state") String state, @RequestParam ("zip") String zip, @RequestParam ("business") Long business){
        location.setBusiness(businessDao.getById(business));
        location.setName(name);
        location.setEmail(email);
        location.setPhone(phone);
        location.setPoc(poc);
        location.setStreet(street);
        location.setCity(city);
        location.setState(state);
        location.setZip(zip);
        locationDao.save(location);
        return "redirect:/admin";
    }

    @GetMapping("/tickets")
    public String getAllTickets(Model model){
        model.addAttribute("tickets", ticketDao.findAll());
        model.addAttribute("NotAvail", "N/A");
        return "tickets";
    }

    @PostMapping("/ticketSearch")
    public String ticketSearch(Model model, @RequestParam(name = "search") Long search) {
        model.addAttribute("tickets", ticketDao.searchTickets(search));
        return "tickets";
    }

}
