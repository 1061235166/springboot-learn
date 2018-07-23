package com.wyk.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by wyk on 2018/4/22.
 */
@ConfigurationProperties(prefix = "hello")
public class HelloConfig {
    private String word;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}
