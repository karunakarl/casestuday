package org.target.problem1.casestudy;

import java.util.Timer;

import org.target.problem1.casestudy.tasks.FilesArchiveTask;
import org.target.problem1.casestudy.tasks.FilesCopyTask;


public class HealthMonitor 
{
    public static void main( String[] args )
    {
       Timer timer = new Timer();
       timer.scheduleAtFixedRate(new FilesCopyTask(args[0],args[1]), 0, 2*60*1000);
       timer.scheduleAtFixedRate(new FilesArchiveTask(args[1]), 60*1000, 5*60*1000);
    }
}
