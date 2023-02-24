package escolasorvete.scrapapi.endpoints;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLOutput;


@RestController
@RequestMapping("/")
public class ScrapTestController {

    @GetMapping
    public ResponseEntity<String> endpoint1() {
        try {
//            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
//            ChromeDriver driver = new ChromeDriver(options);


            WebDriver driver = null;
            try {
//                driver = new RemoteWebDriver(new URL("http://localhost:4444"), options);
//                driver = new RemoteWebDriver(new URL("http://0.0.0.0:4444"), options);
                driver = new RemoteWebDriver(new URL("http://192.168.56.1:4444"), options);

            } catch (MalformedURLException e) {

                    throw new RuntimeException(e.getMessage());

            }

            driver.get("https://www.userede.com.br/");


            String title = driver.findElement(By.className("title")).getText();
            System.out.println("title: " + title);

            driver.quit();


            return ResponseEntity.ok("lujo \uD83E\uDD19");
        } catch (Exception e) {
            System.out.println(e);
            return ResponseEntity.status(HttpStatus.I_AM_A_TEAPOT).body("feo \uD83D\uDC4E");
        }
    }

}
