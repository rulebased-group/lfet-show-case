package de.lfet.demo.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LFETShowCaseFormData {

    String tarif;
    @Min(0)
    long alter;
}
