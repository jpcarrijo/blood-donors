package br.com.blooddonors.application.dto;

import java.util.Map;

public record AverageIMC(

    Map<String, Double> average
) {
}
