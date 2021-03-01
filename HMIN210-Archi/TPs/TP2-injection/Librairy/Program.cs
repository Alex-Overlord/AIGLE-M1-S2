using Ninject;
using Ninject.Modules;
using System;
using System.Collections.Generic;

namespace IoD {
    public class Program {

        public static void Main(string[] args) {
            Console.WriteLine("Hello World IoD!");

            IKernel kernel = new StandardKernel(new Module(2));
            IChargementParametres chargementParametres = kernel.Get<IChargementParametres>();

            ITicketDeCaisse ticketDeCaisse = new TicketDeCaisse(chargementParametres);

            Console.WriteLine(ticketDeCaisse.GetParamClient(12));
        }

        public interface IArticle {
            public double Prix { get; set; }
        }

        public class Article : IArticle {
            public double Prix { get; set; }
        }

        public interface IChargementParametres {
            public CompteClient GetCompteClient(int numeroClient);
            public ParamClient GetParamClient(CompteClient compteClient);
        }

        public class ChargementParametres : IChargementParametres {
            public CompteClient GetCompteClient(int numeroClient) {
                return new CompteClient(numeroClient, new ParamClient("test"));
            }

            public ParamClient GetParamClient(CompteClient compteClient) {
                return compteClient.ParamClient;
            }
        }

        public class ChargementParametres2 : IChargementParametres {
            public CompteClient GetCompteClient(int numeroClient) {
                return new CompteClient(numeroClient, new ParamClient("test2"));
            }

            public ParamClient GetParamClient(CompteClient compteClient) {
                return compteClient.ParamClient;
            }
        }

        public interface ICompteClient {
            public int NumeroClient { get; set; }
            public ParamClient ParamClient { get; set; }
        }

        public class CompteClient : ICompteClient {
            public int NumeroClient { get; set; }
            public ParamClient ParamClient { get; set; }

            public CompteClient(int numeroClient) {
                NumeroClient = numeroClient;
                ParamClient = new ParamClient("testConstructeur");
            }

            public CompteClient(ParamClient paramClient) {
                NumeroClient = 0;
                ParamClient = paramClient;
            }

            public CompteClient(int numeroClient, ParamClient paramClient) {
                NumeroClient = numeroClient;
                ParamClient = paramClient;
            }
        }

        public interface IParamClient {
            public String Param { get; set; }
        }

        public class ParamClient : IParamClient {
            public String Param { get; set; }

            public ParamClient(String param) {
                Param = param;
            }

            public override string ToString() {
                return Param;
            }
        }

        public interface ITicketDeCaisse {
            public List<IArticle> Articles { get; set; }
            public IChargementParametres ChargementParametres { get; set; }

            public void AddArticle(IArticle article);
            public ParamClient GetParamClient(int numeroClient);
        }

        public class TicketDeCaisse : ITicketDeCaisse {
            public List<IArticle> Articles { get; set; }
            public IChargementParametres ChargementParametres { get; set; }

            public TicketDeCaisse(IChargementParametres chargementParametres) {
                ChargementParametres = chargementParametres;
            }

            public void AddArticle(IArticle article) {
                Articles.Add(article);
            }

            public ParamClient GetParamClient(int numeroClient) {
                CompteClient compteClient = ChargementParametres.GetCompteClient(numeroClient);
                return ChargementParametres.GetParamClient(compteClient);
            }
        }

        public class Module : NinjectModule {
            public int Attribut { get; set; }

            public Module(int attribut) {
                Attribut = attribut;
            }

            public override void Load() {
                if (Attribut == 1) {
                    Bind<IChargementParametres>().To<ChargementParametres>();
                } else if (Attribut == 2) {
                    Bind<IChargementParametres>().To<ChargementParametres2>();
                }
            }
        }
    }


}
