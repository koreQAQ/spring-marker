package org.example.spring.marker.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

/**
 * Created by lishubin on 2020/8/20 11:24 下午
 * @author lishubin
 */
@Builder
@ToString
public class Note {

    @NotBlank
    private String id;
    @NotBlank
    private String content;
    @NotBlank
    private String seqNo;
    @NonNull
    private String who;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    
}
