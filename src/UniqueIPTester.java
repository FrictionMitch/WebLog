public class UniqueIPTester {
    public void testUniqueIP() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/short-test_log");
        int uniqueIPs = la.countUniqueIPs();
        System.out.println("There are : " + uniqueIPs + " unique IP addresses");
    }

    public void testHightStatusCode() {
        LogAnalyzer la = new LogAnalyzer();
        la.readFile("data/short-test_log");
//        System.out.println(la.printAllHigherThanNum(100));

    }
}
