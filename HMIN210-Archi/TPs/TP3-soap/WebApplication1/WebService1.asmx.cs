using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;
using WebApplication1.com.dneonline.www;
using WebApplication1.gt.gob.banguat.www;

namespace WebApplication1 {
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : System.Web.Services.WebService {

        [WebMethod]
        public string Calculatrice() {
            /*return "Hello World";*/
            Calculator calculator = new Calculator();
            int result = calculator.Add(1, 5);
            Console.Out.WriteLine("la valeur est", result);
            return result.ToString();
        }

        [WebMethod]
        public string Banque() {
            TipoCambio banque = new TipoCambio();
            String result = banque.ToString();

            return result;
        }
    }
}
