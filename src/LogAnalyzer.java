
/**
 * Write a description of class LogAnalyzer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;
import edu.duke.*;

public class LogAnalyzer
{
     private ArrayList<LogEntry> records;
     public ArrayList<String> uniqueIPs;
     
     public LogAnalyzer() {
         // complete constructor
         records = new ArrayList<LogEntry>();
     }
        
     public void readFile(String filename) {
         // complete method
         FileResource resource = new FileResource(filename);
         for(String ipLine : resource.lines()) {
//             LogEntry parseEntry(ipLine);
             WebLogParser wp = new WebLogParser();

             wp.parseEntry(ipLine);

             records.add(wp.parseEntry(ipLine));

//             LogEntry le = WebLogParser.parseEntry(ipLine);
         }
     }

    public HashMap<String, Integer> countVisitsPerIP(){
        HashMap<String, Integer> counts = new HashMap<String, Integer>();
//        int ipCount = 0;
        for(LogEntry le : records) {
            String ip = le.getIpAddress();
            if(! counts.containsKey(ip)){
                counts.put(ip, 1);
            } else {
                counts.put(ip, counts.get(ip) + 1);
            }
        }
        return counts;
    }

    public int countUniqueIPs(){
//        Start an empty array list
        uniqueIPs = new ArrayList<String>();

//        for each element in log entry..
        for(LogEntry le : records) {
            // get IP address out of it
            String ipAddr = le.getIpAddress();
            if(!uniqueIPs.contains(ipAddr)) {
                uniqueIPs.add(ipAddr);
            }
        }

        return uniqueIPs.size();
    }




    public void printAllHigherThanNum(int num){
        ArrayList<Integer> highStatusCode = new ArrayList<Integer>();


        for(LogEntry le : records) {
            int statusCode = le.getStatusCode();
            if(statusCode > num) {
                System.out.println(le);
            }
        }
    }

    public ArrayList<String> uniqueIPVisitsOnDay(String someday){
        ArrayList<String> dayVisited = new ArrayList<String>();
        ArrayList<String> uniqueIP = new ArrayList<String>();
        for(LogEntry le : records) {
            String ip = le.getIpAddress();
            String date = le.getAccessTime().toString();
            String d = date.substring(4, 10);
            if(d.equals(someday) && !uniqueIP.contains(ip)){
                uniqueIP.add(ip);
            }
        }

//        System.out.println(uniqueIP);
        System.out.println(uniqueIP.size());
        return uniqueIP;
    }

    public int countUniqueIPsInRange(int low, int high){
        int statusCount=0;
        ArrayList<String> uniqueIP = new ArrayList<String>();
        for(LogEntry le : records) {
            int status = le.getStatusCode();
            String ip = le.getIpAddress();
            if(!uniqueIP.contains(ip)&&(status >= low && status <= high)){
                uniqueIP.add(ip);
            }
        }
        System.out.println(uniqueIP);
        return uniqueIP.size();
    }

        
     public void printAll() {
         for (LogEntry le : records) {
             System.out.println(le);
         }
     }
     
     
}
