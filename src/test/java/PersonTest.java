import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.testng.Assert.assertEquals;
public class PersonTest {
public void currentTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(dtf.format(now));
        }
@BeforeClass
   void beforeClass() {
           System.out.println("Before class");
           currentTime();
           }
@AfterClass
   void afterClass() {
           System.out.println("After class");
           currentTime();
           }

    @DataProvider(name = "isTenageerProvider")
    Object[][] dataProvider() {
        return new Object[][] {
                {3, false},
                {7, false},
                {10, false},
                {12, false},
                {13, true},
                {14, true},
                {16, true},
                {18, true},
                {19, true},
                {20, false},
                {35, false}
        };
    }
    @Test(dataProvider = "isTenageerProvider")
    void testisTeenager(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        assertEquals(result, expected);
    }

}
