package com.meditrack.dataaggregation.model.dto;

public record ErrorResponseDTO(String errorCode, String errorMessage, Object additionalInformation) {

}

