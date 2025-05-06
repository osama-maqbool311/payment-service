CREATE TABLE payments (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    booking_id BIGINT             NOT NULL,
    amount DECIMAL(19,4)          NOT NULL,
    payment_time TIMESTAMP        NOT NULL,
    transaction_id VARCHAR(100)   NOT NULL UNIQUE,
    status VARCHAR(30)            NOT NULL
);