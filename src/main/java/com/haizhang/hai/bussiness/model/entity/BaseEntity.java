/**
 * @Title: BaseEntity.java
 * @Package com.cn.alasga.common.core.base
 * @Description: 基础实体
 * @author wanghj
 * @date 2018年3月22日 下午4:23:39
 * @version V1.0
 */
package com.haizhang.hai.bussiness.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

/**
 * @author wanghj
 * @ClassName: BaseEntity
 * @Description: 基础实体
 * @date 2018年3月22日 下午4:23:39
 */

@Setter
@Getter
@ToString(callSuper = true)
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected Long id;

    /**
     * 创建日期
     */
    @CreatedDate
    protected Date createDate;

    /**
     * 更新日期
     */
    protected Date updateDate;


}
