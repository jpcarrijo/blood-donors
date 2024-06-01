package br.com.blooddonors.domain.protocols;

import br.com.blooddonors.application.dto.DataView;
import org.springframework.web.multipart.MultipartFile;

public interface DonorServicePort {


    DataView saveDonor(MultipartFile file);
}
