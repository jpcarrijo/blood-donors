package br.com.blooddonors.application.dto;

import jakarta.validation.constraints.*;

public record DonorDTO(
    @Size(min = 5, message = "Nome deve ter no mínimo 5 caracteres")
    String name,

    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "^[0-9]{11}$", message = "O CPF deve conter exatamente 11 dígitos numéricos")
    String cpf,

    @NotBlank(message = "O RG não pode estar em branco")
    @Pattern(regexp = "[0-9]{2}\\.[0-9]{3}\\.[0-9]{3}-[0-9Xx]", message = "O RG deve estar no formato XX.XXX.XXX-X")
    String rg,

    @NotNull(message = "A data não pode ser nula")
    @Past(message = "A data deve estar no passado")
    String dateOfBirth,

    Integer physicalAttributesId,
    Integer parentId,
    Integer addressId,
    Integer contactId

) {
}
