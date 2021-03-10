using System;
using System.Web.Services;
//using WebApplication.calculatrice;
using WebApplication.com.dneonline.www;

namespace WebApplication {
    /// <summary>
    /// Summary description for WebService1
    /// </summary>
    [WebService(Namespace = "http://tempuri.org/")]
    [WebServiceBinding(ConformsTo = WsiProfiles.BasicProfile1_1)]
    [System.ComponentModel.ToolboxItem(false)]
    // To allow this Web Service to be called from script, using ASP.NET AJAX, uncomment the following line. 
    // [System.Web.Script.Services.ScriptService]
    public class WebService1 : WebService {

        [WebMethod]
        public int HelloWorld() {
            /*            return "Hello World";*/
            Calculator calculator = new Calculator();
            int result = calculator.Add(1, 5);
            Console.Out.WriteLine("la valeur est", result);
            return result;
        }
    }
}
