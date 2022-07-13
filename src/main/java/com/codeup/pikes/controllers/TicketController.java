package com.codeup.pikes.controllers;

import com.codeup.pikes.models.Business;
import com.codeup.pikes.models.Location;
import com.codeup.pikes.models.Ticket;
import com.codeup.pikes.models.User;
import com.codeup.pikes.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TicketController {
    private final TicketRepository ticketDao;
    private final BusinessRepository businessDao;
    private final LocationRepository locationDao;
    private final UserRepository userDao;
    private final JobTypeRepository jobTypeDao;

    public TicketController(TicketRepository ticketDao, BusinessRepository businessDao, LocationRepository locationDao, UserRepository userDao, JobTypeRepository jobTypeDao) {
        this.ticketDao = ticketDao;
        this.businessDao = businessDao;
        this.locationDao = locationDao;
        this.userDao = userDao;
        this.jobTypeDao = jobTypeDao;
    }

    //    Cancel ticket
    @PostMapping("/cancelTicket")
    public String cancelTicket(@RequestParam("cancelId") Long id) {
        ticketDao.deleteById(id);
        return "/home";
    }

    //    Page 1
    @GetMapping("/ticket1")
    public String ticket1(Model model) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", new Ticket());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("types", jobTypeDao.findAll());
        return "ticket/ticket1";
    }

    @PostMapping("/ticketStart")
    public String ticketStart(@ModelAttribute Ticket ticket, @RequestParam("loc") String location, @RequestParam("type") String type, @RequestParam("user") Long id) {
        ticket.setLocation(locationDao.findByName(location));
        ticket.setBusiness(locationDao.findByName(location).getBusiness());
        ticket.setType(type);
        ticket.setUser(userDao.getById(id));
        ticketDao.save(ticket);
        return "redirect:/ticket2/" + ticket.getId();
    }

    //    Page 2
    @GetMapping("/ticket2/{id}")
    public String ticket2(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket2";
    }

    @PostMapping("/ticket2End")
    public String ticket2End(@ModelAttribute Ticket ticket){
        return "redirect:/ticket/3/" + ticket.getId();
    }

    //    Page 3
    @GetMapping("/ticket3/{id}")
    public String ticket3(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket3";
    }

    @PostMapping("/ticket3End")
    public String ticket3End(@ModelAttribute Ticket ticket){
        return "redirect:/ticket/4/" + ticket.getId();
    }

    //    Page 4
    @GetMapping("/ticket4/{id}")
    public String ticket4(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket4";
    }

    @PostMapping("/ticket4End")
    public String ticket4End(@ModelAttribute Ticket ticket){
        return "redirect:/ticket/5/" + ticket.getId();
    }

    //    Page 5
    @GetMapping("/ticket5/{id}")
    public String ticket5(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket5";
    }

    @PostMapping("/ticket5End")
    public String ticket5End(@ModelAttribute Ticket ticket){
        return "redirect:/ticket/6/" + ticket.getId();
    }

    //    Page 6
    @GetMapping("/ticket6/{id}")
    public String ticket6(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket6";
    }

    @PostMapping("/ticket6End")
    public String ticket6End(@ModelAttribute Ticket ticket){
        return "redirect:/ticket/7/" + ticket.getId();
    }

    //    Page 7
    @GetMapping("/ticket7/{id}")
    public String ticket7(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket7";
    }

    @PostMapping("/ticket7End")
    public String ticket7End(@ModelAttribute Ticket ticket){
        return "redirect:/ticket/8/" + ticket.getId();
    }

    //    Page 8
    @GetMapping("/ticket8/{id}")
    public String ticket8(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket8";
    }

    @PostMapping("/ticket8End")
    public String ticket8End(@ModelAttribute Ticket ticket){
        return "redirect:/ticket/9/" + ticket.getId();
    }

    //    Page 9
    @GetMapping("/ticket9/{id}")
    public String ticket9(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket9";
    }

    @PostMapping("/ticket9End")
    public String ticket9End(@ModelAttribute Ticket ticket){
        return "redirect:/home";
    }


}
