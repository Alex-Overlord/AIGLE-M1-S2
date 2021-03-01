using System;
using Library;
using static Library.Program;

namespace IoD {
    public class Program {
        public static void Main(string[] args) {
            Console.WriteLine("Hello World IoD!");

            IChargementParametres chargementParametres = new ChargementParametres();
            ITicketDeCaisse ticketDeCaisse = new TicketDeCaisse(chargementParametres);

            Console.WriteLine(ticketDeCaisse.GetParamClient(12));
        }
    }
}
