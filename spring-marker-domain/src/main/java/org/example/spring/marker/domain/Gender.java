package org.example.spring.marker.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by lishubin on 2020/8/20 11:13 下午
 * @author lishubin
 */
@AllArgsConstructor
@Getter
public enum Gender {

    /**
     * 男性
     */
    Male(1),

    /**
     * 女性
     */
    Female(0);

    private int code;


}
