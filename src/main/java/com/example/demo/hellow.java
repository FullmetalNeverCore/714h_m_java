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


@Controller
public class hellow {


    private static final Logger LOGGER = LoggerFactory.getLogger(hellow.class);


    private final VerifData verdata;

    @Autowired
    public hellow(VerifData verdata) {
        this.verdata = verdata;
    }


    // @GetMapping("/")
    // public ModelAndView hello() {
    //     ModelAndView mav = new ModelAndView();
    //     Random random = new Random();
        
    //     mav.addObject("message", "Mikoshi");
    //     int randomNumber = random.nextInt(100 - 1 + 1) + 1;
    //     mav.setViewName("login_panel");
    //     String currentDirectory = ".";
        
    //     // create a File object for the current directory
    //     File directory = new File(currentDirectory);
        
    //     // get a list of all the files and folders in the directory
    //     File[] files = directory.listFiles();
        
    //     // iterate over the files and folders and print the names of the folders
    //     Map<String, Object> myDict = new HashMap<>();
    //     for (File file : files) {
    //         if (file.isDirectory() && file.getName().contains("json")) 
    //         {
    //                 System.out.println(file.getName());
    //                 myDict.put(file.getName().replace("json_",""),file.getName());
    //         }
        
    //     }

    //     System.out.println(person.getName());
    //     person.setName(String.valueOf(randomNumber));
    //     System.out.println(person.getName());
    //     System.out.println(myDict);
    //     return mav;
    // }

    @GetMapping("/")
    public ModelAndView hello() {
        ModelAndView mav = new ModelAndView();
        System.out.println(verdata.getName());
        mav.addObject("message", "Mikoshi");
        mav.setViewName("login_panel");
    
        return mav;
    }
}


