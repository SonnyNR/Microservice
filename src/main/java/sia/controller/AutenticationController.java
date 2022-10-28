package sia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sia.service.UserService;

import javax.servlet.http.HttpSession;
import java.security.Principal;

@RestController
@CrossOrigin("*")
@RequestMapping("/authentication")
public class AutenticationController {

    @Autowired
    private UserService userService;

    @GetMapping("/success")
    public String login(Principal principal, HttpSession session){
        return userService.findByEmail(principal.getName()).getRole().toString();
    }

    @GetMapping("/err")
    public Boolean loginerr(){
        return false;
    }
}
