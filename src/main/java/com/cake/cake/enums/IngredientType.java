package com.cake.cake.enums;

public enum IngredientType {
    BISCUIT{
        public String showType() {
            return "Бисквит";
        }
    },
    CREAM{
        public String showType() {
            return "Крем";
        }
    },
    JAM{
        public String showType() {
            return "Пропитка";
        }
    },
    DECORATION{
        public String showType() {
            return "Украшение";
        }
    },
    ICING{
        public String showType() {
            return "Глазурь";
        }
    }

}
