package com.ikun.entity.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) //用在类上  可以控制json包含的数据  non_null 只传递不为空的属性
public class CustVo {
    /**
     * 客户姓名
     */
    private String name;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 身份证号
     */
    private String cardId;
}
