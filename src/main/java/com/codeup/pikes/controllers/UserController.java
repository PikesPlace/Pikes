package com.codeup.pikes.controllers;

import com.codeup.pikes.repositories.BusinessRepository;
import com.codeup.pikes.repositories.LocationRepository;
import com.codeup.pikes.repositories.TicketRepository;
import com.codeup.pikes.repositories.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserRepository userDao;
    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final TicketRepository ticketDao;

    public UserController(UserRepository userDao, BusinessRepository businessDao, LocationRepository locationDao, TicketRepository ticketDao) {
        this.userDao = userDao;
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.ticketDao = ticketDao;
    }

    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String logUser() {
        return "redirect:/main";
    }
}
