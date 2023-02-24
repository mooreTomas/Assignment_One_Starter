package sd4.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sd4.model.Entrant;
import sd4.repository.EntrantRepository;
import sd4.service.EntrantService;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("viewAllEntrants")

public class EntrantController {
    @Autowired

    private EntrantService entrantService;

    @GetMapping("")
    public String displayAllEntrants(Model model, String countryKeyword){
        List<Entrant> entrants;


        if (countryKeyword == null){
            entrants = entrantService.findAllEntrants();
        } else {
            entrants = entrantService.getByCountryFilter(countryKeyword);
        }

        model.addAttribute("entrants", entrants);
        return "viewAllEntrants";
    }


    /* method for date search. combine these methods
    @GetMapping("")
    public String displayAllEntrants(Model model, String startDate, String endDate) throws ParseException {
        List<Entrant> entrants;



        if (startDate  == null || endDate == null){
            entrants = entrantService.findAllEntrants();
        } else {
            SimpleDateFormat startD = new SimpleDateFormat("yyyy-MM-dd");
            Date date = startD.parse(startDate);
            SimpleDateFormat endD = new SimpleDateFormat("yyyy-MM-dd");
            Date date2 = endD.parse(endDate);
            entrants = entrantService.findEntrantsByDateOfFinalBetween(date, date2);
        }

        model.addAttribute("entrants", entrants);
        return "viewAllEntrants";
    }

*/






}
