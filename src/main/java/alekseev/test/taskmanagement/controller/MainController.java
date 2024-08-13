package alekseev.test.taskmanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
public class MainController {
   @GetMapping("/security")
    public String sayHello(){
        return "security page";
    }
    @GetMapping("/unsecurity")
    public String sayBuy(){
        return "unsecurity page";
    }

}
