package ra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ra.model.User;

@Controller
@RequestMapping("/")
public class AuthController {
    @GetMapping({"/","/login"})
    public ModelAndView showLoginForm() {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/doLogin")
    public ModelAndView doLogin(@ModelAttribute User user) {
        if(user.getUsername().equals("admin") && user.getPassword().equals("123456")){
            ModelAndView modelAndView = new ModelAndView("success");
            modelAndView.addObject("user",user);
            return modelAndView;
        }
        ModelAndView modelAndView = new ModelAndView("error");
        return modelAndView;
    }
}