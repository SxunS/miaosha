package com.example.demo.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
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
public class MiaoshaGoods extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long goodsId;

    private BigDecimal miaoshaPrice;

    private Integer stockCount;

    private LocalDateTime startDate;

    private LocalDateTime endDate;


}
