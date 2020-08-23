package org.example.spring.marker.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * 基本用户实体
 * Created by lishubin on 2020/8/20 11:11 下午
 * @author lishubin
 */
@Builder
@Getter
@Setter
public class Person {

    @NotBlank
    private String id;

    @NotBlank
    private String acctName;

    @NotBlank
    private String password;
    private String acctMail;
    private String nickname;

    @NotNull
    private Gender gender;
    private String preNoteSeqNo;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
