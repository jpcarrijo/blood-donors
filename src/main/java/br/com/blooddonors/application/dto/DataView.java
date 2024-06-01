package br.com.blooddonors.application.dto;

import java.util.List;

public record DataView(

    TotalByState totalByState,
    AverageIMC averageIMC,
    List<ObesePercentage> obesePercentageList,
    AverageBloodTypeByAge averageByAge,
    DonorsToRecipients receivers

) {
}
