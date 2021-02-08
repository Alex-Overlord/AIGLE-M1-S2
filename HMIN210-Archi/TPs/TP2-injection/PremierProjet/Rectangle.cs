using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using ClassLibrary1;

namespace PremierProjet {
    class Rectangle : Figure {
        double longueur; // champs
        double largeur;
        double Aire { // propriété
            get { return longueur * largeur; }
            set { }
        }

        public Rectangle(double longueur, double largeur) {
            this.longueur = longueur;
            this.largeur = largeur;
        }

        public override String ToString() {
            return base.ToString() + "(" + longueur + ", " + largeur + ")";
        }

        public static void Main(string[] arg) {
            Rectangle rec1 = new Rectangle(2.0, 3.0);
            Console.WriteLine("Rectangle : {0}, Aire : {1}", rec1, rec1.Aire);

            Class1 cl1 = new Class1("Bob");
            Console.WriteLine("Class1 : {0}", cl1);

            Console.ReadLine();
        }
    }
}
