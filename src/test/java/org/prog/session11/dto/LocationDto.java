package org.prog.session11.dto;

import lombok.Data;

@Data
public class LocationDto {
    private StreetDto street;
    private String postcode;
}