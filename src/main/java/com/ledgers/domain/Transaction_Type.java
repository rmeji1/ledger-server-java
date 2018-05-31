package com.ledgers.domain;

public enum Transaction_Type {
	ADDITION {
        @Override
        public String toString() {
            return "ADDITION";

        }
    },
	SUBTRACTION{
        @Override
        public String toString() {
            return "SUBTRACTION";

        }
    }
}
