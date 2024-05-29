package br.com.blooddonors.domain.protocols;

import br.com.blooddonors.application.dto.DonorDTO;
import br.com.blooddonors.application.dto.DonorView;

public interface DonorServicePort {

    DonorView saveDonor(DonorDTO dto);
}
