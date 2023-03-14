package com.cake.cake.enums;

public enum PaymentType {
    CASH {
        public String showType() {
            return "Наличными курьеру";
        }
    },
    CARD {
        public String showStatus() {
            return "Картой курьеру";
        }
    }

}
