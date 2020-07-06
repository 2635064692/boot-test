package com.haizhang.hai.bussiness.model.entity;


import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author LiJing
 * @ClassName: User
 * @Description: 用户基本实体对象
 * @date 2019/7/30 16:05
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "T_USER")
public class User extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户名
     */
    private String username;
    /**
     * 手机号
     */
    private String mobile;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;
    /**
     * 密码
     */
    private String password;
}
