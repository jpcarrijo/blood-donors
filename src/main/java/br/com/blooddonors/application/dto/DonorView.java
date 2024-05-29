package br.com.blooddonors.application.dto;

public record DonorView(

    String name,
    ContactView contactView,
    PhysicalAttributesView physicalAttributesView

) {
}
