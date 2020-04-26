package com.example.myscalatest;

import org.junit.Test;

import java.nio.charset.StandardCharsets;
import java.util.concurrent.ThreadLocalRandom;

public class MyJwtTest {

    public static void main(String[] args) {
        String jwt = "eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCJ9.eyJpYXQiOjE1MTYyMzkwMjIsImV4cCI6MTUxNjIzOTAyMywidWlkIjoyNjM5MDQzMzA4fQ.mJ1fWUv7q83sk8MSpuGZn6dkQTCu2kyEcZKl6UqgJpEpNTUeGSXkQ35RqqOUqhvChAekRSFjZpn9mHQORXYPACIfleTJevzQeYkK8jZQA5Qvf1kQEtEU6xu-pzlu5cJMTr3UQV1NmUlLzNNUX1MJ3YmLrXSsyFqNif9RXy08whjxvF3HEA52zw9NldEX1M1uD01EawjDPCcq2yIX44xLFg_BhejqCzZWIo01Lxm9V_gDBlIMceCN-HXQH6EszuPr9Ae6gS54DvYPEbf1IrbDAClVF8X867fNV0bxZ2igYBjOvfDEbUpiv7GPCLHhw_BfYWRZHZxfcLSTAJQ-RVBkbA";
        System.out.println(jwt.getBytes(StandardCharsets.UTF_8).length);

        System.out.println("e".getBytes(StandardCharsets.UTF_8).length);
    }

    @Test
    public void testJJwt() throws Exception {
//        Map claims = new HashMap<>();
//        claims.put("name", "1");
//        claims.put("time", new Date(System.currentTimeMillis()));
//
//        String rst = Jwts.builder()
//                .setClaims(claims)
//                .setExpiration(new Date(System.currentTimeMillis()))
//                .signWith(SignatureAlgorithm.HS256, "secret")
//                .compact();
//        System.out.println(rst);

        String jwt = new JwtUtil().createJWT("1", "uc", System.currentTimeMillis());
        System.out.println(jwt);


        String j = "jwt:eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJuYW1lIjoxMjMsImlzcyI6InVjIiwiZXhwIjoxNTc0OTk1MTY5fQ.VZ7vveGZ23m0TtAZNcLqYomykPXO_Ial389ldd4Zt2is5yzrWsFbd_JHNOgA3dnF9XsEabRbG48b3KF9rap_IQuF_H2kz4gMZtFXiOVejtlT5tge0GigLINDD4FTejNWW8v00g1rdIo-vnF1vuT921RhBornxU-k83Gu-1R0yhIwGOf1D_k0zAfFCqVsjHEqMXCfg0C00RWQfvrUWA-YrX2lVBpdnw4D6CFAwbCZKl-Y2OMFb1_hJMdgOOo2iemvzdcDh_SYsNbdemvUioWQuYp-_wu1BuFEJUQkkV56Llbm0mRDyhsBccXSfvPbA7uWm7VSY4hQ75GQKXKU6gkIyQ";
        System.out.println(j.getBytes(StandardCharsets.UTF_8).length);

        for (;;) {
            System.out.println(ThreadLocalRandom.current().nextInt(100, 500));

            Thread.sleep(1000L);
        }
    }
}
