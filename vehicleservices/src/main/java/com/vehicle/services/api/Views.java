package com.vehicle.services.api;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping(value = "/angular")
public class Views {
    @Autowired
    public ServletContext context;

    @RequestMapping(value = "/home")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String home() throws IOException {
        return ReadAsset(context, "/views/angular/home.html");
    }

    @RequestMapping(value = "/login")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String login() throws IOException {
        return ReadAsset(context, "/views/angular/login.html");
    }

    @RequestMapping(value = "/register")
    @ResponseBody
    @ResponseStatus(value = HttpStatus.OK)
    public String register() throws IOException {
        return ReadAsset(context, "/views/angular/register.html");
    }

    private static String ReadAsset(ServletContext context, String path) {
        InputStream inputStream = context.getResourceAsStream("/WEB-INF" + path);
        String result;
        try {
            result = IOUtils.toString(inputStream);
        } catch (IOException error) {
            result = error.getMessage();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }

        return result;
    }
}
