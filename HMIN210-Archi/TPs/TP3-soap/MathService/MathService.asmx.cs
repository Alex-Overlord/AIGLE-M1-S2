using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Services;

namespace MathService {
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
        public string HelloWorld() {
            return "Hello World";
        }

        [WebMethod]
        public int Add(int a, int b) {
            return (a + b);
        }
        [WebMethod]
        public float Subtract(float A, float B) {
            return (A - B);
        }
        [WebMethod]
        public float Multiply(float A, float B) {
            return A * B;
        }
        [WebMethod]
        public float Divide(float A, float B) {
            if (B == 0) return -1;
            return Convert.ToSingle(A / B);
        }
    }
}
