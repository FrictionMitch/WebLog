
/**
 * Write a description of class Tester here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import java.util.*;

public class Tester
{
    public void testLogEntry() {
        LogEntry le = new LogEntry("1.2.3.4", new Date(), "example request", 200, 500);
        System.out.println(le);
        LogEntry le2 = new LogEntry("1.2.100.4", new Date(), "example request 2", 300, 400);
        System.out.println(le2);
    }
    
    public void testLogAnalyzer() {
        // complete method
        LogAnalyzer la = new LogAnalyzer();
        System.out.println("Short Test:");
        la.readFile("data/short-test_log");
        la.printAll();
        System.out.println("weblog test:");
        la.readFile("data/weblog-short_log");
        la.printAll();
    }

    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are : " + uniqueIPs + " unique IP addresses");
    }

    public void testStatusCode(int num) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/weblog1_log");
        la.printAllHigherThanNum(num);
    }

    public void testDate(String string) {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/weblog1_log");
        System.out.println(la.uniqueIPVisitsOnDay(string));
    }

    public void testStatus(int low, int high){
        LogAnalyzer la= new LogAnalyzer();
        la.readFile("data/weblog1_log");
        System.out.println(la.countUniqueIPsInRange(low, high));
    }

    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/short-test_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
//        System.out.println(counts.size());
    }
}
