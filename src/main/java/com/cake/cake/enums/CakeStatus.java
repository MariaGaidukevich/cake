package com.cake.cake.enums;

public enum CakeStatus {
    NOT_READY {
        public String showStatus() {
            return "Не готов";
        }
    },
    IN_PROCESS {
        public String showStatus() {
            return "Готовится";
        }
    },
    READY {
        public String showStatus() {
            return "Готов";
        }
    }
}
