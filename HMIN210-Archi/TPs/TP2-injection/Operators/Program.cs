using System;

namespace Operators {
    class Program {

        public class Complexe {
            public double x;
            public double y;
            public double i;
            public Complexe(double x, double y, double i) {
                this.x = x;
                this.y = y;
                this.i = i;
            }

            public static Complexe operator +(Complexe c1, Complexe c2) {
                return new Complexe(c1.x + c2.x, c1.y + c2.y, c1.i + c2.i);
            }
            public static Complexe operator -(Complexe c1, Complexe c2) {
                return new Complexe(c1.x - c2.x, c1.y - c2.y, c1.i - c2.i);
            }
            public static Complexe operator *(Complexe c1, Complexe c2) {
                return new Complexe(c1.x * c2.x, c1.y * c2.y, c1.i * c2.i);
            }

            public override string ToString() {
                return "(" + x + ", " + y + ", " + i + ")";
            }
        }

        static void Main(string[] args) {
            Console.WriteLine("Programme de test des Opérateurs en C#.\n");

            Complexe c1 = new Complexe(1, 2, 0);
            Complexe c2 = new Complexe(5, -3, 2);
            Complexe c3 = new Complexe(-6, 1, -1);

            Console.WriteLine("c1 + c2 = {0}", c1 + c2);
            Console.WriteLine("c2 - c3 = {0}", c2 - c3);
            Console.WriteLine("c3 * c2 = {0}", c3 * c2);
        }
    }
}