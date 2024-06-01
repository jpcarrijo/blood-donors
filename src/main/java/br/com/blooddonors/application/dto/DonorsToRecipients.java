package br.com.blooddonors.application.dto;

import java.util.Map;

public record DonorsToRecipients(

    Map<String, Long> receivers

) {
}
