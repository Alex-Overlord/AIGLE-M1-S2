using System;

namespace DelegateTest {
    class Program {
        public delegate void DelegateInit(ref int n); // délégué
        public delegate Boolean DelegateDone(ref int n, ref string indice, ref int goal);
        public delegate void DelegateStep(ref int n, ref string indice);

        class MyClass {

            public void Init(ref int n) {
                n = 1;
            }

            public Boolean Done(ref int n, ref string indice, ref int goal) {
                if (n < goal) {
                    indice = "plus";
                    Console.WriteLine("{0} : plus", n);
                    return false;
                } else if (n > goal) {
                    indice = "moins";
                    Console.WriteLine("{0} : moins", n);
                    return false;
                } else {
                    Console.WriteLine("{0} : BINGO !", n);
                    return true;
                }
            }

            public void Step(ref int n, ref string indice) {
                if (indice == "plus") {
                    n *= 2;
                } else if (indice == "moins") {
                    n--;
                }
            }
        }

        static void Main(string[] args) {
            int number = -1;
            string indice = "";
            int goal = 11642;
            MyClass mc = new MyClass();

            DelegateInit dInit = new DelegateInit(mc.Init);
            DelegateDone dDone = new DelegateDone(mc.Done);
            DelegateStep dStep = new DelegateStep(mc.Step);

            dInit(ref number);

            while (!dDone(ref number, ref indice, ref goal)) {
                dStep(ref number, ref indice);
            }


            Console.ReadLine();
        }
    }
}
