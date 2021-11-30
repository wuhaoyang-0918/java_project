package cn.mybatisplus.number.entity;

import java.time.LocalDate;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author jobob
 * @since 2020-07-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("goodsName")
    private String goodsName;

    @TableField("billStatus")
    private Integer billStatus;

    @TableField("goodsDistrict")
    private Integer goodsDistrict;

    @TableField("goodsPrice")
    private Double goodsPrice;

    @TableField("goodsCount")
    private Integer goodsCount;

    @TableField("creationTime")
    private LocalDate creationTime;


}
