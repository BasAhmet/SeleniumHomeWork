package homework;

public class Util {
    public static String setChromeProperty(){
        String chromeDriver = "src/resources/drivers/chromedriver.exe";
        return System.setProperty("chromeDriver", chromeDriver);
    }
    public static void sleep(int a) throws InterruptedException {
        Thread.sleep(a*1000);
    }
}
