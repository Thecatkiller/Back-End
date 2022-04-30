package com.opso.cheapshop.controller;

import org.modelmapper.ModelMapper;
import com.opso.cheapshop.domain.service.TrackingService;
import com.opso.cheapshop.domain.model.Tracking;
import com.opso.cheapshop.resource.TrackingResource;
import com.opso.cheapshop.resource.SaveTrackingResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class TrackingsController {

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private TrackingService trackingService;

    @GetMapping("/trackings")
    public Page<TrackingResource> getAllTrackings(Pageable pageable) {
        Page<Tracking> trackingPage = trackingService.getAllTrackings(pageable);
        List<TrackingResource> resources = trackingPage.getContent()
                .stream()
                .map(this::convertToResource)
                .collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @PostMapping("/trackings/{trackingId}")
    public TrackingResource createTracking(@Valid @RequestBody SaveTrackingResource resource) {
        Tracking tracking = convertToEntity(resource);
        return convertToResource(trackingService.createTracking(tracking));
    }

    @PutMapping("/trackings/{trackingId}")
    public TrackingResource updateTracking(@PathVariable Long trackingId, @Valid @RequestBody SaveTrackingResource resource) {
        Tracking tracking = convertToEntity(resource);
        return convertToResource(trackingService.updateTracking(trackingId, tracking));
    }


    @DeleteMapping("/trackings/{trackingId}")
    public ResponseEntity<?> deleteTracking(@PathVariable Long trackingId) {
        return trackingService.deleteTracking(trackingId);
    }

    private Tracking convertToEntity(SaveTrackingResource resource) {
        return mapper.map(resource, Tracking.class);
    }

    private TrackingResource convertToResource(Tracking entity) {
        return mapper.map(entity, TrackingResource.class);
    }
}