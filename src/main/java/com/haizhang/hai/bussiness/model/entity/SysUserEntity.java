package com.haizhang.hai.bussiness.model.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author admin_z by 2020/6/30
 * @ClassName
 */
@Entity
@Data
@EntityListeners(AuditingEntityListener.class)
@Table(name = "SYS_USER")
public class SysUserEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 状态:NORMAL正常  PROHIBIT禁用
     */
    private String status;
}