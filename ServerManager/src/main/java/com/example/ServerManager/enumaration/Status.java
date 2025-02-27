package com.example.ServerManager.enumaration;

import lombok.Getter;

@Getter
public enum Status {
    SERVER_UP("SERVER_UP"),
    SERVER_DOWN("SERVER_DOWN");

    private final String status;

    Status(String status) {
        this.status = status;
    }

}
