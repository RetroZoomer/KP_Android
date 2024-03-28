package com.RetroZoomer.KP_Android.payload.response;

import lombok.Data;

import java.util.List;

@Data
public class JwtResponse {
    private String token;
    private String type = "Bearer";
    private Long id;
    private String username;
    private MessageResponse messageResponse;
    private List<String> roles;

    public JwtResponse(String accessToken, Long id, String username, List<String> roles, MessageResponse messageResponse) {
        this.token = accessToken;
        this.id = id;
        this.username = username;
        this.roles = roles;
        this.messageResponse = messageResponse;
    }
}
