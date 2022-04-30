
package com.opso.cheapshop.domain.service;
import com.opso.cheapshop.domain.model.Tracking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface TrackingService {
    Page<Tracking> getAllTrackings(Pageable pageable);
    Tracking getTrackingById(Long trackingId);
    Tracking createTracking(Tracking tracking);
    Tracking updateTracking(Long trackingId, Tracking trackingRequest);
    ResponseEntity<?> deleteTracking(Long trackingId);
}