Projekt dotyczący karty kredytowej.

Dodatkowe informacje:
- projekt zrealizowany w technologii Spring z wykorzystaniem REST
- wykonane proste logowanie ( w normalnej aplikacji należałoby użyć SpringSecurity, lecz nie to było głównym celem zadania)
- program wykorzystuje dwie bazy danych. Jeśli główna baza z jakiegoś powodu nie odczytuje wartości wtedy dane pobierane są z zapasowej
- wprowadzono kilka wzorcw projektowych oraz wątki przyspieszające czas realizacji ( metody zapisu i odczytu z bazy są ustawione jako 
synchronized aby nie było możliwości jednoczesnego wykonania zapytań do bazy danych )
