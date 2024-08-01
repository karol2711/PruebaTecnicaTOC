--Ejercicio 1
CREATE OR REPLACE FUNCTION contar_pacientes_activos(
    p_fecha_inicio DATE DEFAULT NULL,
    p_fecha_fin DATE DEFAULT NULL      
) RETURN INT IS
    v_count INT; 
BEGIN
   
    SELECT COUNT(*)
    INTO v_count
    FROM pacientes
    WHERE estado = 'ACTIVO'
      AND (
         
          p_fecha_inicio IS NULL AND p_fecha_fin IS NULL
          OR
          (
             
              p_fecha_inicio IS NOT NULL
              AND (                 
                  p_fecha_fin IS NULL
                  AND fechacreacion >= p_fecha_inicio
                  AND fechacreacion <= SYSDATE
                  OR
                 
                  p_fecha_fin IS NOT NULL
                  AND fechacreacion >= p_fecha_inicio
                  AND fechacreacion <= p_fecha_fin
              )
          )
      );
    
    RETURN v_count;
END contar_pacientes_activos;
/

--EJERCICIO 2.1 
-- Selecciona los clientes (nombre, teléfono y ciudad) que realizaron compras en diciembre de 2022
-- y cuya ciudad es 'ARMENIA', y cuyo valor total de compras supera los $10’000.000.

SELECT c.NOMBRE, c.TELEFONO, c.CIUDAD
FROM CLIENTES c
JOIN COMPRAS co ON c.IDCLIENTE = co.CLIENTE
JOIN PRODUCTOS_COMPRAS pc ON co.IDCOMPRA = pc.COMPRA
WHERE c.CIUDAD = 'ARMENIA'  
AND co.FECHA BETWEEN '2022-12-01' AND '2022-12-31' 
GROUP BY c.IDCLIENTE, c.NOMBRE, c.TELEFONO, c.CIUDAD
HAVING SUM(pc.TOTAL) > 10000000; 

--EJERCICIO 2.2
-- Selecciona los clientes (nombre, teléfono y ciudad) que han realizado compras
-- donde al menos un producto tiene una descripción que contiene 'TV'
-- y la cantidad comprada de dicho producto es mayor a 2 unidades.

SELECT DISTINCT c.NOMBRE, c.TELEFONO, c.CIUDAD
FROM CLIENTES c
JOIN COMPRAS co ON c.IDCLIENTE = co.CLIENTE
JOIN PRODUCTOS_COMPRAS pc ON co.IDCOMPRA = pc.COMPRA
JOIN PRODUCTOS p ON pc.PRODUCTO = p.IDPROD
WHERE p.DESCRIPCION LIKE '%TV%' 
AND pc.CANTIDAD > 2;  

--EJERCICIO 2.3
-- Selecciona los 5 clientes preferenciales (nombre, teléfono y ciudad) que tienen un valor total de compras superior a $100’000.000
-- Además, muestra la cantidad total de productos comprados y la suma total de compras.

SELECT c.NOMBRE, c.TELEFONO, c.CIUDAD,
       COUNT(pc.PRODUCTO) AS CANTIDAD_TOTAL_PRODUCTOS,  
       SUM(pc.TOTAL) AS SUMA_TOTAL_COMPRAS 
FROM CLIENTES c
JOIN COMPRAS co ON c.IDCLIENTE = co.CLIENTE
JOIN PRODUCTOS_COMPRAS pc ON co.IDCOMPRA = pc.COMPRA
GROUP BY c.IDCLIENTE, c.NOMBRE, c.TELEFONO, c.CIUDAD
HAVING SUM(pc.TOTAL) > 100000000  
ORDER BY SUM(pc.TOTAL) DESC 
LIMIT 5;  

--EJERCICIO 4 
--creacion de una tabla piloto (La cual deberá tener como mínimo valores de
--login, como usuario y contraseña)

CREATE TABLE PERSONA (

  usuario varchar2(50) primary key,
  contraseña varchar2(50)
  estado varchar2(50)
);

--cree un procedimiento donde me permita a mi como usuario poder hacer
--una inserción, una actualización y un cambio de estado a inactivo de un registro.
CREATE OR REPLACE PROCEDURE actualizar_insertarUsuario( usuario varchar, contraseña varchar, estado varchar)
IS
BEGIN 
UPDATE PERSONA 
SET contraseña = contraseña
WHERE usuario = usuario

INSERT INTO PERSONA( usuario, contraseña)
VALUES (usuario,contraseña);

UPDATE PERSONA 
SET estado = estado
WHERE usuario = usuario
END; 













