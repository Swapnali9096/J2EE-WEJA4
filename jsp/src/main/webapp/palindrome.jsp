<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Palindrome Checker</title>
</head>
<body>
    <h1>Palindrome Checker</h1>
    <form action="palindrome.jsp" method="post">
        Enter a number:
        <input type="text" name="number" required>
        <input type="submit" value="Check">
    </form>

    <% 
        String numberStr = request.getParameter("number");
        if (numberStr != null && !numberStr.isEmpty()) {
            int number = Integer.parseInt(numberStr);
            int originalNumber = number;
            int reverse = 0;

            while (number != 0) {
                int digit = number % 10;
                reverse = reverse * 10 + digit;
                number /= 10;
            }

            if (originalNumber == reverse) { %>
                <p><%= originalNumber %> is a palindrome number.</p>
            <% } else { %>
                <p><%= originalNumber %> is not a palindrome number.</p>
            <% }
        } %>
</body>
</html>
