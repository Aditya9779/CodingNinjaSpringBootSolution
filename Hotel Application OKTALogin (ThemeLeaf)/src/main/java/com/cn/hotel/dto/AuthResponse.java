package com.cn.hotel.dto;

import lombok.*;

import java.util.Collection;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthResponse {
    private String userId;
    private String accessToken;
    private long expireAt;
    private Collection<String> authorities;
}
