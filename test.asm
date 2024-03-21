.MODEL SMALL 
.STACK 100H 
.DATA 
    d1 DW -2
.CODE 
    MAIN PROC FAR 
        MOV AX, @DATA 
        MOV DS, AX 

        ; Завантаження значення, збереженого у змінній d1 
        MOV AX, d1 
  
        ; Виклик процедури для конвертації та виведення значення 
        CALL PRINT 

        ; Вихід з програми
        MOV AH, 4CH 
        INT 21H 
  
    MAIN ENDP 

    ; Процедура для конвертації та виведення значення у бінарному вигляді 
    PRINT PROC 
        ; Ініціалізація лічильника
        MOV CX, 0 
        MOV DX, 0 

    label1:
        ; Перевірка, чи число AX є нулем
        CMP AX, 0 
        JE print1 
  
        ; Ініціалізація BX до 2
        MOV BX, 2 
  
        ; Ділення на 2 для конвертації у бінарний вигляд
        DIV BX 

        ; Запис біта у стек
        PUSH DX 
  
        ; Інкремент лічильника
        INC CX 
  
        ; Очищення DX
        XOR DX, DX 
        JMP label1 

    print1:
        ; Перевірка, чи лічильник більший за нуль
        CMP CX, 0 
        JE exit
  
        ; Витягнення значення зі стеку
        POP DX 
  
        ; Додавання 48 для отримання ASCII-коду цифри
        ADD DL, 48 
  
        ; Виведення на екран
        MOV AH, 02H 
        INT 21H 
  
        ; Декремент лічильника
        DEC CX 
        JMP print1 

    exit: 
        RET 
    PRINT ENDP 

END MAIN