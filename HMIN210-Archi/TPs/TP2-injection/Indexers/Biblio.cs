using System;

namespace Indexers {

    class Biblio<T> {
        private T[] catalogue = new T[1000];

        public T this[int isbn] {
            get => catalogue[isbn];
            set => catalogue[isbn] = value;
        }
    }

    class Program {
        static void Main(string[] args) {
            Console.WriteLine("Programme de test de la classe Biblio.");

            var biblio = new Biblio<string>();
            biblio[042] = "L'histoire sans fin";
            biblio[007] = "Harry Potter";
            biblio[068] = "Le meilleur des Mondes";
            biblio[911] = "Dune";

            for (int i = 0; i < 1000; i++) {
                if (biblio[i] != null) {
                    Console.WriteLine(biblio[i]);
                }
            }
        }
    }
}
