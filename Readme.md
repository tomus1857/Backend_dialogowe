Baza danych H2 database
hasło: password
user name: sa
jdbc url: jdbc:h2:file:D:/baza/aplikacja
http://localhost:8080/h2-console/

endpointy logowanie&rejestracja:
http://localhost:8080/api/auth/register (przyjmuje JSON encji USER - zwraca JSON USER + id)
http://localhost:8080/api/auth/login (przyjmuje JSON USER - if(sukces) zwraca firstName, lastName, email:błędne dane logowania)

endpointy dane
1. dodwanie notatki
   http://localhost:8080/api/data/note?email=tomus1857.2001@o2.pl
Endpoint przyjmuje jako parametr adres email oraz JSON(title i content)
2. dodawanie task
   http://localhost:8080/api/data/task?email=tomus1857.2001@o2.pl
Endpoint przyjmuje to samo co notatka tylko że w jsonie odpowiednie dane dla task
3. wyswietlanie tasków
   http://localhost:8080/api/data/tasks?email=tomus1857.2001@o2.pl
Endpoint przyjmuje jako parametr adres email
4. wyswietlanie notesów
   http://localhost:8080/api/data/notes?email=tomus1857.2001@o2.pl
Endpoint działa analogicznie do tasków
5. usuwanie note
   http://localhost:8080/api/data/note/14?email=tomus1857.2001@o2.pl
endpoint przyjmuje jako pathvariable id notatki do usuniecia oraz jako requestparam email
6. usuwanie task
   http://localhost:8080/api/data/task/14?email=tomus1857.2001@o2.pl
endpoint przyjmuje jako pathvariable id taska oraz jako requestparam email

ENDPOINTY PRZETESTOWANE W POSTMAN - działają