package com.xib.assessment.dto.request.common;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MetaRPO {

    private Integer current;

    private Integer number;

    private Integer pages;

    private Long items;

    private Integer size;

    private String query;

    private String keywords;

    private Map<String, Object> info;

    public Map<String, Object> getInfo() {
        if (null == info)
            info = new HashMap<>();
        return info;
    }
}
