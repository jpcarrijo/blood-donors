package br.com.blooddonors.domain.protocols;

import br.com.blooddonors.application.dto.DonorDTO;
import br.com.blooddonors.application.dto.DonorView;

import java.util.List;

public interface DonorServicePort {


    void saveDonor(List<DonorDTO> dtoList);
}
