using GraphQLProject.Models;
namespace GraphQLProject.Interfaces
{
    public interface ICustomerRepository
    {
        List<Customer> GetAllCustomers();
        Customer GetCustomerTransactionsById(int id);
        Customer AddCustomer(Customer customer);
        Customer UpdateCustomerTransaction(int id, Customer customer);

        void DeleteCustomerTransaction(int id);
       
    }
}
