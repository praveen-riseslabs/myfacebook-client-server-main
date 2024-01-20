using GraphQLProject.Interfaces;
using GraphQLProject.Models;

namespace GraphQLProject.Services
{
    public class CustomerRepository : ICustomerRepository
    {
        private static List<Customer> CustomerList = new List<Customer>()
        {
            new Customer() {id=0, firstName="SAI", lastName="test1", email="test1@gmail.ocm" , mobile="9879879878"},
            new Customer() {id=1, firstName="laxmi", lastName="test2", email="test2@gmail.ocm" , mobile="8788788788"},
            new Customer() {id=2, firstName="Status", lastName="test2", email="test2@gmail.ocm" , mobile="8788788788"},
            new Customer() {id=3, firstName="Status", lastName="test2", email="test2@gmail.ocm" , mobile="8788788788"},
            new Customer() {id=4, firstName="Status", lastName="test2", email="test2@gmail.ocm" , mobile="8788788788"}
            
        };
        public Customer AddCustomer(Customer customer)
        {
            CustomerList.Add(customer);
            return customer;
        }

        public void DeleteCustomerTransaction(int id)
        {
            CustomerList.RemoveAt(id);
            
        }

        public List<Customer> GetAllCustomers()
        {
            return CustomerList;
        }

        public Customer GetCustomerTransactionsById(int id)

        {
            return CustomerList.Find(m => m.id == id);
        }

        public Customer UpdateCustomerTransaction(int id, Customer customer)
        {
            CustomerList[id] = customer;
            return customer;
        }
    }
}
