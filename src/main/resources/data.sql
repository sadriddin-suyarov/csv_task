INSERT INTO CITY(CODE, NAME)
SELECT CAST(city_code AS INT),
       city
FROM CSVREAD('src/main/resources/myFile0.csv', NULL, 'charset=UTF-8');