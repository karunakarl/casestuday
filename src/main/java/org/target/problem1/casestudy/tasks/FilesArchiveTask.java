package org.target.problem1.casestudy.tasks;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TimerTask;

public class FilesArchiveTask extends TimerTask {
    
    private String securedFolder;
    private String archivedFoler = "d://archive";
    
    public  FilesArchiveTask(String secuedFolder) {
	this.securedFolder = secuedFolder;
    }

    @Override
    public void run() {
	List<String> listOfDeletedFiles = new ArrayList<>();
	List<String> listOfArchivedFiles = new ArrayList<>();
	File file = new File(securedFolder);
	File archivedFolder = new File(archivedFoler);
	archivedFolder.mkdir();
	File[] files = file.listFiles();
	Arrays.sort(files, Comparator.<File>comparingLong(f->f.lastModified()).reversed());
	long sizeOfFolder=0;
	long sizeOfSecured=0;
	for(File f:files){
	    if(f.getName().contains(".exe")||f.getName().contains(".sh")){
		listOfDeletedFiles.add(f.getName());
		f.delete();
	    }else{
		sizeOfFolder=sizeOfFolder+f.length();
		if(sizeOfFolder>1024*1024*100){
		    if(sizeOfSecured==0)
			sizeOfSecured = sizeOfFolder-f.length();
		    try {
			listOfArchivedFiles.add(f.getName());
			Files.move(Paths.get(f.getAbsolutePath()), Paths.get(archivedFoler+"//"+f.getName()));
		    } catch (IOException e) {
			e.printStackTrace();
		    }
		}
	    }
	}
	
	System.out.println("Current size of Secured Folder : "+sizeOfSecured);
	System.out.println("No of Deleted Files :"+listOfDeletedFiles.size());
	listOfDeletedFiles.forEach(System.out::println);
	System.out.println("No of Archived Files :"+listOfArchivedFiles.size());
	listOfArchivedFiles.forEach(System.out::println);
    }
}
