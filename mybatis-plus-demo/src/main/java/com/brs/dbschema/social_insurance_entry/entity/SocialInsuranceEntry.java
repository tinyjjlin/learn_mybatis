package com.brs.dbschema.social_insurance_entry.entity;

import java.math.BigDecimal;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 五险一金模板（条目）
 * </p>
 *
 * @author tiny lin
 * @since 2018-12-26
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SocialInsuranceEntry implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 项目名称
     */
    private String itemName;

    /**
     * 项目类型
     */
    private String itemType;

    /**
     * 缴纳方式
     */
    private String payTheWay;

    /**
     * 缴缴基数
     */
    private BigDecimal baseNumber;

    /**
     * 个人缴纳汇率
     */
    private BigDecimal personRate;

    /**
     * 公司缴纳汇率
     */
    private BigDecimal companyRate;

    /**
     * 五险一金名称
     */
    private String category;


}
