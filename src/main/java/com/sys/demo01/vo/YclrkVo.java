package com.sys.demo01.vo;

import com.sys.demo01.pojo.Gcmc;
import com.sys.demo01.pojo.Khmc;
import com.sys.demo01.pojo.Yclrk;
import lombok.Data;

@Data
public class YclrkVo extends Yclrk {
    private Gcmc gcmc;
    private String gcmc_name;
    private Khmc khmc;
    private String khmc_name;
}
