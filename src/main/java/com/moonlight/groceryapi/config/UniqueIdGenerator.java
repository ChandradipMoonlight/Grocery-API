package com.moonlight.groceryapi.config;

import java.util.concurrent.atomic.AtomicLong;

public final class UniqueIdGenerator {
    private final AtomicLong counter = new AtomicLong(0L);
    private final AtomicLong crmCounter = new AtomicLong(0L);
    private final AtomicLong dealerCounter = new AtomicLong(0L);
    private static int hdfcCounter = 0;
    private static int PRODUCT_COUNT = 0;
    private static int USER_COUNT = 0;
    private static int CART_COUNT = 0;
    private static int ORDER_COUNT = 0;
    private final AtomicLong cdTransactionCounter = new AtomicLong(0L);
    private final AtomicLong userLeadCounter = new AtomicLong(0L);
    private final AtomicLong leadCounter = new AtomicLong(0L);
    private static final String serverUniqueId = "A";
    private final AtomicLong customerCounter = new AtomicLong(0L);

    public UniqueIdGenerator() {
    }

    public final String generateNextUniqueId() {
        long id = System.currentTimeMillis() << 10 | this.counter.getAndIncrement() & 1023L;
        return this.serverSpecificUniqueId(Long.toString(id, 36).toUpperCase());
    }

    public final Long generateNextNumericUniqueProductId() {
        Long id = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(1, 10).concat(String.valueOf(PRODUCT_COUNT)));
        PRODUCT_COUNT = (PRODUCT_COUNT+1) % 10;
        return id;
    }

    public final Long generateNextNumericUniqueOrderId() {
        Long id = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(1, 10).concat(String.valueOf(ORDER_COUNT)));
        ORDER_COUNT = (ORDER_COUNT+1) % 10;
        return id;
    }

    public final Long generateNextNumericUniqueCartId() {
        Long id = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(1, 10).concat(String.valueOf(CART_COUNT)));
        CART_COUNT = (CART_COUNT+1) % 10;
        return id;
    }

    public final Long generateNextNumericUniqueUserId() {
        Long id = Long.parseLong(String.valueOf(System.currentTimeMillis()).substring(1, 10).concat(String.valueOf(CART_COUNT)));
        CART_COUNT = (CART_COUNT+1) % 10;
        return id;
    }

    public final String generateNextCRMUniqueId() {
        long id = System.currentTimeMillis() << 10 | this.crmCounter.getAndIncrement() & 1023L;
        return this.serverSpecificUniqueId(Long.toString(id, 36).toUpperCase());
    }


    public final String generateNextCDTransactionId() {
        long id = System.currentTimeMillis() << 10 | this.cdTransactionCounter.getAndIncrement() & 1023L;
        return this.serverSpecificUniqueId(Long.toString(id, 36).toUpperCase());
    }


    public String generateNextUserId() {
        long id = System.currentTimeMillis() << 10 | this.userLeadCounter.getAndIncrement() & 1023L;
        return this.serverSpecificUniqueId(Long.toString(id, 36).toUpperCase());
    }

    public String generateNextLeadId() {
        long id = System.currentTimeMillis() << 10 | this.leadCounter.getAndIncrement() & 1023L;
        return this.serverSpecificUniqueId(Long.toString(id, 36).toUpperCase());
    }

    private String serverSpecificUniqueId(String id) {
        return "A" + id;
    }

    public final String generateNextCustomerId() {
        long id = System.currentTimeMillis() << 10 | this.customerCounter.getAndIncrement() & 1023L;
        return this.serverSpecificUniqueId(Long.toString(id, 36).toUpperCase());
    }


}