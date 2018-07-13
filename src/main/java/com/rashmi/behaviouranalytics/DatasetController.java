package com.rashmi.behaviouranalytics;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
@Controller
public class DatasetController {
	private FileWriter fw;
	BufferedReader br2=null;
	public String pr = "";
    @RequestMapping("/")
    public String home(Map<String, Object> model) {
        model.put("message", "HowToDoInJava Reader");
        return "firstNN.html";
    }
    @RequestMapping(value = "/submitValues", method = RequestMethod.POST)
    @ResponseBody  
    public ResponseEntity<Object> ajaxTest(@RequestBody String value) {
    	BufferedReader br2=null;
    	String status=null;
    	
    	try
    	{   
    		//Writing real-time data.
    	    String filename="";
    		if(fw==null)
    		{   
    			filename = "../DataSet" + ".txt";
    			fw = new FileWriter(filename, true);
    		}
    	    BufferedWriter bw = new BufferedWriter(fw);
    	    PrintWriter out = new PrintWriter(bw);
    	    out.println(value);
    	    status = "data inserted!"; 
    	    //Transform dataset.
    	    String line2 = "";
    	    br2 = new BufferedReader(new FileReader(filename));
    	    PrintWriter tf = new PrintWriter(new BufferedWriter(new FileWriter("../TransformedFile.csv")));
    	    while((line2 = br2.readLine()) != null) {
    	    	String[] str = line2.split(line2,',');
    	    	System.out.println("str[0], str[1] "+str[0]+" "+str[1]);
    	    }	    	    
    	    String file1 = "D://rashminagpal//Predicted_Values0.csv";
    	    String line = "";
    	    BufferedReader br1 = null;
    	    br1 = new BufferedReader(new FileReader(file1));
    	    while((line = br1.readLine()) != null) {
    	    	System.out.println(line);
    	    }		    
    	}
    	catch(IOException e) {
    	    	e.printStackTrace();
    	    }  	
    	return new ResponseEntity<Object>(status,HttpStatus.OK); 	    
  } 
    @RequestMapping(value="/next",method=RequestMethod.POST)
        public String next(Model model) {   
            return "nextpage.html";
        }
}

