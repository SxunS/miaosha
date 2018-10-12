package com.example.demo.entity;

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
public class MiaoshaUser extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickname;

    /**
     * MD5( MD5(pass明文 + jsSalt) + DBSalt)
     */
    private String password;

    /**
     * dbSalt
     */
    private String salt;

    /**
     * 头像，云存储的id
     */
    private String head;

    /**
     * 注册时间
     */
    private LocalDateTime registerDate;

    /**
     * 上次登录时间
     */
    private LocalDateTime lastLoginDate;

    /**
     * 登录次数
     */
    private Integer loginCount;


}
