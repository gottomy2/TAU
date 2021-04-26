import unittest


class First:
    def __init__(self, driver):
        self.driver = driver

    dictionary = {
        "windows": {
            "date":
                {
                    "/t": "wyświetla datę",
                    "data": "modyfikuje date"
                },
            "find": {
                "/v": "Wyświetla wszystkie wiersze, które nie zawierają określonego ciągu ciąg.",
                "/c": "Zlicza wiersze zawierające określony ciąg i wyświetla sumę.",
                "/n": "Poprzedza każdy wiersz jego numerem w pliku.",
                "/i": "Określa, że wielkość liter nie jest uwzględniana podczas wyszukiwania.",
            }
        },
        "linux": {
            "ls":
                {
                    "-a": "pokazuje ukryte pliki",
                    "-l": "pokazuje więcej info o pliku"
                },
            "wc":
                {
                    "plik": "wypisze linie słowa i znaki oraz nazwę pliku",
                    "-m": "tylko znaki (lub --chars)",
                    "-l": "tylko linie (lub --lines)",
                    "-w": "tylko słowa (lib --words)"
                }
        }
    }

    def man(self, key):
        if self.driver == 'windows' or self.driver == 'linux':
            try:
                return First.dictionary[self.driver][key]
            except KeyError:
                return KeyError
        else:
            return "Podaj prawidłowy driver: windows || linux"

    def desc(self, key):
        parameters = key.split(" ")
        return First.dictionary[self.driver][parameters[0]][parameters[1]]


class Windows(unittest.TestCase):

    def test_desc_date(self):
        win = First("windows")
        self.assertEqual("wyświetla datę", First.desc(win, "date /t"))

    def test_desc_find(self):
        win = First("windows")
        self.assertEqual("Wyświetla wszystkie wiersze, które nie zawierają określonego ciągu ciąg.",
                         First.desc(win, "find /v"))

    def test_man_date(self):
        win = First("windows")
        self.assertIsNotNone(First.man(win, "date"))

    def test_man_cls(self):
        win = First("windows")
        self.assertEqual(KeyError, First.man(win, "cls"))


class Linux(unittest.TestCase):

    def test_man_ls(self):
        lin = First("linux")
        self.assertIsNotNone(First.man(lin, "ls"))

    def test_desc_ls(self):
        lin = First("linux")
        self.assertEqual("pokazuje ukryte pliki",First.desc(lin, "ls -a"))

    def test_desc_ws(self):
        lin = First("linux")
        self.assertEqual("wypisze linie słowa i znaki oraz nazwę pliku", First.desc(lin, "wc plik"))

    def test_man_rm(self):
        lin = First("linux")
        self.assertEqual(KeyError, First.man(lin, "rs"))