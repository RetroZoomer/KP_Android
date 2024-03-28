package com.RetroZoomer.KP_Android.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.Data;

import java.util.Set;

@Data
public class SignupRequest {
    @NotBlank
    @Size(min = 1, max = 40)
    private String username;

    @NotBlank
    @Size(min = 1, max = 100)
    private String password;

    private Set<String> role;
}
