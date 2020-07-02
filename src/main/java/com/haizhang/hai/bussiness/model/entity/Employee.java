package com.haizhang.hai.bussiness.model.entity;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author LiJing
 * @ClassName: Employee
 * @Description: 员工表
 * @date 2019/8/1 15:37
 */
@Data
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "T_EMPLOYEE")
public class Employee implements Serializable {

    private static final long serialVersionUID = -9097897857581455509L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String lastName;
    private Integer gender;
    private String email;
    private Integer dId;

}
