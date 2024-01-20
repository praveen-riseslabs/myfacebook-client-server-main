using Demoshoalbackend.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Demoshoalbackend.service
{
    public class CustomerService
    {
        private readonly List<Customer> customers = new List<Customer>();
        private int nextCustomerId = 1;

        public Customer SignUpCustomer(string firstName, string lastName, string email, long mobile)
        {
            var customer = new Customer
            {
                CustomerID = nextCustomerId++,
                FirstName = firstName,
                LastName = lastName,
                Email = email,
                Mobile = mobile
            };

            customers.Add(customer);
            return customer;
        }

        public IEnumerable<Customer> GetCustomers()
        {
            return customers;
        }
    }
}
