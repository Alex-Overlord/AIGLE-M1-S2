using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using MathConsole2.localhost;
/*using System.Web.Services;
using System.Web;*/

//[WebService(Namespace = "http://tempuri.org/")]
//[WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
//[System.ComponentModel.ToolboxItem(false)]
namespace MathConsole2 {
    public class Program : System.Web.Services.WebService {
        static void Main(string[] args) {
            MathService mathService = new MathService();
            Console.Write("2 + 4 = {0}", mathService.Add(2, 4));
            Console.ReadLine();
        }
    }
}
