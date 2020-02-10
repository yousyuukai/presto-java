package com.yousyuukai.presto.api.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class PrestoQuery {

    @NotBlank
    private String querySql;

    @NotBlank
    private String target;

}
