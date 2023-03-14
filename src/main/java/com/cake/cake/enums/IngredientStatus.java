package com.cake.cake.enums;

public enum IngredientStatus {
    AVAILABLE{
        public String showStatus() {
            return "Доступен";
        }
    },
    NOT_AVAILABLE{
        public String showStatus() {
            return "Не доступен";
        }
    },
    NOT_IN_USE{
        public String showStatus() {
            return "Не используется";
        }
    }
}
