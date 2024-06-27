package com.unisinos.trabalhoGB.visit.api;

import com.unisinos.trabalhoGB.visit.dto.CreateVisitDTO;
import com.unisinos.trabalhoGB.visit.dto.FindVisitDTO;
import org.springframework.web.bind.annotation.*;

import com.unisinos.trabalhoGB.visit.service.VisitService;

import java.util.List;

@RestController
@RequestMapping("/visit")
public class VisitController {

	private final VisitService service;

    public VisitController(VisitService service) {
        this.service = service;
    }

    @GetMapping
    public List<FindVisitDTO> findAll(
            @RequestParam(required = false) String elderlyId,
            @RequestParam(required = false) String responsableId
    ) {
        return service.findAll(elderlyId, responsableId);
    }

    @PostMapping
	public void createVisit(@RequestBody CreateVisitDTO dto) {
		service.createVisit(dto);
	}

    @PostMapping("/{visitId}/approve")
    public void approve(@PathVariable String visitId) {
        service.approve(visitId);
    }

    @PostMapping("/{visitId}/reprove")
    public void reprove(@PathVariable String visitId) {
        service.reprove(visitId);
    }

    @GetMapping("/waiting-approval")
    public List<FindVisitDTO> findAllWaitingApproval() {
        return service.findAllWaitingApproval();
    }

}
