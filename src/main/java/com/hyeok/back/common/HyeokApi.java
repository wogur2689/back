package com.hyeok.back.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.NonNull;

public class HyeokApi {
    @NonNull
    @JsonProperty(value = "head")
    private CommonResult head;

    @JsonProperty(value = "body")
    private Object body;

    public HyeokApi(@NonNull CommonResult head) {this.head = head;}

    public HyeokApi(@NonNull CommonResult head, Object body) {
        this.head = head;
        this.body = body;
    }
}
