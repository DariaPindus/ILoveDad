package com.daria.dev.model.size;

public enum GeneralSize implements Size {
    XS {
        @Override
        public String getName() {
            return "X";
        }
    },
    S {
        @Override
        public String getName() {
            return "S";
        }
    },
    M {
        @Override
        public String getName() {
            return "M";
        }
    },
    L {
        @Override
        public String getName() {
            return "L";
        }
    },
    XL {
        @Override
        public String getName() {
            return "XL";
        }
    },

}
