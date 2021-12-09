# PBA - Projekt

## Założenia aplikacji
Stworzona aplikacja umożliwia przeglądanie, dodawanie i zmianę przynależności klubowej zawodników z polskiej ligi piłki nożnej.

W bazie danych przechowywani będą zawodnicy. Pojedynczy zawodnik będzie przechowywał swoje dane peronalne (imię, nazwisko, wiek, obywatelstwo, wzrost), przynależność klubową i statystyki(pozycja na boisku, gole, asysty, żółte i czerwone kartki).

Każdy użytkownik będzie miał możliwość wyświetlania danych wszystkich zawodników, konkretnego zawodnika przez podanie jego ID oraz pobranie informacji o wszystkich zawodnikach konkretnej drużyny przez podanie ID drużyny.

Tylko zautoryzowani użytkownicy bedą mogli dodać nowych zawodników czy też aktualizować ich dane i statystyki.
Zautoryzowany użytkownik może również dokonać transferu czyli przenieś użytkownika z drużyny do drużyny przez podanie ID użytkownika i nowej drużyny.
Zautoryzowany użytkownik może również usunąć użytkownika z bazy danych.
Zawodnik również może nie mieć przynależności klubowej wtedy ID drużyny będzie wynosiło 0.

Czyli aplikacja będzie umożliwiała wywołanie następujących funkcji:

1. **GET -> /players**		-> zwróci dane wszystkich zawodników z bazy.

2. **GET -> /player/{ID}**  	-> zwróci dane zawodnika o tym ID.

3. **GET -> /team/{ID}**    	-> zwróci dane wszystkich zawodników z drużyny.

4. **POST -> /player** 	-> tworzy nowego użytkownika, wymagana autoryzacja. Wszystko w body.

5. **PUT -> /transferPlayer/{ID}** -> transferuje zawodnika do nowej drużyny. Nowa drużyna w body.

6. **DELETE -> /player/{ID}**	-> usuwa zawodnika z bazy danych.


## Autor
Kamil Hajdukiewicz