/**
 * @Title: BaseEntity.java
 * @Package com.cn.alasga.common.core.base
 * @Description: 基础实体
 * @author wanghj
 * @date 2018年3月22日 下午4:23:39
 * @version V1.0
 */
package com.haizhang.hai.bussiness.model.entity;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author wanghj
 * @ClassName: BaseEntity
 * @Description: 基础实体
 * @date 2018年3月22日 下午4:23:39
 */

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@ToString(callSuper = true)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    /**
     * 创建日期
     */
    @CreatedDate
    protected Timestamp createDate;

    /**
     * 更新日期
     */
    @LastModifiedDate
    protected Timestamp updateDate;


}
