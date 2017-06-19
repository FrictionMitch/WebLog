import java.util.*;

public class CountTester {
    public void testCounts() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/short-test_log");
        HashMap<String, Integer> counts = la.countVisitsPerIP();
        System.out.println(counts);
    }
}
