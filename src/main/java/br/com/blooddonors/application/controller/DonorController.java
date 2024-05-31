package br.com.blooddonors.application.controller;

import br.com.blooddonors.application.dto.DonorDTO;
import br.com.blooddonors.domain.protocols.DonorServicePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/donors")
public class DonorController {


    final DonorServicePort donorServicePort;

    public DonorController(DonorServicePort donorServicePort) {
	this.donorServicePort = donorServicePort;
    }

    @PostMapping("/save")
    @ResponseStatus(code = HttpStatus.OK)
    public void saveDonors(@RequestBody @Valid List<DonorDTO> dto) {
	donorServicePort.saveDonor(dto);
    }
}
