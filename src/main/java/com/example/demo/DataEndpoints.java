package com.example;

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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.function.Function;
import java.io.FileWriter;
import java.io.IOException;








@RestController
public class DataEndpoints {

    private static final Logger LOGGER = LoggerFactory.getLogger(DataEndpoints.class);


    private final VerifData verdata;
    private final Chatbuffer chatb;
    private final NNvals nnvals;

    @Autowired
    public DataEndpoints(VerifData verdata,Chatbuffer chatb,NNvals nnvals) {
        this.verdata = verdata;
        this.chatb = chatb;
        this.nnvals = nnvals;
    }


    @RequestMapping("/char_list")
    public static Map<String, Object> getCharList() {
        String currentDirectory = ".";
        File directory = new File(currentDirectory);
        File[] files = directory.listFiles();
        Map<String, Object> myDict = new HashMap<>();
        for (File file : files) {
            if (file.isDirectory() && file.getName().contains("json")) 
           {
                    System.out.println(file.getName());
                    myDict.put(file.getName().replace("json_",""),file.getName());
            }
        
        } 
        return myDict;
    }

    @RequestMapping("/msg_buffer")
    public Map<String, Object> getChatBuff() {
        Map<String, Object> chbuff = new HashMap<>();
        chbuff.put("text",chatb.getChat());
        return chbuff;
    }


    @PostMapping("/verify_credentials")
    public void receiveData(@RequestBody Map<String, Object> data) {
        LOGGER.info("Received data: {}", data.get("username"));
        verdata.setName((String) data.get("username"));
        verdata.setChr((String) data.get("char"));
        verdata.setPword((String) data.get("password"));
    }

    public void overwriteFile(String filePath, String newContent) throws IOException {
        FileWriter fileWriter = new FileWriter(filePath);
        fileWriter.write(newContent);
        fileWriter.close();
    }  

    @PostMapping("/upload_stuff")
    public void overwriteHandler(@RequestBody Map<String, Object> data) {
        try{
            switch((String) data.get("type")){
                    case "brain":
                        overwriteFile((String) String.format("./json_%s/brain.json",verdata.getChr()),(String) data.get("data"));
                        break;
                    case "high":
                        overwriteFile((String) String.format("./json_%s/high_memory.json",verdata.getChr()),(String) data.get("data"));
                        break;
                    default:
                        System.out.println("The type is not recognized.");  
                }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @PostMapping("/nn_vals")
    public void receiveNNV(@RequestBody Map<String, Object> data) {
        LOGGER.info("Received data NNV: {}", data.get("type"));
        LOGGER.info("Received data NNV: {}", data.get("val"));
        switch((String) data.get("type")){
            case "rnd":
                nnvals.setRnd((String) data.get("val"));
                break;
            case "fpen":
                nnvals.setFpen((String) data.get("val"));
                break;
            case "ppen":
                nnvals.setPpen((String) data.get("val"));
                break;
            default:
                System.out.println("The type is not recognized.");                
        }
    }
}