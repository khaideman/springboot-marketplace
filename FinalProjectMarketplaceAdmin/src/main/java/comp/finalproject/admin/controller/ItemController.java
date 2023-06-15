package comp.finalproject.admin.controller;

import comp.finalproject.admin.entity.Item;
import comp.finalproject.admin.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    // handler methods go here...
    @RequestMapping("/items")
    public String viewHomePage(Model model) {
        List<Item> listItem = itemRepository.findAll();
        model.addAttribute("listItem", listItem);
        return "items";
    }

    @RequestMapping("/newitem")
    public String showNewForm(Model model) {
        Item item = new Item();
        model.addAttribute("item", item);

        return "itemsnew";
    }

    @RequestMapping(value = "/saveitem", method = RequestMethod.POST)
    public String save(@ModelAttribute("item") Item item) {
        itemRepository.save(item);

        return "redirect:/items";
    }

    @RequestMapping("/edititem/{id}")
    public ModelAndView showEditForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("itemsedit");
        Item item = itemRepository.findById(id);
        mav.addObject("item", item);

        return mav;
    }

    @RequestMapping("/showitem/{id}")
    public ModelAndView showItemForm(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("showitem_form");
        Item item = itemRepository.findById(id);
        mav.addObject("item", item);

        return mav;
    }

    @RequestMapping(value = "/updateitem", method = RequestMethod.POST)
    public String update(@ModelAttribute("item") Item item) {

        itemRepository.save(item);

        return "redirect:/items";
    }

    @RequestMapping("/deleteitem/{id}")
    public String delete(@PathVariable(name = "id") long id) {
        itemRepository.deleteById(id);
        return "redirect:/items";
    }

}
