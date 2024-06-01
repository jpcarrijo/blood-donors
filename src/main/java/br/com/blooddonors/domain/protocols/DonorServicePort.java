package br.com.blooddonors.domain.protocols;

import br.com.blooddonors.application.dto.DataView;
import br.com.blooddonors.application.dto.DonorDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface DonorServicePort {


    DataView saveDonor(MultipartFile file);
}
