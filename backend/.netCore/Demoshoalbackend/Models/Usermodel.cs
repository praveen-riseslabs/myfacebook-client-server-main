//using System;
//using System.Collections.Generic;
//using System.Linq;
//using System.Threading.Tasks;

//namespace Demoshoalbackend.Models
//{
//    public class Usermodel
//    {
//    }
//    public class User
//    {
//        public int UserId { get; set; }
//        public string Email { get; set; }
//        public string Password { get; set; }
//        public string UserType { get; set; }
//    }

//    public class UserLoginModel
//    {
//        public string Email { get; set; }
//        public string Password { get; set; }
//        public string UserType { get; set; }
//    }

//    public class Customer
//    {
//        public int CustomerID { get; set; }
//        public string FirstName { get; set; }
//        public string LastName { get; set; }
//        public string Email { get; set; }
//        public long Mobile { get; set; }
//    }

//    public class CustomerTransactions
//    {
//        public int TransID { get; set; }
//        public int CustomerID { get; set; }
//        public string TransDate { get; set; }
//        public long Amount { get; set; }
//    }

//    public class CustomerDescripencies
//    {
//        public int DescripenID { get; set; }
//        public int TransID { get; set; }
//        public int CustomerID { get; set; }
//        public string CreatedDate { get; set; }
//        public string Comments { get; set; }
//        public string StatusNotes { get; set; }
//        public bool isApproved { get; set; }
//        public bool IsSynced { get; set; }
//        public string ApprovedOn { get; set; }

//    }
//}
