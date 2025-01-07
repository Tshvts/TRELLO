package utils;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshots {
    public static void main(String[] args) {
        createFileName();
    }

    public static String takeScreenShot(TakesScreenshot screenshot){
        String fileName = createFileName();
        File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scrFile, new File(fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileName;

    }
    private static String createFileName() {
        SimpleDateFormat formater = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
        Date date = new Date(System.currentTimeMillis());
        System.out.println(System.currentTimeMillis());
        System.out.println(date);
        String currentDate = formater.format(date);
        System.out.println(currentDate);
        String fileName = "src/test/resources/screenshots/" + currentDate + ".png";
        return fileName;
    }
}
