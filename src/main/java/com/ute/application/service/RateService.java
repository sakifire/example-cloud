package com.ute.application.service;

import com.ute.application.entity.Rate;
import com.ute.application.model.request.CreateRateProductRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RateService {
    Rate createRate(CreateRateProductRequest createRateProductRequest,long userId);
}
