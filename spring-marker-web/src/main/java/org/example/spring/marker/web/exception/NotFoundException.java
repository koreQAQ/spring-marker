package org.example.spring.marker.web.exception;

import lombok.Builder;
import lombok.Getter;

/**
 * Created by lishubin on 2020/8/22 10:03 下午
 * @author lishubin
 */
@Builder
@Getter
public class NotFoundException {
    private String message;
    private Throwable origin;
}
