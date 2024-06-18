package com.unisinos.trabalhoGB.elderly.api;

import com.unisinos.trabalhoGB.activity.dto.PersonDTO;
import com.unisinos.trabalhoGB.elderly.service.ElderlyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elderly")
public class ElderlyController {

	private final ElderlyService service;

    public ElderlyController(ElderlyService service) {
        this.service = service;
    }

	@GetMapping
	public List<PersonDTO> findAll() {
		return service.findAll();
	}

}
