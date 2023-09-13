The application accepts a string of characters via a GET request.
http://localhost:8080/api/frequency-character/<sourse_string>

Returned in the MAP response, the keys of which are the characters from the string,
and the values of their number being in this string.

The source string cannot be empty or contain whitespace characters.

For example:
for request: http://localhost:8080/api/frequency-character/eeaaaaw
a response will be received: {"a":4, "e":2, "w":1}