package com.codeup.pikes.controllers;

import com.codeup.pikes.models.TimeSheet;
import com.codeup.pikes.models.User;
import com.codeup.pikes.repositories.*;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userDao;
    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final TicketRepository ticketDao;
    private final TimeSheetRepository timeDao;

    public UserController(UserRepository userDao, BusinessRepository businessDao, LocationRepository locationDao, TicketRepository ticketDao, TimeSheetRepository timeDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.ticketDao = ticketDao;
        this.timeDao = timeDao;
        this.passwordEncoder = passwordEncoder;
    }

//     LANDING PAGE
    @GetMapping("/")
    public String index(Model model) {
        return "index";
    }

//    HOME PAGE
    @GetMapping("/home")
    public String home(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "home";
    }

//    LOGIN PAGE
    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @PostMapping("/login")
    public String logUser() {
        return "redirect:/home";
    }

//    REGISTER PAGE
    @GetMapping("/register")
    public String registerUserForm(Model model) {
        model.addAttribute("user", new User());
        return "sign-up";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        model.addAttribute("user", new User());
        String hash = passwordEncoder.encode(user.getPassword());
        user.setPassword(hash);
        userDao.save(user);
        return "redirect:/login";
    }

//    TIMESHEET PAGE
    @GetMapping("/timeSheet")
    public String timeSheet(Model model){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "timeSheet";
    }

    @PostMapping("/clockIn")
    public String clockIn(@RequestParam("userId") Long id, @RequestParam("currentDate") Date currentDate, @RequestParam("currentTime") Time currentTime){
        User user = userDao.getById(id);
        TimeSheet timeSheet = new TimeSheet();
        timeSheet.setUser(user);
        timeSheet.setThisDate(currentDate);
        timeSheet.setStartTime(currentTime);
        timeDao.save(timeSheet);
        return "redirect:/home";
    }

    @PostMapping("/clockOut")
    public String clockOut(@RequestParam("userId") Long id, @RequestParam("currentDate") Date currentDate, @RequestParam("currentTime") Time currentTime){
        TimeSheet timeSheet = timeDao.timeSheetFind(id, currentDate);
        timeSheet.setEndTime(currentTime);
        return "redirect:/home";
    }


}
