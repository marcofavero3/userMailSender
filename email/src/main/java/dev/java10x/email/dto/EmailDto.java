package dev.java10x.email.dto;

import java.util.UUID;

public record EmailDto(
        UUID emailId,
        String emailTo,
        String Emailsubjetc,
        String body
) {
}
