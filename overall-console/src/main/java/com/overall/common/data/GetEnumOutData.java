package com.overall.common.data;

import lombok.Data;

@Data
public class GetEnumOutData {

    private Integer value;

    private String label;

    public GetEnumOutData(Integer value, String label) {
        this.value = value;
        this.label = label;
    }
}
