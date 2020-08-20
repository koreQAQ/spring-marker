package org.example.spring.marker.domain;

import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * Created by lishubin on 2020/8/20 11:24 下午
 * @author lishubin
 */
@Builder
@ToString
public class Note {

    @NonNull
    private String id;
    private String content;
    @NonNull
    private String seqNo;
    @NonNull
    private String who;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    
}
