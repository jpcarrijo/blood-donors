package br.com.blooddonors.application.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DonorDTO(
    @Size(min = 5, message = "Nome deve ter no mínimo 5 caracteres")
    @JsonProperty(value = "nome")
    String name,

    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$", message = "O CPF deve conter exatamente 11 dígitos " +
	"numéricos")
    String cpf,

    @NotBlank(message = "O RG não pode estar em branco")
    @Pattern(regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}-\\d$", message = "O RG deve estar no formato XX.XXX.XXX-X")
    String rg,

    @NotNull(message = "A data não pode ser nula")
    @JsonProperty(value = "data_nasc")
    String dateOfBirth,

    @JsonProperty(value = "sexo")
    String sex,
    @JsonProperty(value = "mae")
    String mother,
    @JsonProperty(value = "pai")
    String father,

    @NotNull(message = "Email é necessário")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "O e-mail deve ser válido")
    String email,

    @NotBlank(message = "O CEP é necessário")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve estar no formato 12345-678")
    String cep,

    @NotNull
    @JsonProperty(value = "endereco")
    String address,

    @JsonProperty(value = "numero")
    Integer houseNumber,

    @JsonProperty(value = "bairro")
    String neighborhood,

    @JsonProperty(value = "cidade")
    String city,

    @JsonProperty(value = "estado")
    @Size(min = 2, max = 2, message = "O estado deve estar em forma abreviada")
    String state,

    @JsonProperty(value = "telefone_fixo")
    @Pattern(regexp = "\\(\\d{2}\\) \\d{4}-\\d{4}", message = "O telefone fixo deve estar no formato (XX) XXXX-XXXX")
    String landline,

    @JsonProperty(value = "celular")
    @Pattern(regexp = "\\(\\d{2}\\) 9\\d{4}-\\d{4}", message = "O telefone celular deve estar no formato (XX) " +
	"9XXXX-XXXX")
    String cellPhone,

    @JsonProperty(value = "altura")
    Double height,

    @JsonProperty(value = "peso")
    Integer weight,

    @Pattern(regexp = "^(A|B|AB|O)[+-]$", message = "O tipo sanguíneo deve ser válido (A+, A-, B+, B-, AB+, AB-, O+, " +
	"O-)")
    @JsonProperty(value = "tipo_sanguineo")
    String bloodType
) {
}
