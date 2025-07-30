package com.agrohubconnect.producers.model;

import lombok.Getter;

@Getter
public enum ProducerStatus {
    ACTIVE("Activo"),
    INACTIVE("Inactivo"),
    PENDING_APPROVAL("Pendiente de aprobación"),
    BLOCKED("Bloqueado");

    private final String description;

    ProducerStatus(String description) {
        this.description = description;
    }

}