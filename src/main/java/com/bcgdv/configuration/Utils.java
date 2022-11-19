package com.bcgdv.configuration;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Utils {
    public  boolean invalidOrder(List<String> watches)
    {
        List<String> watchesCatalogue = Arrays.asList("001","002","003","004");

        return watches.stream().anyMatch(w -> !watchesCatalogue.contains(w));
    }

}
