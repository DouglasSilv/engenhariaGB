package com.unisinos.trabalhoGB.activity.api;

import com.unisinos.trabalhoGB.activity.dto.CreateActivityDTO;
import com.unisinos.trabalhoGB.activity.dto.PatchActivityDTO;
import com.unisinos.trabalhoGB.activity.service.ActivityService;
import com.unisinos.trabalhoGB.common.dto.ActivityDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/activity")
public class ActivityController {

	private final ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @PostMapping
	public void createActivity(@RequestBody CreateActivityDTO dto) {
		service.createActivity(dto);
	}

	@DeleteMapping("/{activityId}")
	public void delete(@PathVariable String activityId) {
		service.delete(activityId);
	}

	@PatchMapping("/{activityId}")
	public ActivityDTO patch(@PathVariable String activityId, @RequestBody PatchActivityDTO activity) {
		activity.setId(activityId);
		return service.patch(activity);
	}

	@PostMapping("/{activityId}/change-status")
	public void changeStatus(@PathVariable String activityId, @RequestParam boolean isFinished) {
		service.changeStatus(activityId, isFinished);
	}

}
