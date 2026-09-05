SET SERVEROUTPUT ON
SET VERIFY OFF

DECLARE
    str VARCHAR2(100) := '&String';
    rev VARCHAR2(100) := '';
    i   NUMBER;
BEGIN
    FOR i IN REVERSE 1..LENGTH(str) LOOP
        rev := rev || SUBSTR(str, i, 1);
    END LOOP;

    DBMS_OUTPUT.PUT_LINE('Reversed String: ' || rev);
END;
/

         
---output---
Enter value for string: hello
Reversed String: olleh
