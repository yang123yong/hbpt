package com.sys.demo01.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "yclrk")
public class Yclrk {
    @Id
    @KeySql(useGeneratedKeys = true)
    private long yclrk_id;//主键id
    private String yclrk_no;//编号
    private String yclrk_material_name;//原材料名称
    private String khmc_id;//客户id
    private String gcmc_id;//工程id
    private String yclrk_team;//班组
    private String yclrk_checkout;//检验
    private String yclrk_standard;//规格
    private String yclrk_time;//入库时间
    private String yclrk_amount;//数量
    private String yclrk_amount_damage;//库存折损数量
    private String yclrk_shelves;//是否上架
    private String yclrk_barcode;//条形码
    private String yclrk_barcode_iscreate;//是否生成条形码
    private String yclrk_standard_width;//规格宽
    private String yclrk_standard_height;//规格高
    private String yclrk_ck_time;//出库时间
    private String yclrk_cpsj_time;//上架时间
    private String yclrk_rest_amount;//


}
