package br.com.blooddonors.application.dto;

public record PhysicalAttributesView(

    String sex,
    Double height,
    Integer weight,
    String bloodType

) {
}
