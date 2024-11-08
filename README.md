# Pseudoscience ABCD Guesser

## Description
This program implements the de Jager formula to approximate a user-specified constant (`μ`) using four personal numbers (`w`, `x`, `y`, `z`) and varying exponents (`a`, `b`, `c`, `d`). The program calculates the exponents that minimize the relative error and disproves the "charming theory" by showing cases where the error exceeds 1%.

## Objectives
- Practice using nested loops, arrays, and static methods.
- Validate user input for specific constraints.
- Explore iterative approaches to mathematical approximation.

## Features
1. **ABCDGuesser1**:
   - Uses while loops to find the optimal exponents.
   - Implements input validation with static helper methods:
     - `getPositiveDouble`: Ensures the input is a positive real number.
     - `getPositiveDoubleNotOne`: Ensures the input is a positive real number not equal to 1.
   - Computes and displays the best approximation, exponents, and relative error.

2. **ABCDGuesser2**:
   - Replaces while loops with for loops.
   - Includes additional modular methods to enhance code clarity.

## Technologies Used
- Java
- FormatChecker utility for input validation

## How to Run
1. Clone the repository:
   ```bash
   git clone [repository URL]
