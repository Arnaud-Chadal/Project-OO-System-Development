package com.graniteam.gameview.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.graniteam.gameview.services.Services;

@RestController
public class AppServices
{
    @Autowired
    private Services services;

    public AppServices() {}

    @GetMapping("/test")
    public String test() {return "test test";}
}
