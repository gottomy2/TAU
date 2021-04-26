# TAU  
### To repozytorium utworzone na potrzebe zajęć "Testowanie Automatyczne"   
Rozwiązania zadań znajdują się w katalogach odpowiadających numerowi zadania.  

### Lista zadań:  

1. Utworzenie struktury katalogów i dodanie tam swojego projektu lub jego części.  
Wejść na stronę http://junit.sourceforge.net/javadoc/org/junit/Assert.html i wybrać 3 różne assercje, następnie napisać z nimi testy (~10).  
Zaimplementować wyjątek w swoim projekcie.  
   [rozwiązanie](https://github.com/gottomy2/TAU/tree/main/lab1/src)  
   

2. Wybrać 2 strony/aplikacje webowe  
  Przygotować po 3-4 scenariusze testów (opisowe), zamieścić scensariusze w pliku readme.md w repozytorium  
  Napisać testy oparte na tych scenariuszach (użyć 3 różnych przeglądarek)  
  Stworzyć test boundle/scenariusz testów  
   [rozwiązanie](https://github.com/gottomy2/TAU/tree/main/lab2)  
   

3. Instalacja Maven'a/Gradle'a  
Projekt z laboratoriów 1 dostosować do środowiska Mavenowego/Gradleowego  
Dopisanie nowej funkcjonalności w projekcie  
Utworzenie minimum 7 nowych testów  
Dodanie dwóch nowych dependencji  
Utworzenie minimum 3 nowych testów do punktu 5.  
[rozwiązanie](https://github.com/gottomy2/TAU/tree/main/lab3/src)

4. Dodać do projektu Mockito  
Zamockować dwa elementy w projekcie np. 2 różne klasy i napisać przy ich użyciu po 3 testy (dla każdego użyć inny typ zwracany) - użyć when/given    
(dla chętnych) Napisać i użyć stub  
[rozwiązanie](https://github.com/gottomy2/TAU/tree/main/lab4/src)  
   

5. Wyszukanie/utworzenie rest api do testowania:   
   https://github.com/toddmotto/public-apis  
   W dowolnym języku podłączenie się do API
   Napisać testy np.:  
   - niepoprawny request  
   - zawartość poprawnego requestu - czy istnieje  
   - zawartość konkretnych wartości (req -> /country=Poland res -> country: Poland)  
   - zwartość contentu -> klucze  
(dodatkowe) - znaleźć api udostępniające możliwość dodawania danych, a nie tylko odczytywania i napisać testy dot. innej metody niż GET.


6. Utworzyć 3 klasy w pythonie:
- klasę, która będzie przyjmowała jako parametr sterownik (“Windows” lub “Linux”), w niej metody:
    - generowanie help’a - słownik, którego kluczem będzie polecenie shellowe dla odpowiedniego systemu, wartości to parametry w postaci kolejnego słownika, gdzie kluczem będzie parametr, a wartością jego opis
    ```python
    {  
        'ls': {  
            '-l': 'wyświetlanie  szczegółowe',  
            '-la': 'asd asd'  
        }
    }  
    ```
    - wyświetlanie opisu danej komendy, funkcja przyjmuje komendę, zwraca jej opis
- klasę testową, która testować będzie Windowsowe polecenia
- klasę testową, która testować będzie Linuxowe polecenia  
[rozwiązanie](https://github.com/gottomy2/TAU/blob/main/lab6/lab6.py)
