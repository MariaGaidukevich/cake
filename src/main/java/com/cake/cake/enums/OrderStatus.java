package com.cake.cake.enums;

public enum OrderStatus {
    NEW{
        public String showStatus() {
            return "Новый";
        }
    },
    IN_PROCESS{
        public String showStatus() {
            return "Готовится";
        }
    },
    IN_DELIVERY{
        public String showStatus() {
            return "Передан в доставку";
        }
    },
    CANCELED{
        public String showStatus() {
            return "Отменен";
        }
    },
    DONE{
        public String showStatus() {
            return "Выполнен";
        }
    }
}
