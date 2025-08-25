package com.example.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

    @RequestMapping("say-hello")
    @ResponseBody         // return this statement to the web-browser
    public String sayHello() {
        return "Hello! What are you learning today?";
    }

    @RequestMapping("say-hello-html")
    @ResponseBody         // return this statement to the web-browser
    public String sayHelloHtml() {
        StringBuffer sb = new StringBuffer();
        sb.append("<html>");
        sb.append("<head>");
        sb.append("<title> My first HTML Page</title>");
        sb.append("</head>");
        sb.append("<body>");
        sb.append("My first html page with body");
        sb.append("</body>");
        sb.append("</html>");
        return sb.toString();
    }

    @RequestMapping("say-hello-jsp")
    public String sayHelloJsp() {
        return "sayHello";   // jsp file name
    }
}
