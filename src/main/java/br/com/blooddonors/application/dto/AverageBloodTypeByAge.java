package br.com.blooddonors.application.dto;

import java.util.Map;

public record AverageBloodTypeByAge(

    Map<String, Double> averageByAge

) {
}
