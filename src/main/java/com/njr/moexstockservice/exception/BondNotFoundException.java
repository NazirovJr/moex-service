package com.njr.moexstockservice.exception;

public class BondNotFoundException extends RuntimeException {
        public BondNotFoundException(String m) {
            super(m);
        }
    }