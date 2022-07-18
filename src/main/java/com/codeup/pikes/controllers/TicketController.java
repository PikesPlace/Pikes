package com.codeup.pikes.controllers;

import com.codeup.pikes.models.Business;
import com.codeup.pikes.models.Location;
import com.codeup.pikes.models.Ticket;
import com.codeup.pikes.models.User;
import com.codeup.pikes.repositories.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.parameters.P;
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

    @GetMapping("/ticket1/{id}")
    public String backToTicket(Model model, @PathVariable Long id){
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("locations", locationDao.findAll());
        model.addAttribute("types", jobTypeDao.findAll());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket1Return";
    }

    @PostMapping("/ticketReturn")
    public String ticketReturn(@RequestParam("ticketId") Long ticketId, @RequestParam("loc") String location, @RequestParam("type") String type, @RequestParam("user") Long id, @RequestParam("phoneNum") String phoneNum, @RequestParam ("date") String date, @RequestParam ("dateOrdered") String dateOrdered, @RequestParam ("dateScheduled") String dateScheduled){
        Ticket ticket = ticketDao.getById(ticketId);
        ticket.setLocation(locationDao.findByName(location));
        ticket.setBusiness(locationDao.findByName(location).getBusiness());
        ticket.setType(type);
        ticket.setUser(userDao.getById(id));
        ticket.setPhoneNum(phoneNum);
        ticket.setDate(date);
        ticket.setDateOrdered(dateOrdered);
        ticket.setDateScheduled(dateScheduled);
        ticketDao.save(ticket);
        return "redirect:/ticket2/" + ticket.getId();
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
        model.addAttribute("types", jobTypeDao.findAll());
        return "ticket/ticket2";
    }

    @PostMapping("/ticket2End")
    public String ticket2End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);

        ticketDao.save(ticket);
        return "redirect:/ticket3/" + ticket.getId();
    }

    @PostMapping("/backToTicket1")
    public String backToTicket1(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket1/" + ticket.getId();
    }

    //    Page 3
    @GetMapping("/ticket3/{id}")
    public String ticket3(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket3";
    }

    @PostMapping("/ticket3End")
    public String ticket3End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);

        ticketDao.save(ticket);
        return "redirect:/ticket4/" + ticket.getId();
    }

    @PostMapping("/backToTicket2")
    public String backToTicket2(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket2/" + ticket.getId();
    }

    //    Page 4
    @GetMapping("/ticket4/{id}")
    public String ticket4(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket4";
    }

    @PostMapping("/ticket4End")
    public String ticket4End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);

        ticketDao.save(ticket);
        return "redirect:/ticket5/" + ticket.getId();
    }

    @PostMapping("/backToTicket3")
    public String backToTicket3(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket3/" + ticket.getId();
    }

    //    Page 5
    @GetMapping("/ticket5/{id}")
    public String ticket5(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket5";
    }

    @PostMapping("/ticket5End")
    public String ticket5End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);

        ticketDao.save(ticket);
        return "redirect:/ticket6/" + ticket.getId();
    }

    @PostMapping("/backToTicket4")
    public String backToTicket4(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket4/" + ticket.getId();
    }

    //    Page 6
    @GetMapping("/ticket6/{id}")
    public String ticket6(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket6";
    }

    @PostMapping("/ticket6End")
    public String ticket6End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);

        ticketDao.save(ticket);
        return "redirect:/ticket7/" + ticket.getId();
    }

    @PostMapping("/backToTicket5")
    public String backToTicket5(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket5/" + ticket.getId();
    }

    //    Page 7
    @GetMapping("/ticket7/{id}")
    public String ticket7(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket7";
    }

    @PostMapping("/ticket7End")
    public String ticket7End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);

        ticketDao.save(ticket);
        return "redirect:/ticket8/" + ticket.getId();
    }

    @PostMapping("/backToTicket6")
    public String backToTicket6(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket6/" + ticket.getId();
    }

    //    Page 8
    @GetMapping("/ticket8/{id}")
    public String ticket8(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket8";
    }

    @PostMapping("/ticket8End")
    public String ticket8End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);

        ticketDao.save(ticket);
        return "redirect:/ticket9/" + ticket.getId();
    }

    @PostMapping("/backToTicket7")
    public String backToTicket7(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket7/" + ticket.getId();
    }

    //    Page 9
    @GetMapping("/ticket9/{id}")
    public String ticket9(Model model, @PathVariable Long id) {
        model.addAttribute("user", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        model.addAttribute("ticketObj", ticketDao.getById(id));
        return "ticket/ticket9";
    }

    @PostMapping("/ticket9End")
    public String ticket9End(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        ticketDao.save(ticket);
        return "redirect:/home";
    }

    @PostMapping("/backToTicket8")
    public String backToTicket8(@RequestParam("ticketId") Long id){
        Ticket ticket = ticketDao.getById(id);
        return "redirect:/ticket8/" + ticket.getId();
    }


}
