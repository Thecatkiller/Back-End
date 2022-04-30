package com.opso.cheapshop;

import com.opso.cheapshop.domain.model.Tracking;
import com.opso.cheapshop.domain.repository.TrackingRepository;

import com.opso.cheapshop.domain.service.TrackingService;
import com.opso.cheapshop.exception.*;
import com.opso.cheapshop.service.TrackingServiceImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.Table;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
public class TrackingServiceImplTest {
    @MockBean
    private TrackingRepository trackingRepository;

    @Autowired
    private TrackingService trackingService;


    @TestConfiguration
    static class TrackingServiceImplTestConfiguration {
        @Bean
        public TrackingService trackingService() {
            return new TrackingServiceImpl();
        }
    }
    @Test
    @DisplayName("When getTrackingByDate,ByDescription,ByPlace With Valid Date/Description/Place Then Returns Post")
    public void whenGetTrackingByDateByDescriptionByPlaceWithValidDateDescriptionPlaceThenReturnsPost() {
        // Arrange
        String date = "15/03/1199";
        String description = "Tha best Tracking";
        String place = "PLACE";
        Long id = 1L;
        Tracking tracking = new Tracking().setId(id).setDate(date).setDescription(description).setPlace(place);
        when(trackingRepository.findById(id))
                .thenReturn(Optional.of(tracking));

        // Act
        Tracking foundTracking = trackingService.getTrackingById(id);

        // Assert
        assertThat(foundTracking.getId()).isEqualTo(id);
    }
}