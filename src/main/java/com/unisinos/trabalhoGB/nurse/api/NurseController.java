package com.unisinos.trabalhoGB.nurse.api;

import com.unisinos.trabalhoGB.common.dto.ActivityDTO;
import com.unisinos.trabalhoGB.nurse.service.NurseService;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/nurse")
public class NurseController {

	private final NurseService service;

    public NurseController(NurseService service) {
        this.service = service;
    }

    @GetMapping("/{nurseId}/activities")
	public Set<ActivityDTO> getActivitiesByNurse(@PathVariable String nurseId, @RequestParam String elderlyId) {
		return service.getActivitiesByNurse(nurseId, elderlyId);
	}

}
