package com.example.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class HomeController {

  private final HomeServices _homeServices;


  public HomeController(HomeServices homeServices) {
    _homeServices = homeServices;
  }

    @GetMapping("/")
    public String home()  {
        for (Map.Entry<String, Integer> entry : _homeServices.getWords().entrySet()) {
            System.out.printf("| %-10s | %-5s |\n", entry.getKey(), entry.getValue());
        }
        return "palabras";
    }


    @PostMapping("/")
    public void home(@RequestParam("productUrl") String product) throws IOException {
        System.out.println("Start Process Find Product");
        _homeServices.ProcessURL(product);
        System.out.println("Finish Process Find Product");
    }
}
