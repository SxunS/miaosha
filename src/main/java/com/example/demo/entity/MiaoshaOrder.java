package com.example.demo.entity;

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
public class MiaoshaOrder extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;

    private Long orderId;

    private Long goodsId;


}
