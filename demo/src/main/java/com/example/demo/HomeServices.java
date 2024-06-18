package com.example.demo;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jsoup.Connection;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class HomeServices {
    HashMap<String, Integer> palabraHashMap = new HashMap<String, Integer>();
    ArrayList<String> URLs = new ArrayList<String>();
    List<String> WordsForbidden = new ArrayList<>(List.of("it", "as", "with", "any", "the", "is", "in", "a","and"));



    public  HashMap<String, Integer> getWords()
    {
        return palabraHashMap;
    }


    public void ProcessURL(String product) throws IOException {
        if(!URLs.contains(product))
        {
            URLs.add(product);
            Document doc = Jsoup.connect("https://www.amazon.com/gp/product/B00VVOCQHE").userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36 Eg/91.0.864.64").header("Connection", "keep-alive").get();
            Element description = doc.select("#productDescription p span").first();
            if (description != null && description.text().contains(("Enjoy The Creative Life"))  )
            {
                String[] pVector = description.text().split(" ");
                for(String p : pVector) {
                    String word = p.toLowerCase();
                    if (!WordsForbidden.contains(word)) {
                        if (palabraHashMap.containsKey(word))
                            palabraHashMap.put(word, palabraHashMap.get(word) + 1);
                        else
                            palabraHashMap.put(word, 1);
                    }

                }
            }
        }
    }

}
