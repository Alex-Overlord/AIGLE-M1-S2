using System;

namespace ClassLibrary1 {
    public class Class1 {
        string nom;

        public Class1(string nom) {
            this.nom = nom;
        }

        public override string ToString() {
            return nom;
        }
    }
}
