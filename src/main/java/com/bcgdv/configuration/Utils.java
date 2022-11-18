package com.bcgdv.configuration;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class Utils {
    private final Parameters parameters;

    public  boolean invalidOrder(List<String> watches)
    {
        List<String> watchesCatalogue = Arrays.asList("001","002","003","004");

          return watches.stream()
                        .filter(watchesCatalogue::contains)
                         .count()>0;
    }



}
