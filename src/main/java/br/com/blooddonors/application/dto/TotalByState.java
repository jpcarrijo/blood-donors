package br.com.blooddonors.application.dto;

import java.util.Map;

public record TotalByState(

    Map<String, Integer> byState

) {
}
