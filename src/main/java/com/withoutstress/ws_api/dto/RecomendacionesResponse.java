package com.withoutstress.ws_api.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RecomendacionesResponse {
    private String nombre;
    private String link;
}
