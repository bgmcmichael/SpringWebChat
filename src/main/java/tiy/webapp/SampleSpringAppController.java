package tiy.webapp;

import jdk.internal.util.xml.impl.Input;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
public class SampleSpringAppController {
    @RequestMapping(path = "/person", method = RequestMethod.GET)
    public String person(Model model, String name, String city, int age) {
        Person p = new Person(name, city, age);
        model.addAttribute("person", p);
        return "person-view";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }

    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/chat", method = RequestMethod.GET)
    public String chat(HttpSession session, String message) {

        return "chat";
    }

    @RequestMapping(path = "/input", method = RequestMethod.POST)
    public String input(HttpSession session, String message) {
        WebChatClient client = new WebChatClient();
        client.sendMessage(message);
        return "chat";
    }
}


