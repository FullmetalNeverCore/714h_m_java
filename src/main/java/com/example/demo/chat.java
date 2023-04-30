package com.example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.HashMap;
import java.util.Map;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


@Controller
public class chat{
    
    private final VerifData verdata;

    private final NNvals nnvals;

    @Autowired
    public chat(VerifData verdata,NNvals nnvals) {
        this.verdata = verdata;
        this.nnvals = nnvals;
    }

    public static String getLinkFromJSON(String fileName) {
        JSONParser parser = new JSONParser();
        String link = null;
        
        try {
        Object obj = parser.parse(new FileReader(fileName));
        JSONObject jsonObject = (JSONObject) obj;
        
        link = (String) jsonObject.get("link");
        
        } catch (IOException | ParseException e) {
        e.printStackTrace();
        }
        
        return link;
    }
    
    public static String readFile(String filename) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = br.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return contentBuilder.toString();
    }

    @GetMapping("/chat")
    public ModelAndView chat() {
        ModelAndView mav = new ModelAndView();
        String x = getLinkFromJSON(String.format("./json_%s/img.json",verdata.getChr()));
        try{
            String y = readFile(String.format("./json_%s/brain.json",verdata.getChr()));
            mav.addObject("brain", y);
            String z = readFile(String.format("./json_%s/high_memory.json",verdata.getChr()));
            mav.addObject("highm", z);
        }
        catch(IOException e){
            e.printStackTrace();
        }
        System.out.println(x);
        mav.addObject("character", verdata.getChr());
        mav.addObject("imageUrl", x);
        mav.addObject("rnd", nnvals.getRnd());
        mav.addObject("len", nnvals.getLen());
        mav.addObject("fpen", nnvals.getFpen());
        mav.addObject("ppen", nnvals.getPpen());
        System.out.println(String.format("RND : %s FPEN : %s PPEN : %s",nnvals.getRnd(),nnvals.getFpen(),nnvals.getPpen()));
        mav.setViewName("chat");
        return mav;
    }
}