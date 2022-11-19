package com.bcgdv.configuration;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Utils {

    private final Parameters parameters;
    public  boolean invalidOrder(List<String> watches)
    {
        List<String> watchesCatalogue = Arrays.asList(parameters.getRolexID(),
          parameters.getMichaelkorsID(),parameters.getSwatchID(),parameters.getCasioID());

        return watches.stream().anyMatch(w -> !watchesCatalogue.contains(w));
    }

}
