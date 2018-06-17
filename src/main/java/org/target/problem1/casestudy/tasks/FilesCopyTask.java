package org.target.problem1.casestudy.tasks;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.TimerTask;

public class FilesCopyTask extends TimerTask {

    private String tempFolder;
     private String securedFolder;
    
    public FilesCopyTask(String tempFolder,String securedFolder) {
	this.tempFolder = tempFolder;
	this.securedFolder = securedFolder;
    }

    @Override
    public void run() {
	try{
	File file = new File(tempFolder);
	File destination = new File(securedFolder);
	destination.mkdir();
	File[] files = file.listFiles();
	for(File f: files){
	   Files.move(Paths.get(f.getAbsolutePath()), Paths.get(securedFolder+"//"+f.getName())); 
	}
	}catch(Exception e){
	    System.out.println(e);
	}
	
    }

}
