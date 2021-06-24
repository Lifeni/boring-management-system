package app.lifeni.bms.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Map;

public class JWTUtil {
    private static final String ISSUER = "boring-management-system";
    private static final String KEY = "123456";

    public static String createToken(Map<String, Object> map) {
        try {
            var algorithm = Algorithm.HMAC256(KEY);
            var instance = Calendar.getInstance();
            instance.add(Calendar.SECOND, Constants.EXPIRES);

            return JWT.create()
                    .withIssuer(ISSUER)
                    .withPayload(map)
                    .withExpiresAt(instance.getTime())
                    .sign(algorithm);
        } catch (JWTCreationException exception) {
            return null;
        }
    }

    public static DecodedJWT verifyToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(KEY);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            return null;
        }
    }
}
