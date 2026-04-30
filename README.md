EN:
# Extended Calculator in Java

## Project Description

This is a simple graphical calculator written in Java using Swing. The calculator has two modes of operation, implemented through tabs:

- **Basic Mode** - standard arithmetic operations: addition, subtraction, multiplication, division.
- **Extended Mode** - additional mathematical functions: square root, exponentiation, factorial, reciprocal, modulus, trigonometric functions, logarithms, and exponential.

The calculator supports repeated pressing of the "=" button to repeat the last operation, a backspace button (`Undo`), and a clear button (`Clear`).

## Features

- User-friendly interface with two tabs for switching between modes.
- Error handling (division by zero, invalid input).
- Support for repeated calculations with the "=" button.
- `Undo` button to delete the last entered character.
- Uses only standard Java libraries.

## How to Use

1. Run the program (e.g., from an IDE or by compiling with `javac` and running with `java`).

2. At the top of the window is the display field - it shows entered numbers and results.

3. Switch between tabs:
   - **Basic** - for simple arithmetic operations.
   - **Extended** - for additional functions.

4. Entering numbers and operations:
   - Press digits and the decimal point to enter numbers.
   - Press an operator (`+`, `-`, `*`, `/` in basic mode or the corresponding buttons in extended mode).
   - Enter the second number.
   - Press "=" to calculate the result.

5. Additional functions in extended mode:
   - `sqrt` - square root.
   - `x^2` - square of a number.
   - `x^y` - exponentiation (after pressing, enter the exponent and press "=").
   - `!` - factorial (for non-negative integers only).
   - `1/x` - reciprocal.
   - `abs` - absolute value.
   - `sin`, `cos`, `tan` - trigonometric functions (argument in degrees).
   - `log` - base-10 logarithm.
   - `ln` - natural logarithm.
   - `e^x` - exponential function.

6. Control buttons:
   - `Clear` - clear the input field and reset calculations.
   - `Undo` - delete the last entered character.

7. Pressing "=" repeatedly repeats the last calculation with the same operands.

## Requirements

- Java 8 or higher.
- Java Runtime Environment (JRE) or an IDE with Java support.

## Running from the Command Line

1. Compile:

```
javac ExtendedCalculator.java
```

2. Run:

```
java ExtendedCalculator
```

RU:
# Расширенный Калькулятор на Java

## Описание проекта

Это простой графический калькулятор, написанный на Java с использованием Swing. Калькулятор имеет два режима работы, реализованных через вкладки:

- **Базовый режим** - стандартные арифметические операции: сложение, вычитание, умножение, деление.
- **Расширенный режим** - дополнительные математические функции: квадратный корень, возведение в степень, факториал, обратное число, модуль, тригонометрические функции, логарифмы и экспонента.

Калькулятор поддерживает повторное нажатие кнопки "=" для повторения последней операции, кнопку удаления последнего символа (`Отмена`), а также кнопку очистки (`Очистить`).


## Особенности

- Удобный интерфейс с двумя вкладками для переключения между режимами.
- Обработка ошибок (деление на ноль, ввод некорректных данных).
- Поддержка повторных вычислений с кнопкой "=".
- Кнопка `Отмена` для удаления последнего введённого символа.
- Использование только стандартных библиотек Java.


## Как использовать

1. Запустите программу (например, из IDE или скомпилировав через `javac` и запустив `java`).

2. В верхней части окна находится поле вывода - здесь отображаются вводимые числа и результаты.

3. Переключайтесь между вкладками:
    - **Базовый** - для простых арифметических операций.
    - **Расширенный** - для дополнительных функций.

4. Ввод чисел и операций:
    - Нажимайте цифры и точку для ввода чисел.
    - Нажмите оператор (`+`, `-`, `*`, `/` в базовом режиме или соответствующие кнопки в расширенном).
    - Введите второе число.
    - Нажмите "=" для вычисления результата.

5. Дополнительные функции в расширенном режиме:
    - `sqrt` - квадратный корень.
    - `x^2` - квадрат числа.
    - `x^y` - возведение в степень (после нажатия введите степень и нажмите "=").
    - `!` - факториал (только для неотрицательных целых).
    - `1/x` - обратное число.
    - `abs` - модуль числа.
    - `sin`, `cos`, `tan` - тригонометрические функции (аргумент в градусах).
    - `log` - десятичный логарифм.
    - `ln` - натуральный логарифм.
    - `e^x` - экспонента.

6. Кнопки управления:
    - `Очистить` - очистить поле ввода и сбросить вычисления.
    - `Отмена` - удалить последний введённый символ.

7. Повторное нажатие "=" повторяет последнее вычисление с теми же операндами.


## Требования

- Java 8 и выше.
- Среда выполнения Java (JRE) или IDE с поддержкой Java.


## Запуск из командной строки

1. Скомпилируйте:

javac ExtendedCalculator.java

2. Запустите:

java ExtendedCalculator
