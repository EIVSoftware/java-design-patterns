package com.eiv.ui.payload;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UpdateDateRequest {

    private LocalDate date;
}
