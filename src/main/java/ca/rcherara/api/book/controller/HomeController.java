package ca.rcherara.api.book.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import springfox.documentation.annotations.ApiIgnore;

/**
 * @author rcherara
 *
 */
@Controller
@ApiIgnore
public class HomeController {
    @RequestMapping("/")
    @ApiIgnore
    public String home() {
        return "redirect:swagger-ui.html";
    }
}
