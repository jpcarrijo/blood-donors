package br.com.blooddonors.application.dto;

public record DonorView(

    String name,
    String email,
    String sex,
    String bloodType

) {
}
