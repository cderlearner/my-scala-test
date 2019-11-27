package com.example.myscalatest;

import org.junit.Test;

import java.nio.charset.StandardCharsets;

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
    }
}
