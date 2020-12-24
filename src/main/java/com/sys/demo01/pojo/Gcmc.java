package com.sys.demo01.pojo;

import lombok.Data;

import java.io.Serializable;

@Data
public class Gcmc implements Serializable {
    private static final long serialVersionUID = 1L;
    private Long gcmc_id;
    private String gcmc_name;
    private Long khmc_id;

}
