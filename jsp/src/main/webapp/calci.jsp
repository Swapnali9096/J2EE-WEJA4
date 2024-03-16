<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Calculator</title>
    <style>
        .calculator {
            width: 250px;
            margin: 50px auto;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f0f0f0;
        }

        .calculator input[type="text"] {
            width: calc(100% - 10px);
            margin-bottom: 10px;
            padding: 10px;
            font-size: 18px;
        }

        .calculator input[type="button"] {
            width: 48px;
            height: 48px;
            margin: 5px;
            padding: 10px;
            font-size: 18px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            background-color: #e6e6e6;
            color: #333;
        }

        .calculator input[type="button"]:hover {
            background-color: #ccc;
        }

        .calculator input[type="button"]:active {
            background-color: #b3b3b3;
        }
    </style>
</head>
<body>
    <div class="calculator">
        <form name="calculatorForm" action="calculator.jsp" method="post">
            <input type="text" name="display" value="${display}">
            <br>
            <input type="button" value="1" onclick="appendToDisplay('1')">
            <input type="button" value="2" onclick="appendToDisplay('2')">
            <input type="button" value="3" onclick="appendToDisplay('3')">
            <input type="button" value="+" onclick="appendToDisplay('+')">
            <br>
            <input type="button" value="4" onclick="appendToDisplay('4')">
            <input type="button" value="5" onclick="appendToDisplay('5')">
            <input type="button" value="6" onclick="appendToDisplay('6')">
            <input type="button" value="-" onclick="appendToDisplay('-')">
            <br>
            <input type="button" value="7" onclick="appendToDisplay('7')">
            <input type="button" value="8" onclick="appendToDisplay('8')">
            <input type="button" value="9" onclick="appendToDisplay('9')">
            <input type="button" value="*" onclick="appendToDisplay('*')">
            <br>
            <input type="button" value="C" onclick="clearDisplay()">
            <input type="button" value="0" onclick="appendToDisplay('0')">
            <input type="button" value="=" onclick="calculate()">
            <input type="button" value="/" onclick="appendToDisplay('/')">
        </form>
    </div>

    <script>
        function appendToDisplay(value) {
            document.getElementsByName("display")[0].value += value;
        }

        function clearDisplay() {
            document.getElementsByName("display")[0].value = '';
        }

        function calculate() {
            var expression = document.getElementsByName("display")[0].value;
            var result = eval(expression);
            document.getElementsByName("display")[0].value = result;
        }
    </script>
</body>
</html>
