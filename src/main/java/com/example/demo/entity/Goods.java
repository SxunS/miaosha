package com.example.demo.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author s_xun_s
 * @since 2018-10-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String goodsName;

    private String goodsTile;

    private String goodsImg;

    private String goodsDetail;

    private BigDecimal goodsPrice;

    private String goodsStock;


}
