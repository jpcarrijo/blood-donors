package br.com.blooddonors.application.controller;

import br.com.blooddonors.application.dto.DataView;
import br.com.blooddonors.domain.protocols.DonorServicePort;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(maxAge = 3600, origins = "http://localhost:5173")
@RequestMapping("/donors")
public class DonorController {


    final DonorServicePort donorServicePort;

    public DonorController(DonorServicePort donorServicePort) {
	this.donorServicePort = donorServicePort;
    }

    @PostMapping("/save")
    @CacheEvict(value = "cacheDonor", allEntries = true)
    @ResponseStatus(code = HttpStatus.OK)
    public DataView saveDonors(@RequestParam(value = "file",
					     required = true) MultipartFile file) {
	return donorServicePort.saveDonor(file);
    }
}
