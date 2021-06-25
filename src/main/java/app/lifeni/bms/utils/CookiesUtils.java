package app.lifeni.bms.utils;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class CookiesUtils {
    public static long verifyReturnId(HttpServletRequest request) {
        var cookies = request.getCookies();

        if (cookies != null) {
            var token = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("token")).findFirst();
            if (token.isPresent()) {
                var jwt = JWTUtils.verifyToken(token.get().getValue());
                if (jwt != null) {
                    return jwt.getClaim("id").asLong();
                }
            }
        }
        return -1;
    }

    public static long verifyReturnRole(HttpServletRequest request) {
        var cookies = request.getCookies();

        if (cookies != null) {
            var token = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals("token")).findFirst();
            if (token.isPresent()) {
                var jwt = JWTUtils.verifyToken(token.get().getValue());
                if (jwt != null) {
                    return jwt.getClaim("role").asLong();
                }
            }
        }
        return -1;
    }
}
