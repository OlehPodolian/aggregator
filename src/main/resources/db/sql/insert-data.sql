INSERT INTO BANKS (name)
  VALUES ('privatbank'),
    ('aval'),
    ('mono');

INSERT INTO CURRENCIES (bank_id, name, buy_rate, sell_rate)
    VALUES
      (1, 'USD', 27.8, 28.2),
      (1, 'EUR', 31.8, 32.2),
      (1, 'RUR', 0.4, 0.42),
      (1, 'YEN', 14.5, 0),
      (2, 'USD', 28.4, 29.2),
      (2, 'EUR', 32.8, 32.9),
      (2, 'RUR', 0.39, 0.45),
      (2, 'YEN', 14.1, 14.6),
      (3, 'USD', 28.2, 28.34),
      (3, 'EUR', 31.68, 32.12),
      (3, 'RUR', 0.4, 0.42),
      (3, 'YEN', 14.5, 15);