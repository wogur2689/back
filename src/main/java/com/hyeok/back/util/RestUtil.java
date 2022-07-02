package com.hyeok.back.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Slf4j
public class RestUtil {

    private static RestTemplate restTemplate;
    /**
     * //post방식
     * @param url
     */
    public void send(String url, String path){
        URI uri = UriComponentsBuilder
                .fromUriString(url)
                .path(path)
                .encode()
                .build()
                .expand("member")
                .toUri();
        log.info("uri : {}", uri);

        //ResponseEntity<Member> response = restTemplate.postForEntity(uri, member, Member.class);
        //log.info("{}",response.getStatusCode());
        //log.info("{}",response.getHeaders());
        //log.info("{}",response.getBody());
    }
}
