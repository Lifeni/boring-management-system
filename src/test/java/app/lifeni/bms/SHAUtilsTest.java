package app.lifeni.bms;

import app.lifeni.bms.utils.SHAUtils;
import org.junit.Test;

public class SHAUtilsTest {

    @Test
    public void Test() {
        var str = "123";
        var result = SHAUtils.SHA256(str);
        System.out.println("OUT:");
        System.out.println(result);
    }
}
