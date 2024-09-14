package com.example.lead_manager.model.User;

import com.example.lead_manager.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}