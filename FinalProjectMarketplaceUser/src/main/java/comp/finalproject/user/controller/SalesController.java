package comp.finalproject.user.controller;

import comp.finalproject.user.entity.Item;
import comp.finalproject.user.entity.Sale;
import comp.finalproject.user.repository.ItemRepository;
import comp.finalproject.user.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ItemRepository itemRepository;

    // handler methods go here...
    @RequestMapping("/sales")
    public String viewHomePage(Model model) {
        List<Sale> listSale = salesRepository.findAll();
        model.addAttribute("listSale", listSale);
        return "sales";
    }

    @RequestMapping("/newsales")
    public String showNewForm(Model model) {
        Sale sale = new Sale();
        model.addAttribute("sale", sale);

        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);

        return "salesnew";
    }

    @RequestMapping("/deletesales/{id}")
    public String delete(@PathVariable(name = "id") long id) {
        salesRepository.deleteById(id);
        return "redirect:/sales";
    }

    @RequestMapping(value = "/savesales", method = RequestMethod.POST)
    public String save(@ModelAttribute("sale") Sale sale) {

        salesRepository.save(sale);

        return "redirect:/sales";
    }

    @RequestMapping("/editsales/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("salesedit");
        Sale sale = salesRepository.findById(id);
        mav.addObject("sale", sale);

        return mav;
    }

    @RequestMapping(value = "/updatesales", method = RequestMethod.POST)
    public String update(@ModelAttribute("sale") Sale sale) {
        salesRepository.save(sale);

        return "redirect:/sales";
    }
}
