package ru.itpark.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.itpark.app.models.User;
import ru.itpark.app.services.UsersService;

import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getUsersPage(@RequestParam(value = "sort", required = false) Boolean sort,
                               @RequestParam(value = "by", required = false) String by,
                               @RequestParam(value = "desc", required = false) Boolean desc,
                               ModelMap model) {
        List<User> users = usersService.getUsers(sort, by, desc);
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/search")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String getSearchPage() {
        return "users_search";
    }

    @GetMapping("/search.json")
    @PreAuthorize("hasAuthority('ADMIN')")
    @ResponseBody
    public List<User> getUsersByKeyword(@RequestParam("q") String query) {
        return usersService.getUsersWithSearch(query);
    }
}
