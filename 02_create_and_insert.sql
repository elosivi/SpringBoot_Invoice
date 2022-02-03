USE INVOISE;

DROP TABLE IF EXISTS INVOICE;

CREATE TABLE INVOICE (
  INVOICE_NUMBER BIGINT NOT NULL AUTO_INCREMENT,
  CUSTOMER_NAME VARCHAR(50) NOT NULL,
  ORDER_NUMBER VARCHAR(13),
  PRIMARY KEY(INVOICE_NUMBER)
) ENGINE=InnoDB;

INSERT INTO INVOICE (CUSTOMER_NAME,ORDER_NUMBER) VALUES
  ('John Doe','ON_001'),
  ('Mike Myers','ON_002'),
  ('Benny Hill','ON_003');