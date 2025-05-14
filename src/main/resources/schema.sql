CREATE TABLE IF NOT EXISTS event (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255),
                       type VARCHAR(255),
                       location VARCHAR(255),
                       date DATE
);
